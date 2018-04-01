package ru.job4j.mapTest;
import org.junit.*;
import ru.job4j.map.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class MapTest {
    Map<String, String> map = new Map<>();

    @Before
    public void setUp() {
        map.insert("Первый", "first");
        map.insert("Второй", "second");
        map.insert("Третий", "three");
        map.insert("Четвертый", "fourth");
        map.insert("Пятый", "five");
    }

    @Test
    public void whenGetValueForKey() {
        assertThat(map.get("Пятый"), is("five"));
    }

    @Test
    public void whenDeleteFiveValueShouldNull() {
        map.delete("Пятый");
        assertThat(map.get("Пятый"), is((Object) null));
    }

}
