package ru.job4j.array;

/**
 * BubbleSort класс.
 */
public class BubbleSort {
    /**
     * sort - сортирует массив пузырьком.
     * @param array входящий массив.
     * @return array.
     */
    public int[] sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
            if (array[j] < array[i]) {
                int k = array[i];
                array[i] = array[j];
                array[j] = k;
            }
         }
        }
        return array;
    }

}
