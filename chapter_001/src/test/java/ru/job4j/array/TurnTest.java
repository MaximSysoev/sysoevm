package ru.job4j.array;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * TurnTest класс.
 */
public class TurnTest {
    /**
     * Сортирует с конца по элементы.
     */
    @Test
    public void rotateFiveElements() {
        Turn turn = new Turn();
        int[] resultArray = {1, 2, 3, 4, 5};
        resultArray = turn.back(resultArray);
        int[] expectArray = {5, 4, 3, 2, 1};
        assertThat(resultArray, is(expectArray));
    }

    /**
     * Сортирует с конца по элементы.
     */
    @Test
    public void rotateFourElements() {
        Turn turn = new Turn();
        int[] resultArray = {4, 1, 6, 2};
        resultArray = turn.back(resultArray);
        int[] expectArray = {2, 6, 1, 4};
        assertThat(resultArray, is(expectArray));
    }
}
