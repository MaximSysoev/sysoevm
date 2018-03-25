package ru.job4j.listNode;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Container<E> implements Iterable<E> {

    public Node<E> head;
    public Node<E> tail;

    public void add(E value) {
        Node<E> newNode = new Node<>(value);
        if (head == null) {
            head = tail = newNode;  // и head и tail ссылаются на новый узел. Потому что в списке пока только один узел.
        } else {
            tail.next = newNode;    // последний узел начинает ссылаться на новый узел, который добавляется в конец
            tail = tail.next; // перекидываем ссылку tail на новый, только что добавленный в предыдущей строке узел
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new SimpleIterator();
    }

    class SimpleIterator implements Iterator<E> {

        public Node<E> temp = head;

        @Override
        public boolean hasNext() {
           return temp != null;
        }

        @Override
        public E next() {
            E value = null;
            if (hasNext()) {
                value = (E) temp.value;
                temp = temp.next;
            } else {
                throw new NoSuchElementException();
            }
            return value;
        }
    }
}

