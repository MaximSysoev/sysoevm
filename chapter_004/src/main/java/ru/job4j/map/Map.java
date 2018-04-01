package ru.job4j.map;

import java.util.Arrays;

public class Map<K, V> {

    public Object[] container = new Object[10];
    private int index = 0;

    public Object[] ensureCapacity(Object[] array, int length) {
        return Arrays.copyOf(array, length);
    }

    public int getCell(K key) {
        return Math.abs(key.hashCode() % container.length);
    }

    public boolean insert(K key, V value) {

        if (index > container.length - 1) {
            container = ensureCapacity(container, index + 10);
        }

        int cell = getCell(key);

        if (container[cell] == null) {
            container[cell] = value;
            index++;
            return true;
        } else {
            return false;
        }
    }

    public V get(K key) {
        int cell = getCell(key);
        if (container[cell]!=null) {
            return (V)container[cell];
        } else {
            return null;
        }
    }

    public boolean delete(K key) {
        int cell = getCell(key);
        if (container[cell]!=null) {
            container[cell] = null;
            return true;
        } else {
            return false;
        }
    }
}
