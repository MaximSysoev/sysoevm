package ru.job4j.calculator;

/**
 * Calculator класс.
 */

public class Calculator {

    private double result;

    public Calculator() {

    }

    public void add(double first, double second) {
        result = first + second;
        System.out.println("Результат: " + result);
    }

    public void substract(double first, double second) {
        result = first - second;
        System.out.println("Результат: " + result);
    }

    public void multiply(double first, double second) {
        result = first * second;
        System.out.println("Результат: " + result);
    }

    public void div(double first, double second) {
        result = first / second;
        System.out.println("Результат: " + result);
    }

    public double getResult() {
        return result;
    }
}
