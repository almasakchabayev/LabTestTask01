package dao.jdbc;

import dao.DaoCommand;
import dao.DaoException;
import dao.DaoManager;
import dao.NewsDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class JdbcDaoManager implements DaoManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(JdbcDaoManager.class);

    private final Connection connection;

    public JdbcDaoManager(Connection connection) {
        this.connection = connection;
    }

    @Override
    public <T> T execute(DaoCommand<T> daoCommand) throws DaoException {
        try {
            T result = daoCommand.execute(this);
            return result;
        } finally {
            try {
                connection.close();
                LOGGER.debug("Connection closed, executed properly");
            } catch (SQLException e) {
                throw new DaoException("Connection did not close properly when executing daoCommand", e);
            }
        }
    }

    @Override
    public <T> T transaction(DaoCommand<T> daoCommand) throws DaoException {
        try {
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            throw new DaoException("Could not set autocommit to false", e);
        }
        try {
            T result = daoCommand.execute(this);
            connection.commit();
            return result;
        } catch (SQLException e) {
            try {
                connection.rollback();
                //TODO: add more meaningfull log
                LOGGER.error("Transaction has been rolled back, when processing daoCommand {}", daoCommand);
            } catch (SQLException e1) {
                throw new DaoException("Could not rollback transaction", e1);
            }
            throw new DaoException("Transaction failed", e);
        } finally {
            try {
                connection.setAutoCommit(true);
                LOGGER.debug("transaction executed properly");
            } catch (SQLException e) {
                throw new DaoException("Autocommit could not set to true when executing daoCommand", e);
            }
        }
    }


    @Override
    public NewsDao getNewsDao() {
        return new JdbcNewsDao(connection);
    }

}
