package ru.job4j.simpleContainer;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Container<E> implements SimpleContainer<E>, Iterable<E> {

    private int index = 0;
    private int modCount = 0;
    private int expectedModCount;
    private int indexNext = 0;
    private Object[] container = new Object[1];

    private void setCapacity(Object[] a, Object[] b) {
        for (int i = 0; i < b.length; i++) {
            a[i] = b[i];
        }
    }

    @Override
    public void add(E value) {
        Object[] array = new Object[container.length + 1];
        if (index == 0) {
            container[index] = value;
            index++;
        } else {
            index++;
            setCapacity(array, container);
            array[array.length-1] = value;
            container = new Object[index];
            setCapacity(container, array);
        }
        modCount++;
    }

    @Override
    public E get(int index) {
        return (E) container[index];
    }

    @Override
    public Iterator<E> iterator() {
        if (expectedModCount == 0) {
            expectedModCount = modCount;
        }
        return new SimpleIterator<E>();
    }

    public class SimpleIterator<E> implements Iterator {
        @Override
        public boolean hasNext() {
            boolean result = true;
            if (indexNext + 1 <= container.length) {
                result = true;
            } else {
                result = false;
            }
            return result;
        }

        @Override
        public E next() {
            E value;
            if (expectedModCount == modCount) {
                if (indexNext < container.length && container[indexNext] != null) {
                    value = (E) container[indexNext];
                } else {
                    throw new NoSuchElementException();
                }
            } else {
                throw new ConcurrentModificationException();
            }
            indexNext++;
            return value;
        }
    }
}
