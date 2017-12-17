package ru.job4j.array;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * BubbleSortTest - класс.
 */
public class BubbleSortTest {
    /**
     * WhenAddArrayThenSort - метод сортирует массив пузырьком.
     */
    @Test
    public void whenAddArrayThenSort() {
        BubbleSort bubbleSort = new BubbleSort();
        int[] resultArray = {4, 1, 2, 5, 3};
        resultArray = bubbleSort.sort(resultArray);
        int[] expectArray = {1, 2, 3, 4, 5};
        assertThat(resultArray, is(expectArray));
    }
}
