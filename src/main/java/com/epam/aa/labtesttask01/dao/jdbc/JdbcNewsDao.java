package com.epam.aa.labtesttask01.dao.jdbc;

import com.epam.aa.labtesttask01.dao.DaoFactory;
import com.epam.aa.labtesttask01.dao.NewsDao;
import com.epam.aa.labtesttask01.model.News;
import org.flywaydb.core.internal.dbsupport.JdbcTemplate;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class JdbcNewsDao implements NewsDao {

    public static final String FIND_ALL = "SELECT id, deleted, title, creation_date, brief, content " +
            "FROM news WHERE deleted = 0";
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
        List<News> newsList = jdbcTemplate.query(FIND_ALL,
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

    @Override
    public void deleteByIds(Integer... ids) throws SQLException {
        String sql = constructDeleteByIdsString(ids);
        jdbcTemplate.update(sql);
    }

    private String constructDeleteByIdsString(Integer... ids) {
        StringBuffer sqlBuffer = new StringBuffer("UPDATE news SET deleted = 1 WHERE id in (");
        String prefix = "";
        for (Integer id : ids) {
            sqlBuffer.append(prefix);
            prefix = ",";
            sqlBuffer.append(id);
        }
        sqlBuffer.append(")");

        return sqlBuffer.toString();
    }
}
