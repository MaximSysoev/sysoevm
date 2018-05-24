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

    @Test
    public void whenTreeIsBinaryTrue() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1,2);
        tree.add(1,3);
        assertThat(tree.isBinary(), is(true));
    }

    @Test
    public void whenTreeIsBinaryFalse() {
        Tree<Integer> tree = new Tree<>(50);
        tree.add(50, 70);
        tree.add(50, 80);
        tree.add(70, 90);
        tree.add(70, 100);
        tree.add(90, 110);
        tree.add(90, 120);
        tree.add(100, 180);
        tree.add(100, 190);
        tree.add(100, 290);
        tree.add(180, 200);
        tree.add(180, 210);
        assertThat(tree.isBinary(), is(false));
    }


}
