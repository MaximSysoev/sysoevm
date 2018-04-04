package ru.job4j.map;

public class Map<K, V> {

    public Object[] container = new Object[10];
    int capacity = 10;
    private int index = 0;

    public Object[] ensureCapacity(Object[] array, int length) {
        capacity = capacity + length;
        Object[] newArray = new Object[capacity];
        for (int i = 0; i < container.length; i++) {
            if (container[i]!=null) {
                newArray[i] = container[i];
            }
        }
        return newArray;
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
        return (V)container[cell];
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

    public static void main(String[] args) {
        Entry<Integer, String> entry1 = new Entry<>(1, "first");
        Entry<Integer, String> entry2 = new Entry<>(2, "second");
        Entry<Integer, String> entry3 = new Entry<>(3, "third");
        Map<Integer, String> map = new Map<>();
        map.insert(entry1.key, entry1.value);
        map.insert(entry2.key, entry2.value);
        map.insert(entry3.key, entry3.value);
    }
}
