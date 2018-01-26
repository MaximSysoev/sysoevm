package ru.job4j.matrixIterator;
import java.util.*;

public class MatrixIterator implements Iterator {

    private int[][] values;
    private int length = 0;


    public MatrixIterator(int[][] values) {
        this.values = values;
    }

    public int getDemension() {
        int dimension = 0;
        for (int i = 0; i < values.length; i++) {
            dimension = dimension + values[i].length;
        }
        return dimension;
    }

    @Override
    public boolean hasNext() {
        return getDemension() > length;
    }

    @Override
    public Object next() {
        int count = 0;
        int value = 0;
        if (length < getDemension()) {
            for (int i = 0; i < values.length; i++) {
                for (int j = 0; j < values[i].length; j++) {
                    if (length == count) {
                        value = values[i][j];
                    }
                    count++;
                }
            }
            length++;
        } else {
            throw new NoSuchElementException();
        }

        return value;
    }

    public static void main(String[] args) {
        Iterator<Integer> it = new MatrixIterator(new int[][] {{1}, {3, 4}, {7}, {12, 16, 24, 2}});
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.next());
    }

}
