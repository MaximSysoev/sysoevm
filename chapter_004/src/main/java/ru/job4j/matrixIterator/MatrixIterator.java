package ru.job4j.matrixIterator;
import java.util.*;

public class MatrixIterator implements Iterator {

    private int[][] values;
    private int length = 0;

    public MatrixIterator(int[][] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        return values[0].length+values[1].length > length;
    }

    @Override
    public Object next() {
        int count = 0;
        int value = 0;
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values[i].length; j++) {
                if (length==count) {
                    value = values[i][j];
                }
                count++;
            }
        }
        length++;
        return value;
    }

}
