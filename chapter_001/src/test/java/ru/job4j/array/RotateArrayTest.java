package ru.job4j.array;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * RotateArrayTest - класс.
 */
public class RotateArrayTest {

    /**
     * Переворачивает по часовой стрелке массив 2x2.
     */
    @Test
    public void arrayTwoOnTwo() {
        int i = 0, j = 0, ch = 1;
        RotateArray rotate = new RotateArray();
        int[][] resultArray = new int[2][2];
        int[][] array = new int[2][2];
        for (i = 0; i < resultArray.length; i++) {
            for (j = 0; j < resultArray.length; j++) {
                resultArray[i][j] = ch;
                ch++;
            }
        }
        array[0][0] = 3;
        array[0][1] = 1;
        array[1][0] = 4;
        array[1][1] = 2;
        int[][] expected = rotate.rotate(resultArray);
        assertThat(array, is(expected));
    }

    /**
     * Переворачивает по часовой стрелке массив 3x3.
     */
    @Test
    public void arrayThreeOnThree() {
        int i = 0, j = 0, ch = 1;
        RotateArray rotate = new RotateArray();
        int[][] resultArray = new int[3][3];
        int[][] array = new int[3][3];
        for (i = 0; i < resultArray.length; i++) {
            for (j = 0; j < resultArray.length; j++) {
                resultArray[i][j] = ch;
                ch++;
            }
        }
        array[0][0] = 7;
        array[0][1] = 4;
        array[0][2] = 1;
        array[1][0] = 8;
        array[1][1] = 5;
        array[1][2] = 2;
        array[2][0] = 9;
        array[2][1] = 6;
        array[2][2] = 3;
        int[][] expected = rotate.rotate(resultArray);
        assertThat(array, is(expected));
    }
}
