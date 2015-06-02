package dao;

public interface DaoManager {
    <T> T execute(DaoCommand<T> daoCommand) throws DaoException;
    <T> T transaction(DaoCommand<T> daoCommand) throws DaoException;
    default <T> T executeTx(DaoCommand<T> daoCommand) throws DaoException {
        return execute(daoManager -> daoManager.transaction(daoCommand));
    }

    NewsDao getNewsDao();
}