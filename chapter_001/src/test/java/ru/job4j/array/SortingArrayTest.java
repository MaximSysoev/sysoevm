package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortingArrayTest {

    @Test
    public void WhenAdditionTwoArraysAndSortingArray() {
        SortingArray sort = new SortingArray();
        int[] a = {1, 3};
        int[] b = {2, 4};
        int [] resultArray = sort.sortingArray(a, b);
        int[] expectArray = {1, 2, 3, 4};
        assertThat(resultArray, is(expectArray));
    }

}
