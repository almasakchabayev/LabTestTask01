package com.epam.aa.labtesttask01.dao.jdbc;

import com.epam.aa.labtesttask01.model.News;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NewsRowMapper implements RowMapper<News> {
    @Override
    public News mapRow(ResultSet rs, int rowNum) throws SQLException {
        News news = new News();
        news.setId(rs.getInt("id"));
        news.setDeleted(rs.getBoolean("deleted"));
        news.setTitle(rs.getString("title"));
        news.setDate(rs.getDate("creation_date"));
        news.setBrief(rs.getString("brief"));
        news.setContent(rs.getString("content"));
        return news;
    }
}
