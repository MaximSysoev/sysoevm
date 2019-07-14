package ru.job4j.menu;

public interface Menu<E>{
    Node<E> getNode(String id, int level);
    void add(String id, String value, int level);
    void load();
}
