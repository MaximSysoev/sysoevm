package ru.job4j.listNodeTest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.*;
import ru.job4j.converter.Converter;
import ru.job4j.listNode.Container;
import ru.job4j.listNode.Node;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ListNodeTest {
    Container<Integer> container;

    @Before
    public void setUp() {
        container = new Container<>();
        container.add(1);
        container.add(2);
    }

    @Test
    public void WhenGetNextValue() {
        assertThat(2, is(container.tail.value));
    }

    @Test
    public void whenGetHasNextIsTrue() {
        assertThat(true, is(container.iterator().hasNext()));
    }

    @Test
    public void whenCycleList(){
        Node<Integer> n1 = new Node<>(1);
        Node<Integer> n2 = new Node<>(2);
        Node<Integer> n3 = new Node<>(3);
        Node<Integer> n4 = new Node(4);
        Node<Integer> n5 = new Node(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        assertThat(n1.hasCycle(n1), is(false));
    }
}
