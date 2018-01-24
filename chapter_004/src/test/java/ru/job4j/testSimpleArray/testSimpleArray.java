package job4j.testSimpleArray;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.primeIterator.PrimeIterator;
import ru.job4j.simpeArray.SimpleArray;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
public class testSimpleArray {

    private ArrayList<Integer> arrayList = new ArrayList<>();
    private SimpleArray simpleArray = new SimpleArray();

    @Before
    public void setUp() {
        simpleArray.add(1);
        simpleArray.add(2);
        simpleArray.add(3);
        simpleArray.set(2, 5);
    }

    @Test
    public void whenAddNewValue() {
        assertThat(1, is(simpleArray.get(0)));
    }

    @Test
    public void whenSetValue() {
        assertThat(5, is(simpleArray.get(2)));
    }

    @Test
    public void whenDeleteValue() {
        simpleArray.delete(1);
        assertThat(3, is(simpleArray.get(2)));
    }

    @Test
    public void whenNextValue() {
        assertThat(1, is(simpleArray.next()));
    }

}
