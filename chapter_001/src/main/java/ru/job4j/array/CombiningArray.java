package ru.job4j.array;

public class CombiningArray {

    public int[] combining(int[] array1, int[] array2) {

        int[] resultArray = new int[array1.length + array2.length];
        int i = 0, j = 0, k = 0, index = 0, min = 1000, arr = 1, n = 0, ch1 = 0, ch2 = 0, move1=0, move2=0;

        for (k = 0; k < resultArray.length; k++) {

            if (n < array1.length) {
                // Нахожу минимальное значение в двух массивах и запоминаю индекс
                for (i = n; i < array1.length; i++) {

                    min = array1[i];
                    index = i;
                    arr = 1;
                    for (j = ch2; j < array2.length; j++) {
                        if (min > array2[j]) {
                            min = array2[j];
                            index = j; // позиция найденного элемента в массиве
                            arr = 2; // в массиве array2 найдено минимальное значение
                        }
                    }

                    // Сравнивается полученый min с массивом эл-в array1
                    for (j = ch1; j < array1.length; j++) {
                        if (min > array1[j]) {
                            min = array1[j];
                            index = j; // позиция найденного элемента в массиве
                            arr = 1; // в массиве array1 найдено минимальное значение
                        }
                    }

                    // В зависимости от массива в котором найдено минимальное значение, вычисляю позицию
                    // элемента и делаю к позиции move+1
                    if (arr == 1) {
                        // меняю местами минимальынй найденный и move+1 элемент и увеличиваю счётчики
                        array1[index] = array1[move1];
                        array1[move1] = min;
                        ch1++;
                        move1++;
                        n++;
                    } else if (arr == 2) {
                        // меняю местами минимальынй найденный и move+1 элемент и увеличиваю счётчики
                        array2[index] = array2[move2];
                        array2[move2] = min;
                        ch2++;
                        move2++;
                    }
                    break;
                }
            } else {
                min = 1000;
                for (j = ch2; j < array2.length; j++) {
                    if (min > array2[j]) {
                        min = array2[j];
                        index = j;
                        arr = 2;
                    }
                }
                ch2++;
            }
            resultArray[k] = min;
        }
        return resultArray;
    }
}
