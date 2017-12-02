package ru.job4j;

import java.util.*;

/**
 * Класс ArrList - работа с колеекцией ArrayList.
 */
public class TreSet {
    /**
     * Генератор случайных чисел.
     */
    private Random rand = new Random();

    /**
     * Метод add заполняет коллекцию случайными значениями.
     * @param collection - коллекция.
     * @param amount - количество.
     * @return timeConsumedMills - Время выполнения метода add.
     */
    public long add(Collection<String> collection, int amount) {
        long start = System.nanoTime();
        for (int i = 0; i < amount; i++) {
            collection.add(String.valueOf(rand.nextInt(100)));
        }
        long finish = System.nanoTime();
        long timeConsumedMills = finish - start;
        return timeConsumedMills;
    }

    /**
     * Метод delete удаляет из коллекции элементы.
     * @param collection - коллекция.
     * @param amount - количество.
     * @return timeConsumedMills - Время выполнения метода delete.
     */
    public long delete(Collection<String> collection, int amount) {
        TreeSet<String> ts = new TreeSet<String>(collection);
        int count = 0;
        long start = System.nanoTime();
        while (count < amount) {
            ts.pollFirst();
            count++;
        }
        long finish = System.nanoTime();
        long timeConsumedMills = finish - start;
        return timeConsumedMills;
    }

}
