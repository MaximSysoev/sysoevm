package ru.job4j.loop;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * FactorialTest класс.
 */
public class FactorialTest {
    /**
     * Вычисляет факториал 5.
     */
    @Test
    public void factorialFive() {
        Factorial fact = new Factorial();
        int result = fact.calc(5);
        assertThat(result, is(120));
    }

    /**
     * Вычисляет факториал 0.
     */
    @Test
    public void factorialZero() {
        Factorial fact = new Factorial();
        int result = fact.calc(0);
        assertThat(result, is(1));
    }

}
