package ru.job4j.calculator;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * CalculatorTest - класс.
 */
public class CalculatorTest {
    /**
     * Тест на сложение чисел.
     */
    @Test
    public void whenAddOnePlusOneThenTwo() {
        Calculator calc = new Calculator();
        calc.add(1D, 1D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }

    /**
     * Тест на разность чисел.
     */
    @Test
    public void whenSubstractOneMinusOneThenZero() {
        Calculator calc = new Calculator();
        calc.substract(1D, 1D);
        double result = calc.getResult();
        double expected = 0D;
        assertThat(result, is(expected));
    }

    /**
     * Тест на деление чисел.
     */
    @Test
    public void whenDivTenDivisionTwoThenFive() {
        Calculator calc = new Calculator();
        calc.div(10D, 2D);
        double result = calc.getResult();
        double expected = 5D;
        assertThat(result, is(expected));
    }

    /**
     * Тест на умножение чисел.
     */
    @Test
    public void whenMultiplyOneMultiplyTwoThenTwo() {
        Calculator calc = new Calculator();
        calc.multiply(1D, 2D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }
}
