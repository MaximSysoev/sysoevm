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
        Node<Integer> first = new Node<>(1);
        Node<Integer> second = new Node<>(2);
        Node<Integer> third = new Node<>(3);
        Node<Integer> fourth = new Node(4);

        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = first;
        Node<Integer> head = first;

        assertThat(true, is(head.hasCycle(first)));
    }
}
