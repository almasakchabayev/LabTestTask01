package com.epam.aa.labtesttask01.dao.jdbc;

import com.epam.aa.labtesttask01.dao.DaoException;
import com.epam.aa.labtesttask01.dao.DaoFactory;
import com.epam.aa.labtesttask01.dao.NewsDao;
import oracle.jdbc.pool.OracleConnectionPoolDataSource;
import oracle.jdbc.pool.OracleDataSource;
import org.flywaydb.core.Flyway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.sql.SQLException;

public class JdbcDaoFactory extends DaoFactory {
    private static final Logger LOGGER = LoggerFactory.getLogger(JdbcDaoFactory.class);

    private static JdbcDaoFactory instance = new JdbcDaoFactory();

    private final DataSource dataSource = initDataSource();

    public static JdbcDaoFactory getInstance() {
        return instance;
    }

    // ----------------SETUP DS-----------------
    private DataSource initDataSource() {
        LOGGER.info("Configuring Jdbc DataSource");

        OracleDataSource dataSource;
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
        flyway.migrate();
        LOGGER.info("Flyway migrations successfully applied");
    }
    // ----------------END SETUP-----------------

    @Override
    public NewsDao getNewsDao() {
        return new JdbcNewsDao(dataSource);
    }
}
