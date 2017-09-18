package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FactorialTest {

    public void FactorialFive() {
        Factorial fact = new Factorial();
        int result = fact.Calc(5);
        assertThat(result, is(120));
    }

    public void FactorialZero() {
        Factorial fact = new Factorial();
        int result = fact.Calc(0);
        assertThat(result, is(1));
    }

}
