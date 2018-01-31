package ru.job4j.simpeArray;
import java.util.*;

public class SimpleArray<T> implements Iterable {
    ArrayList<T> arrayList = new ArrayList<T>();
    int index = 0;

    public void add(T value) {
        arrayList.add(value);
    }

    public void set(int index, T model) {
        arrayList.add(index, model);
    }

    public void delete(int index) {
        arrayList.remove(arrayList.get(index));
    }

    public T get(int index) {
        return arrayList.get(index);
    }

    @Override
    public Iterator<T> iterator() {
        return new SimpleIterator<T>();
    }

    class SimpleIterator<T> implements Iterator<T> {
        @Override
        public boolean hasNext() {
            int value = index + 1;
            boolean result = true;
            if (value <= arrayList.size()) {
                result = true;
            } else {
                result = false;
            }
            return result;
        }

        @Override
        public T next() {
            T value = null;
            if (index < arrayList.size()) {
                value = (T) arrayList.get(index);
            } else {
                throw new NoSuchElementException();
            }
            index++;
            return value;
        }
    }

    public static void main(String[] args) {
        SimpleArray<Integer> simpleArray = new SimpleArray<>();
        simpleArray.add(1);
        simpleArray.add(2);
        simpleArray.add(3);
        System.out.println(simpleArray.iterator().next());
        System.out.println(simpleArray.iterator().next());
        System.out.println(simpleArray.iterator().hasNext());
        System.out.println(simpleArray.iterator().next());
        System.out.println(simpleArray.iterator().hasNext());
    }
}