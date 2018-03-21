package ru.job4j.setNode;

import java.util.DuplicateFormatFlagsException;
import java.util.Iterator;

public class SetNode<E> implements Iterable<E> {

    private Node<E> head;
    private Node<E> tail;

    public void add(E value) {
        int result = 0;
        if (head == null) {
            head = tail = new Node<>(value);
        } else {
            Node<E> temp = head;
            while (temp != null) {
                if (value == temp.value) {
                    result = 1;
                    break;
                }
                temp = temp.next;
            }

            if (result == 0) {
                tail.next = new Node<>(value);
                tail = tail.next;
            } else {
                throw new DuplicateFormatFlagsException(value.toString());
            }
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new SetIterator();
    }

    private class SetIterator implements Iterator<E> {

        Node<E> node = head;

        @Override
        public boolean hasNext() {
            return node.next != null;
        }

        @Override
        public E next() {
            Node<E> temp = node;
            node = node.next;
            return temp.value;
        }
    }
}

