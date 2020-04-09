package ru.job4j.cacheStoringModels;

public class EmulatedCAS {

    private int value;

    public  EmulatedCAS(int value) {
        this.value = value;
    }

    public synchronized int getValue() {
        return value;
    }

    public synchronized int compareAndSwap(int expectedValue, int newValue) {
        int oldValue = value;
        if (value == expectedValue)
            value = newValue;
        return oldValue;
    }

}
