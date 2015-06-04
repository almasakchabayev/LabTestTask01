package com.epam.aa.labtesttask01.dao;

import com.epam.aa.labtesttask01.model.News;

import java.sql.SQLException;
import java.util.List;

public interface NewsDao {
    Integer insert(News news);
    News findById(Integer id) throws SQLException;
    boolean update(News news);
    boolean delete(Integer id);

    List<News> findAll() throws SQLException;

    void deleteByIds(Integer... ids) throws SQLException;
}
