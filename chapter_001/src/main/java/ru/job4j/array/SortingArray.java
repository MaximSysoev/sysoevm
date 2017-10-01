package ru.job4j.array;

public class SortingArray {

    /*
    Метод сортировки массива
    */

    public int[] sortingArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int j = i + 1;
            while (j < array.length) {
                if (array[i] > array[j]) {
                    int k = array[i];
                    array[i] = array[j];
                    array[j] = k;
                }
                j++;
            }
        }
        return array;
    }

    /*
    Метод сложения 2-х массивов в 1
    */

    public int[] additionArrays(int[] a, int[] b) {
        int[] c = new int [a.length + b.length];
        System.arraycopy(a, 0, c, 0, a.length);
        System.arraycopy(b, 0, c, a.length, b.length);
        return c;
    }
}
