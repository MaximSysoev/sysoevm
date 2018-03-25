package ru.job4j.setNode;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SetNode<E> implements Iterable<E> {

    private Node<E> head;
    private Node<E> tail;
    int result = 0;

    public void searchElement(E value) {
        Node<E> temp = head;
        while (temp != null) {
            if (value.equals(temp.value)) {
                result = 1;
                break;
            }
            temp = temp.next;
        }
    }

    public void add(E value) {
        if (head == null) {
            head = tail = new Node<>(value);
        } else {
            searchElement(value);

            if (result == 0) {
                tail.next = new Node<>(value);
                tail = tail.next;
            } else {
                throw new NoSuchElementException();
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
            return node != null;
        }

        @Override
        public E next() {
            Node<E> temp = node;
            node = node.next;
            return temp.value;
        }
    }
}

