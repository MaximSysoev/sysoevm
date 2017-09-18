package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CounterTest {
    public void  ForOneToTen() {
        Counter count = new Counter();
        int sum=count.add(1,10);
        assertThat(sum, is(30));
    }

}
