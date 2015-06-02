package dao;

public interface DaoCommand<T> {
    T execute(DaoManager daoManager);
}
