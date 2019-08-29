package ru.job4j.crosseZeros;

public class GameBoard {

    private int dimension;
    private String[][] arr;

    public GameBoard (int dimension) {
        this.dimension = dimension;
        this.arr = new String[dimension][dimension];
    }

    public int getDimension() {
        return dimension;
    }

    public String[][] getArr() {
        return arr;
    }

    public void nextMove(int x, int y, String symbol) {
        this.arr[x][y] = symbol;
    }

    public void output() {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
