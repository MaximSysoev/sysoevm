package ru.job4j.map;

public class Entry<K, V> {
    public K key;
    public V value;
    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }
}