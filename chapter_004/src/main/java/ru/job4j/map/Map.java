package ru.job4j.map;
public class Map<K, V> {

    public Entry[] container = new Entry[2];
    private int capacity = 10;
    private int index = 0;

    public Entry[] ensureCapacity(int length) {
        capacity = capacity + length;
        Entry[] array = new Entry[capacity];
        for (int i = 0; i < container.length; i++) {
            if (container[i]!=null) {
                addEntry(array, (K) container[i].key, (V) container[i].value);
            }
        }
        return array;
    }

    public int getCell(Entry[] array, K key) {
        return Math.abs(key.hashCode() % array.length);
    }

    public boolean addEntry(Entry[] array, K key, V value) {
        int cell = getCell(array, key);
        if (array[cell] == null) {
            array[cell] = new Entry(key, value);
            index++;
            return true;
        } else {
            return false;
        }
    }

    public boolean insert(K key, V value) {
        if (index > container.length - 1) {
            container = ensureCapacity(index + 10);
        }
        return addEntry(container, key, value);
    }

    public V get(K key) {
        int cell = getCell(container, key);
        return (V) container[cell];
    }

    public boolean delete(K key) {
        int cell = getCell(container, key);
        if (container[cell] != null) {
            container[cell] = null;
            return true;
        } else {
            return false;
        }
    }
}