package ru.job4j.cacheStoringModels;

public class OptimisticException extends RuntimeException {

    private int version;
    public OptimisticException(String message) {
       System.out.println(message);
    }
}
