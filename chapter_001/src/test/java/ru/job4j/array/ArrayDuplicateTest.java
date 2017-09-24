package ru.job4j.array;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public class ArrayDuplicateTest {

    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        ArrayDuplicate arr = new ArrayDuplicate();
        String[] list = {"Привет", "Мир", "Привет", "Супер", "Мир"};
        String [] resultArray = arr.remove(list);
        String[] expect = {"Привет", "Мир", "Супер"};
        assertThat(resultArray, is(expect));
    }

}
