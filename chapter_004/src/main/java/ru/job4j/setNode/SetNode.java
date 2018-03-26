package ru.job4j.setNode;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SetNode<E> implements Iterable<E> {

    private Node<E> head;
    private Node<E> tail;

    public boolean searchElement(E value) {
        boolean result = false;
        Node<E> temp = head;
        while (temp != null) {
            if (value.equals(temp.value)) {
                result = true;
                break;
            }
            temp = temp.next;
        }
        return result;
    }

    public void add(E value) {
        if (head == null) {
            head = tail = new Node<>(value);
        } else {
            if (!searchElement(value)) {
                tail.next = new Node<>(value);
                tail = tail.next;
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
            if (temp!=null) {
                node = node.next;
            } else {
                throw new NoSuchElementException();
            }
            return temp.value;
        }
    }
}

