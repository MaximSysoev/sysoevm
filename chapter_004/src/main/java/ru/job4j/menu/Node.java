package ru.job4j.menu;

import java.util.ArrayList;
import java.util.List;

public class Node<E> {
    String id;
    String value;
    List<Node<E>> list;

    public Node (String id, String value) {
        this.id = id;
        this.value = value;
        this.list = new ArrayList<>();
    }
}
