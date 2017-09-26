package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ContainSubStringTest {
    @Test
    public void WhenSubstringThereIs() {
        ContainSubString contain = new ContainSubString();
        String origin = "Привет";
        String sub = "иве";
        boolean flag = contain.contains(origin, sub);
        assertThat(flag, is(true));
    }
}
