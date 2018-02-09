package ru.job4j.simpleContainer;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Container<E> implements SimpleContainer<E>, Iterable<E> {

    private int index = 0;
    private int modCount = 0;
    private int expectedModCount = 0;
    private int indexNext = 0;
    private Object[] container = new Object[10];

    public Object[] ensureCapacity(Object[] source, int capacity) {
        return Arrays.copyOf(source, capacity);
    }

    @Override
    public void add(E value) {
        if (index > 9) {
            container = ensureCapacity(container, index + 1);
            container[index] = value;
        }
        container[index] = value;

        index++;
        modCount++;
    }

    @Override
    public E get(int index) {
        return (E) container[index];
    }

    @Override
    public Iterator<E> iterator() {
        return new SimpleIterator<E>();
    }

    public class SimpleIterator<E> implements Iterator {

        public void exceptions() throws ConcurrentModificationException, NoSuchElementException {
            if (expectedModCount == 0) {
                expectedModCount = modCount;
            }

            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException();
            }

            if (!hasNext()) {
                throw new NoSuchElementException();
            }
        }

        @Override
        public boolean hasNext() {
            return indexNext < index;
        }

        @Override
        public E next() {
            exceptions();
            return (E)container[indexNext++];
        }
    }

    public static void main(String[] args) {
        Container<Integer> container = new Container<>();
        container.add(0);
        container.add(1);
        container.add(2);
        container.add(3);
        container.add(4);
        container.add(5);
        container.add(6);
        container.add(7);
        container.add(8);
        container.add(9);
        container.add(10);
        container.add(11);

    }
}
