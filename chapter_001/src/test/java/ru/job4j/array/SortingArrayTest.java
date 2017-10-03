package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortingArrayTest {

    @Test
    public void WhenAdditionTwoArraysAndSortingArray() {
        SortingArray sort = new SortingArray();
        int[] a = {1, 6, 10, 90, 122};
        int[] b = {2, 3, 4, 15, 20, 25, 100, 150};
        int [] resultArray = sort.sortingArray(a, b);
        int[] expectArray = {1, 2, 3, 4, 6, 10, 15, 20, 25, 90, 100, 122, 150 };
        assertThat(resultArray, is(expectArray));
    }

}
