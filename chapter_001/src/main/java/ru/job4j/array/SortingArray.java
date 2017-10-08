package ru.job4j.array;

public class SortingArray {

    /*
    Метод сортировки массива
    */

    public int[] sortingArray(int[] array1, int[] array2) {
        int[] resultArray = new int[array1.length + array2.length];
        int k = 0, ch = 0, index = 0, min = 1000;

        for (int i = 0; i < resultArray.length; i++) {
            if (i < array1.length) {
                resultArray[i] = array1[i];
            } else {
                resultArray[i] = array2[k];
                k++;
            }
        }

        for ( int j = 0; j < resultArray.length; j++ ) {
            ch = j;
            while (ch < resultArray.length) {
                if (min > resultArray[ch]) {
                    min = resultArray[ch];
                    index = ch;
                }
                ch++;
            }
            resultArray[index] = resultArray[j];
            resultArray[j] = min;
            min = 1000;
        }

        return resultArray;
    }
}
