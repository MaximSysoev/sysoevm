package ru.job4j.mapTest;
import org.junit.*;
import ru.job4j.map.Entry;
import ru.job4j.map.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class MapTest {
    Map<Integer, String> map = new Map<>();

    @Before
    public void setUp() {
        Entry<Integer, String> entry1 = new Entry<>(1, "first");
        Entry<Integer, String> entry2 = new Entry<>(2, "second");
        Entry<Integer, String> entry3 = new Entry<>(3, "third");
        map.insert(entry1.key, entry1.value);
        map.insert(entry2.key, entry2.value);
        map.insert(entry3.key, entry3.value);
    }

    @Test
    public void whenGetValueForKey() {
        assertThat(map.get(1), is("first"));
    }

    @Test
    public void whenDeleteFiveValueShouldNull() {
        map.delete(1);
        assertThat(map.get(1), is((Object) null));
    }

}
