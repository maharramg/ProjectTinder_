package dao;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Stream;

public interface DAO<T> extends Iterable<T> {

    void read() throws SQLException;

    void add(T data);

    T get(int id);

    List<T> getDatabase();

    Integer size();

    List<Integer> getAllId();

    void clear() throws SQLException;

    Stream<T> stream();

}
