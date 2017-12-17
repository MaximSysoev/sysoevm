package ru.job4j.calculator;

/**
 * Calculator класс.
 */
public class Calculator {
    /**
     * Переменная.
     */
    private double result;

    /**
     * Сложение.
     * @param first параметр.
     * @param second параметр.
     */
    public void add(double first, double second) {
        this.result = first + second;
    }

    /**
     * Вычитание.
     * @param first параметр.
     * @param second параметр.
     */
    public void substract(double first, double second) {
        this.result = first - second;
    }

    /**
     * Деление.
     * @param first параметр.
     * @param second параметр.
     */
    public void div(double first, double second) {
        this.result = first / second;
    }

    /**
     * Умноение.
     * @param first параметр.
     * @param second параметр.
     */
    public void multiply(double first, double second) {
        this.result = first * second;
    }

    /**
     * Получение результата.
     * @return result/
     */
    public double getResult() {
        return this.result;
    }
}
