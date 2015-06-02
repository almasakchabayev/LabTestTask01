package dao;

import model.News;

public interface NewsDao {
    Integer insert(News news);
    News findById(Integer id);
    boolean update(News news);
    boolean delete(Integer id);
}
