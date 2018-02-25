package ru.job4j.listNode;

import java.util.Iterator;

public class Container<E> implements Iterator<E> {
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

    @Override
    public boolean hasNext() {
        return head.next!=null;
    }

    @Override
    public E next() {
        return head.next.value;
    }
}
