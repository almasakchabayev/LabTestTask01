package dao.jdbc;

import dao.DaoException;
import dao.DaoFactory;
import dao.DaoManager;
import oracle.jdbc.pool.OracleConnectionPoolDataSource;
import oracle.jdbc.pool.OracleDataSource;
import org.flywaydb.core.Flyway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.sql.SQLException;

public class JdbcDaoFactory extends DaoFactory {
    private static final Logger LOGGER = LoggerFactory.getLogger(DaoFactory.class);
    public static final String HIKARI_PROPERTIES = "/hikari.properties";

    private static JdbcDaoFactory instance = new JdbcDaoFactory();

    private final DataSource dataSource = initDataSource();

    public static JdbcDaoFactory getInstance() {
        return instance;
    }

    // ----------------SETUP DS-----------------
    private DataSource initDataSource() {
        LOGGER.info("Configuring Jdbc DataSource");

        OracleDataSource dataSource = null;
        try {
            dataSource = new OracleConnectionPoolDataSource();
        } catch (SQLException e) {
            throw new DaoException("DataSource could not be initialized");
        }
        dataSource.setURL("jdbc:oracle:thin:@//localhost:1521/labtesttask01");
        dataSource.setUser("labtesttask01");
        dataSource.setPassword("labtesttask01");

        applyMigrations(dataSource);

        LOGGER.info("Jdbc DataSource configured successfully");
        return dataSource;
    }

    private void applyMigrations(DataSource ds) {
        Flyway flyway = new Flyway();
        flyway.setDataSource(ds);
        flyway.clean();
        flyway.migrate();
        LOGGER.info("Flyway migrations successfully applied");
    }
    // ----------------END SETUP-----------------

    @Override
    public DaoManager createDaoManager() {
        // todo ask if rethrow exception or just add to method
        try {
            return new JdbcDaoManager(dataSource.getConnection());
        } catch (SQLException e) {
            throw new DaoException("Could not get connection from dataSource", e);
        }
    }
}
