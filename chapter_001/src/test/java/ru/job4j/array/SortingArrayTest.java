package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortingArrayTest {

    @Test
    public void WhenAdditionTwoArraysAndSortingArray() {
        SortingArray sort = new SortingArray();
        int[] a = {10, 9, 8, 7, 6, 11};
        int [] b = {5, 0, 1, 4, 2, 3};
        int [] resultArray = sort.additionArrays(a, b);
        resultArray = sort.sortingArray(resultArray);
        int[] expectArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        assertThat(resultArray, is(expectArray));
    }

}
