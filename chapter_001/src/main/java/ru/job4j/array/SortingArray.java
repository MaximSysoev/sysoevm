package ru.job4j.array;

public class SortingArray {

    /*
    Метод сортировки массива
    */

    public int[] sortingArray(int[] array1, int[] array2) {
        int[] resultArray = new int[array1.length + array2.length];
        int k = 0;
        for (int i = 0; i < resultArray.length; i++) {
            if (i < array1.length) {
                resultArray[i] = array1[i];
            } else {
                resultArray[i] = array2[k];
                k++;
            }

            for (int j = 0; j < i+1; j++) {
                int ch = j+1;
                while (ch < i + 1) {
                    if (resultArray[j] > resultArray[ch]) {
                        int param = resultArray[j];
                        resultArray[j] = resultArray[ch];
                        resultArray[ch] = param;
                    }
                    ch++;
                }
            }
        }
        return resultArray;
    }


}
