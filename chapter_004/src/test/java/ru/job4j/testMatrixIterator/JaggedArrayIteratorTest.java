package ru.job4j.testMatrixIterator;
import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.matrixIterator.MatrixIterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class JaggedArrayIteratorTest {
    private Iterator<Integer> it;

    @Before
    public void setUp(){
       it = new MatrixIterator(new int[][]{{1}, {3, 4}});
    }

    @Test
    public void testsThatNextMethodDoesntDependsOnPriorHasNextInvocation () {
        it = new MatrixIterator(new int[][]{{1}, {3, 4}});
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(4));
        it.next();
    }

    @Test
    public void sequentialHasNextInvocationDoesntAffectRetrievalOrder () {
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(4));
        it.next();
    }

    @Test
    public void hasNextNextSequentialInvocation () {
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
        assertThat(it.hasNext(), is(false));
        it.next();
    }

}
