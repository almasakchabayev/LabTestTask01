package dao.jdbc;

import dao.NewsDao;
import model.News;

import java.sql.Connection;

public class JdbcNewsDao implements NewsDao {

    private final Connection connection;

    public JdbcNewsDao(Connection connection) {
        this.connection = connection;
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
}
