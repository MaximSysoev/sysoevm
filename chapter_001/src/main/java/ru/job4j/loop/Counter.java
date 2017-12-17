package ru.job4j.loop;

/**
 * Counter класс.
 */
public class Counter {
    /**
     * Сложение чётных чисел.
     * @param start параметр.
     * @param finish параметр.
     * @return sum.
     */
    public int add(int start, int finish) {
        int sum = 0;
        for (int i = start; i <= finish; i++) {
            if (i % 2 == 0) {
                sum = sum + i;
            }
        }
        return sum;
    }
}
