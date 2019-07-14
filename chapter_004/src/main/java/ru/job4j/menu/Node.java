package ru.job4j.menu;

public class Node<E> {
    String id;
    String value;
    Node<E> next1;
    Node<E> next2;

    public Node (String id, String value) {
        this.id = id;
        this.value = value;
    }
}
