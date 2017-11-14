package ru.job4j.automat;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TestOperation {
    @Test
    public void whenBuyCofe() {
        Operation operation = new Operation();
        int[] resultArray = operation.changes(50, 35);
        int[] exception = {10, 5};
        assertThat(resultArray, is(exception));
    }
}
