package ru.job4j.inputoutput;
import org.junit.Test;
import ru.job4j.inputouput.DelAbuse;

import java.io.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TestDelAbuse {

    @Test
    public void whenContainsAbuse() throws IOException {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        System.setIn(new ByteArrayInputStream("слово1 слово2 слово".getBytes()));
        String[] abuse = new String[]{"слово1", "слово2"};
        new DelAbuse().dropAbuses(System.in, System.out, abuse);
        assertThat("слово", is(outContent.toString()));
    }
}
