package ru.job4j.menu;

import java.util.List;

public interface Menu<E>{
    Node<E> getNode(String id, String value, List<Node<E>> list);
    void add(String id, String value);
    void load();
}
