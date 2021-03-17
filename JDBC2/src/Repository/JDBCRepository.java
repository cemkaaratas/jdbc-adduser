package Repository;

public interface JDBCRepository<T,ID>{
    void findAllUser();
    void findUserById(Integer id);
    void insertUser(T t);
    void deleteUserById(Integer id);
    void deleteAllUser();
}
