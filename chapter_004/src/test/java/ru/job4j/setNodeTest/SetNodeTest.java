package ru.job4j.setNodeTest;
import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.*;
import ru.job4j.converter.Converter;
import ru.job4j.setNode.SetNode;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SetNodeTest {
    SetNode<Integer> setNode;

    @Before
    public void setUp() {
        setNode = new SetNode<>();
        setNode.add(1);
        setNode.add(2);
        setNode.add(3);
    }

    @Test
    public void WhenGetNextValue(){
        assertThat(1, is(setNode.iterator().next()));
    }

    @Test
    public void WhenGetHasNext() {
        assertThat(true, is(setNode.iterator().hasNext()));
    }

}
