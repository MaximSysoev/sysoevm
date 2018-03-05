package ru.job4j.listNode;

public interface SimpleContainer<E> {
    void add(E value);
    E get(int index);

}