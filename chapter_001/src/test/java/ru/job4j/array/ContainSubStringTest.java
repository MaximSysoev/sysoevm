package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * ContainSubStringTest класс.
 */
public class ContainSubStringTest {
    /**
     * Тест содержится ли строка.
     */
    @Test
    public void whenSubstringThereIs() {
        ContainSubString contain = new ContainSubString();
        String origin = "Привет";
        String sub = "иве";
        boolean flag = contain.contains(origin, sub);
        assertThat(flag, is(true));
    }
}
