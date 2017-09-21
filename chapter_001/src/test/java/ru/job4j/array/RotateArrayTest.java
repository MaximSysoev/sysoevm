package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class RotateArrayTest {

    @Test
    public void ArrayTwoOnTwo() {
        int i = 0, j = 0, ch = 1;
        RotateArray rotate = new RotateArray();
        int [][] resultArray = new int[2][2];
        for (i = 0; i < resultArray.length; i++) {
            for (j=0; j < resultArray.length; j++) {
                resultArray[i][j] = ch;
                ch++;
            }
        }
        int[][] expected = rotate.rotate(resultArray);
        assertThat(resultArray, is(expected));
    }

    @Test
    public void ArrayThreeOnThree() {
        int i = 0, j = 0, ch = 1;
        RotateArray rotate = new RotateArray();
        int [][] resultArray = new int[3][3];
        for (i = 0; i<resultArray.length; i++) {
            for (j=0; j<resultArray.length; j++) {
                resultArray[i][j] = ch;
                ch++;
            }
        }
        int[][] expected = rotate.rotate(resultArray);
        assertThat(resultArray, is(expected));
    }



}
