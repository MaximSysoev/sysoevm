package ru.job4j.store;

public interface Store<T extends Base> {
    void add(T model);
    void replace(String id, T model);
    void delete(String id);
    T findById(String id);
}
