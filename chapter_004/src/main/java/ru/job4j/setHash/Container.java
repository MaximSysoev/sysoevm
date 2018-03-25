package ru.job4j.setHash;
import java.util.Arrays;

public class Container {

    SetHash[] container = new SetHash[10];
    private int index = 0;

    public SetHash[] ensureCapacity(SetHash[] source, int capacity) {
        return Arrays.copyOf(source, capacity);
    }

    public void add (SetHash setHash) {
        int result = 0;
        if (index > container.length - 1) {
            container = ensureCapacity(container, index + 10);
        }
        int cell = Math.abs(setHash.hashCode() % container.length);
        if (container[cell] == null) {
            container[cell] = setHash;
            index++;
        }
    }

    public boolean contains(String value) {
        boolean result = false;
        for (int i = 0; i < container.length; i++) {
            if (container[i] != null) {
                if (container[i].getValue() == value) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    public boolean remove(String value) {
        boolean result = false;
        for (int i = 0; i < container.length; i++) {
            if (container[i] != null) {
                if (container[i].getValue() == value) {
                    container[i] = null;
                    result = true;
                }
            }
        }
        return result;
    }
}
