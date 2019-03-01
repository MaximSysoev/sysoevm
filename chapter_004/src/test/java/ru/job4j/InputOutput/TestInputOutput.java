package ru.job4j.inputoutput;
import org.junit.Test;
import ru.job4j.inputouput.CheckByteStream;

import java.io.*;
import java.util.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TestInputOutput {
    @Test
    public void whenEvenNumber() throws IOException {
        System.setIn(new ByteArrayInputStream("100".getBytes()));
        assertThat(new CheckByteStream().isNumber(System.in), is(true));
    }

    @Test
    public void whenOddNumber() throws IOException {
        System.setIn(new ByteArrayInputStream("777".getBytes()));
        assertThat(new CheckByteStream().isNumber(System.in), is(false));
    }
}
