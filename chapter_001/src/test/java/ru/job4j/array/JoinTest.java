package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class JoinTest {
    @Test
    public void WhenCombiningTowArrays() {
        join combining = new join();
        int[] a = {1, 6, 10, 90, 122};
        int[] b = {2, 3, 4, 15, 20, 25, 100, 150};
        int [] resultArray = combining.CombiningArrays(a, b);
        int[] expectArray = {1, 6, 10, 90, 122, 2, 3, 4, 15, 20, 25, 100, 150};
        assertThat(resultArray, is(expectArray));
    }
}
