package ru.job4j.simpleSetTest;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import org.junit.Before;
import org.junit.Test;
import ru.job4j.evenNumbersForIterator.EvenNumbersIterator;
import ru.job4j.simpleSet.SimpleSet;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SimpleSetTest {
    SimpleSet<Integer> simpleSet = new SimpleSet<>();

    @Before
    public void setUp() {
        simpleSet.add(1);
        simpleSet.add(2);
        simpleSet.add(3);
    }

    @Test
    public void whenIteratorNext() {
        assertThat(simpleSet.simpleArray.iterator().next(), is(1));
    }

    @Test
    public void iteratorHasNext() {
        assertThat(simpleSet.simpleArray.iterator().hasNext(), is(true));
    }
}
