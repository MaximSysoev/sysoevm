package job4j.simpleContainerTest;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import org.junit.Before;
import org.junit.Test;
import ru.job4j.evenNumbersForIterator.EvenNumbersIterator;
import ru.job4j.simpleContainer.Container;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SimpleContainerTest {
    Container<Integer> container = new Container<>();

    @Before
    public void setUp(){
        container.add(1);
        container.add(2);
        container.add(3);
        container.add(4);
        container.add(5);
    }

    @Test
    public void whenAddValue() {
        assertThat(container.get(4), is(5));
    }

    @Test
    public void iteratorHasNext() {
        assertThat(container.iterator().hasNext(), is(true));
    }

    @Test
    public void whenIteratorNext() {
        container.iterator().next();
        assertThat(container.iterator().next(), is(2));
    }
}
