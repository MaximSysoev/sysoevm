package ru.job4j.array;

/**
 * Turn класс.
 */
public class Turn {
    /**
     * back переворот массива слева направо.
     * @param array параметр.
     * @return array.
     */
    public int[] back(int[] array) {
        int[] result = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[array.length - i - 1];
        }
        return result;
    }
}
