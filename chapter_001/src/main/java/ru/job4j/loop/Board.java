package ru.job4j.loop;

/**
 * Board класс.
 */
public class Board {
    /**
     * Прорисовка фигур.
     * @param width параметр.
     * @param height параметр.
     * @return builder.toString().
     */
    public String paint(int width, int height) {
        int count = 1;
        StringBuilder builder = new StringBuilder();
        for (int j = 1; j <= height; j++) {
            for (int i = 1; i <= width; i++) {
                if (count % 2 != 0) {
                    builder.append("x");
                } else {
                    builder.append(" ");
                }
                count++;
            }
            builder.append(System.getProperty("line.separator"));
        }
        return builder.toString();
    }
}
