package ru.job4j.array;

public class RotateArray {
    public int[][] rotate(int[][] array) {
        int i = 0, j = 0;
        int [][] b = new int [array.length][array.length];
        for (i = 0; i < array.length; i++) {
            for (j = 0; j < array.length; j++) {
                b[i][j] = array[array.length-j-1][i];
            }
        }
        return b;
    }
}
