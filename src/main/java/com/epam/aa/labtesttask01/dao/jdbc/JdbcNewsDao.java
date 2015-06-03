package com.epam.aa.labtesttask01.dao.jdbc;

import com.epam.aa.labtesttask01.dao.DaoFactory;
import com.epam.aa.labtesttask01.dao.NewsDao;
import com.epam.aa.labtesttask01.model.News;
import org.flywaydb.core.internal.dbsupport.JdbcTemplate;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class JdbcNewsDao implements NewsDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcNewsDao(Connection connection) {
        this.jdbcTemplate = new JdbcTemplate(connection, 0);
    }

    @Override
    public Integer insert(News news) {
        return null;
    }

    @Override
    public News findById(Integer id) {
        return null;
    }

    @Override
    public boolean update(News news) {
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public List<News> findAll() throws SQLException {
        String sql = "SELECT id, deleted, title, creation_date, brief, content " +
                "FROM news WHERE deleted = 0";
        List<News> newsList = jdbcTemplate.query(sql,
                rs -> {
                    News news = new News();
                    news.setId(rs.getInt("id"));
                    news.setDeleted(rs.getBoolean("deleted"));
                    news.setTitle(rs.getString("title"));
                    news.setDate(rs.getDate("creation_date"));
                    news.setBrief(rs.getString("brief"));
                    news.setContent(rs.getString("content"));
                    return news;
                });
        return newsList;
    }

    public static void main(String[] args) {
        DaoFactory daoFactory = DaoFactory.getInstance("jdbc");
        NewsDao newsDao = daoFactory.getNewsDao();

        List<News> newses = null;
        try {
            newses = newsDao.findAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(newses);
    }
}
