package com.epam.aa.labtesttask01.dao.jdbc;

import com.epam.aa.labtesttask01.dao.NewsDao;
import com.epam.aa.labtesttask01.model.News;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class JdbcNewsDao implements NewsDao {

    public static final String FIND_ALL_SQL = "SELECT id, deleted, title, creation_date, brief, content " +
            "FROM news WHERE deleted = 0";
    public static final String FIND_BY_ID_SQL = "SELECT id, deleted, title, creation_date, brief, content FROM news WHERE deleted = 0 AND id = ?";
    public static final String UPDATE_SQL = "UPDATE news SET title = ?, creation_date = ?, brief = ?, content = ? WHERE id = ?";
    public static final String INSERT_SQL = "INSERT INTO news (title, creation_date, brief, content) VALUES (?, ?, ?, ?)";
    private final JdbcTemplate jdbcTemplate;

    public JdbcNewsDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource, false);
    }

    @Override
    public Integer insert(News news) {
        KeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(
                con -> {
                    PreparedStatement ps = con.prepareStatement(INSERT_SQL, new String[] {"id"});
                    ps.setString(1, news.getTitle());
                    ps.setDate(2, new java.sql.Date(news.getDate().getTime()));
                    ps.setString(3, news.getBrief());
                    ps.setString(4, news.getContent());
                    return ps;
                }, holder);
        return holder.getKey().intValue();
    }

    @Override
    public News findById(Integer id) {
        return jdbcTemplate.queryForObject(FIND_BY_ID_SQL, new Object[]{id}, new NewsRowMapper());
    }

    @Override
    public void update(News news) throws SQLException {
        jdbcTemplate.update(UPDATE_SQL,
                news.getTitle(), news.getDate(), news.getBrief(), news.getContent(), news.getId());
    }

    @Override
    public void delete(Integer id) throws SQLException {
        deleteByIds(id);
    }

    @Override
    public List<News> findAll() throws SQLException {
        return jdbcTemplate.query(FIND_ALL_SQL, new NewsRowMapper());
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
