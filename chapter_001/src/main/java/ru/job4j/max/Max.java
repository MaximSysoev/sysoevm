package ru.job4j.max;

/**
 * Max - класс.
 */
public class Max {
    /**
     * Метод max - находит максимальное из 2-х чисел.
     * @param first 1-й параметр.
     * @param second 2-й параметр.
     * @return maxvalue.
     */
    public int max(int first, int second) {
        int maxvalue = first  < second ? second : first;
        return maxvalue;
    }

    /**
     * Метод max - находит максимальное из 3-х чисел.
     * @param first 1-й параметр.
     * @param second 2-й параметр.
     * @param third 3-й параметр.
     * @return result.
     */
    public int max(int first, int second, int third) {
        int maxValue = this.max(first, second);
        int result = this.max(maxValue, third);
        return result;
    }
}
