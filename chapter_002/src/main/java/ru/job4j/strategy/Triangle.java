package ru.job4j.strategy;

/**
 * Класс Triangle.
 */
public class Triangle implements Shape {
    /**
     * Пустой конструктор.
     */
    public Triangle() {

    }

    /**
     * Реализация метода pic.
     * @return pic.
     */
    @Override
    public String pic() {
        StringBuilder pic = new StringBuilder();
        pic.append("   +   \n");
        pic.append("  +++  \n");
        pic.append(" +++++ \n");
        pic.append("++++++++");
        return pic.toString();
    }

}
