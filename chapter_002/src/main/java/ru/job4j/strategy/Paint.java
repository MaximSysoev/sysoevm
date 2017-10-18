package ru.job4j.strategy;

/**
 * Класс paint.
 */
public class Paint {
    /**
     * Свойство result.
     */
    private String result;

    /**
     * Метод прорисовывает фигуру.
     * @param shape ссылка на класс, который реализует метод pic.
     */
    public void draw(Shape shape) {
        this.result = shape.pic();
    }

    /**
     * Получение результата.
     * @return result.
     */
    public String getResult() {
        return result;
    }

}
