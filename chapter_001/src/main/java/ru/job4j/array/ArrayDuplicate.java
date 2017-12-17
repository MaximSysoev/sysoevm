package ru.job4j.array;
import java.util.Arrays;

/**
 * ArrayDuplicate класс.
 */
public class ArrayDuplicate {
    /**
     * Удаляет дубликаты в массиве.
     * @param array параметр.
     * @return Arrays.copyOf(array, unique);
     */
    public String[] removeDuplicates(String[] array) {
        int unique = array.length;
        for (int out = 0; out < unique; out++) {
            for (int in = out + 1; in < unique; in++) {
                if (array[out].equals(array[in])) {
                    array[in] = array[unique - 1];
                    unique--;
                    in--;
                }
            }
        }
        return Arrays.copyOf(array, unique);
    }
}
