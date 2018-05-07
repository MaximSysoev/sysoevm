package ru.job4j.treeTest;

import org.junit.Test;
import ru.job4j.simpleTree.Tree;

import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class TreeTest {
    @Test
    public void when6ElFindLastThen6() {
        Tree<Integer> tree = new Tree<Integer>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        assertThat(
                tree.findBy(6).isPresent(),
                is(true)
        );
    }

    @Test
    public void when6ElFindNotExitThenOptionEmpty() {
        Tree<Integer> tree = new Tree<Integer>(1);
        tree.add(1, 2);
        assertThat(
                tree.findBy(7).isPresent(),
                is(false)
        );
    }

    @Test
    public void whenNextValueIsOne() {
        Tree<Integer> tree = new Tree<Integer>(1);
        assertThat(tree.iterator().next(), is(1));
    }

    @Test
    public void whenhasNextIsTrue() {
        Tree<Integer> tree = new Tree<Integer>(1);
        assertThat(tree.iterator().hasNext(), is(true));
    }
}
