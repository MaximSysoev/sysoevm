package ru.job4j.loop;

/**
 * Factorial класс.
 */
public class Factorial {
    /**
     * Вычисление факториала.
     * @param n параметр.
     * @return fact.
     */
    public int calc(int n) {
        int fact = 1;
        if (n != 0) {
            for (int i = 1; i <= n; i++) {
                fact = fact * i;
            }
        } else {
            fact = 1;
        }
        return fact;
    }
}
