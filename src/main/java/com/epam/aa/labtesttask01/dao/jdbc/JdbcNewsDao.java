package com.epam.aa.labtesttask01.dao.jdbc;

import com.epam.aa.labtesttask01.dao.NewsDao;
import com.epam.aa.labtesttask01.model.News;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

public class JdbcNewsDao implements NewsDao {

    public static final String FIND_ALL = "SELECT id, deleted, title, creation_date, brief, content " +
            "FROM news WHERE deleted = 0";
    public static final String FIND_BY_ID = "SELECT id, deleted, title, creation_date, brief, content FROM news WHERE deleted = 0 AND id = ?";
    public static final String UPDATE_NEWS = "UPDATE news SET title = ?, creation_date = ?, brief = ?, content = ?";
    private final JdbcTemplate jdbcTemplate;

    public JdbcNewsDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource, false);
    }

    @Override
    public Integer insert(News news) {
        return null;
    }

    @Override
    public News findById(Integer id) {
        return jdbcTemplate.queryForObject(FIND_BY_ID, new Object[]{id}, new NewsRowMapper());
    }

    @Override
    public void update(News news) throws SQLException {
        jdbcTemplate.update(UPDATE_NEWS,
                news.getTitle(), news.getDate(), news.getBrief(), news.getContent());
    }

    @Override
    public void delete(Integer id) throws SQLException {
        deleteByIds(id);
    }

    @Override
    public List<News> findAll() throws SQLException {
        return jdbcTemplate.query(FIND_ALL, new NewsRowMapper());
    }

    @Override
    public void deleteByIds(Integer... ids) throws SQLException {
        String sql = constructDeleteByIdsString(ids);
        jdbcTemplate.update(sql);
    }

    private String constructDeleteByIdsString(Integer... ids) {
        StringBuilder stringBuilder = new StringBuilder("UPDATE news SET deleted = 1 WHERE id in (");
        String prefix = "";
        for (Integer id : ids) {
            stringBuilder.append(prefix);
            prefix = ",";
            stringBuilder.append(id);
        }
        stringBuilder.append(")");

        return stringBuilder.toString();
    }
}
