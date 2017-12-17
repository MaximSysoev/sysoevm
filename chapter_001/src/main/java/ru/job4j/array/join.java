package ru.job4j.array;

/**
 * Join класс.
 */
public class Join {
    /**
     * Объединение массивов.
     * @param array1 параметр.
     * @param array2 параметр.
     * @return resultArray.
     */
    public int[] combiningArrays(int[] array1, int[] array2) {
        int[] resultArray = new int[array1.length + array2.length];
        int k = 0;
        for (int i = 0; i < resultArray.length; i++) {
            if (i < array1.length) {
                resultArray[i] = array1[i];
            } else {
                resultArray[i] = array2[k];
                k++;
            }
        }
        return resultArray;
    }
}
