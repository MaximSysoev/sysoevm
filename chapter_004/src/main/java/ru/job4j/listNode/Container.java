package ru.job4j.listNode;

public class Container<E> {
    public Node<E> head;
    public Node<E> tail;

    public void add(E value) {
        if (head == null) {
            head = new Node<>(value);
            tail = head;
        } else {
            head.next = new Node<>(value);
            tail = head.next;
        }
    }
}
