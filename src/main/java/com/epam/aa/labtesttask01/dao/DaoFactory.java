package com.epam.aa.labtesttask01.dao;

import com.epam.aa.labtesttask01.dao.jdbc.JdbcDaoFactory;

public abstract class DaoFactory {

    public static final String JDBC = "jdbc";

    public static DaoFactory getInstance(String type) {
        if (type == null)
            throw new NullPointerException("String parameter, representing type of DaoFactory is null");
        if (type.toLowerCase().equals(JDBC))
            return JdbcDaoFactory.getInstance();
        else
            throw new DaoException("Implementation for this type does not exist");
    }
    public abstract NewsDao getNewsDao();
}
