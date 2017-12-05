package ru.job4j.Convert;
import java.util.*;

public class ConvertList {

    /**
     * Преобразует массив в коллекцию.
     * @param array - входящий массив.
     * @return list - параметр.
     */
    public List<Integer> toList(int[][] array) {

        int count = 1;
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = count;
                list.add(array[i][j]);
                count++;
            }
        }
        return list;
    }

    /**
     * Разбивает лист на количество строк двумерного массива.
     * @param list коллекция
     * @param rows количество строк
     * @return массив.
     */
    public int[][] toArray(List<Integer> list, int rows) {
        int count = 0;
        int cols;
        int mod;
        int size = list.size();
        if (size < rows) {
            cols = 1;
            mod = 0;
        } else {
            cols = size / rows;
            mod = size % rows;
        }
        if (mod > 1) {
            mod = 1;
        }

        int[][] array = new int[rows][cols + mod];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols + mod; j++) {
                if (count < size) {
                    array[i][j] = list.get(count);
                    count++;
                } else {
                    array[i][j] = 0;
                }
            }
        }
        return array;
    }

    /**
     * Метод конвертирует лист массивов в один лист Integer.
     * @param list - коллекция массивов.
     * @return result - список из элементов массивов.
     */
    public List<Integer> convert(List<int[]> list) {
        int count = 0;
        List<Integer> result = new ArrayList<Integer>();
        for(int[] index : list) {
            int[] arr = index;
            for (int i = 0; i < arr.length; i++) {
                result.add(arr[i]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ConvertList clst = new ConvertList();
        List<int[]> list = new ArrayList<int[]>();
        list.add(new int[] {1, 2, 3});
        list.add(new int[] {4, 5, 6, 7});
        List<Integer> result = clst.convert(list);
        System.out.println(result);
    }

}
