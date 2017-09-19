package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TurnTest {

    public void RotateFiveElements() {
        Turn turn = new Turn();
        int[] resultArray = {1, 2, 3, 4, 5};
        resultArray = turn.back(resultArray);
        int[] expectArray = {5, 4, 3, 2, 1};
        assertThat(resultArray, is(expectArray));
    }

    public void RotateFourElements() {
        Turn turn = new Turn();
        int[] resultArray = {4, 1, 6, 2};
        resultArray = turn.back(resultArray);
        int[] expectArray = {2, 6, 1, 4};
        assertThat(resultArray, is(expectArray));
    }
}
