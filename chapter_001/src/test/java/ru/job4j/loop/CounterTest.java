package ru.job4j.loop;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * CounterTest класс.
 */
public class CounterTest {
    /**
     * Ссумирует числа от 1 до 10.
     */
    @Test
    public void forOneToTen() {
        Counter count = new Counter();
        int sum = count.add(1, 10);
        assertThat(sum, is(30));
    }

}
