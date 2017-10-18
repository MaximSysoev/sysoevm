package ru.job4j.strategy;

/**
 * Класс Square.
 */
public class Square implements Shape {
    /**
     * Пустой конструктор.
     */
    public Square() {

    }

    /**
     * Реализация метода pic.
     * @return pic.
     */
    @Override
    public String pic() {
        StringBuilder pic = new StringBuilder();
        pic.append("++++\n");
        pic.append("++++\n");
        pic.append("++++");
        return pic.toString();
    }
}
