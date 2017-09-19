package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BubbleSortTest {
    @Test
    public void WhenAddArrayThenSort(int[] array) {
        BubbleSort bubbleSort = new BubbleSort();
        int[] resultArray = {5, 1, 2, 7, 3};
        resultArray = bubbleSort.sort(resultArray);
        int[] expectArray = {1, 2, 3, 4, 5};
        assertThat(resultArray, is(expectArray));
    }
}
