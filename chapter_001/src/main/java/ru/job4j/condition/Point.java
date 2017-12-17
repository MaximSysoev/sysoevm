package ru.job4j.condition;

/**
 * Point класс.
 */
public class Point {
    /**
     * Переменная х.
     */
    private int x;
    /**
     * Переменная y.
     */
    private int y;

    /**
     * Конструктор класса Point.
     * @param x параметр.
     * @param y параметр.
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Получение х.
     * @return х.
     */
    public int getX() {
        return x;
    }

    /**
     * Получение у.
     * @return у.
     */
    public int getY() {
        return y;
    }

    /**
     * Метод проверки лежит ли точка на прямой.
     * @param a параметр.
     * @param b параметр.
     * @return result параметр.
     */
    public boolean is(int a, int b) {
        boolean result = y == x * a + b ? true : false;
        return result;
    }

}
