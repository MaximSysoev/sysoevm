package ru.job4j.listNode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Container<E> implements Iterable<E> {

    public Node<E> head;
    public Node<E> tail;
    public Node<E> temp = head;

    public void add(E value) {
        Node<E> newNode = new Node<>(value);
        if (head == null) {
            temp = head = tail = newNode;  // и head и tail ссылаются на новый узел. Потому что в списке пока только один узел.
        } else {
            tail.next = newNode;    // последний узел начинает ссылаться на новый узел, который добавляется в конец
            tail = tail.next; // перекидываем ссылку tail на новый, только что добавленный в предыдущей строке узел
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new simpleIterator();
    }

    class simpleIterator implements Iterator<E> {

        E value = null;
        @Override
        public boolean hasNext() {
            if (temp.value!=null) {
                return true;
            } else {
                return false;
            }
        }

        @Override
        public E next() {
            value = temp.value;
            temp = temp.next;
            return value;
        }
    }
}

