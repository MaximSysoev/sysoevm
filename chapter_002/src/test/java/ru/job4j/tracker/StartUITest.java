package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StartUITest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Task("test1", "testDescription");
        tracker.add(item);
        assertThat(tracker.findAll()[0], is(item));
    }

    @Test
    public void whenUpdateNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Task("test1", "testDescription");
        tracker.add(previous);
        Item next = new Task("test2", "testDescription2");
        next.setId(previous.getId());
        tracker.update(next);
        assertThat(next.getName(), is("test2"));
    }


    @Test
    public void whenDeleteThenReturnNull() {
        Tracker tracker = new Tracker();
        Item item = new Task("test1", "testDescription1");
        tracker.add(item);
        tracker.delete(item);
        assertThat(item.getName(), is("null"));
    }

    @Test
    public void whenFindById() {
        Tracker tracker = new Tracker();
        Item one = new Task("test1", "testDescription1");
        tracker.add(one);
        Item exceptId = tracker.findById(one.getId());
        assertThat(one, is(exceptId));
    }

    @Test
    public void whenFindByName() {
        Tracker tracker = new Tracker();
        Item one = new Task("test1", "testDescription1");
        tracker.add(one);
        assertThat(one.getName(), is("test1"));
    }


}
