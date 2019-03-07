package ru.job4j.inputoutput;
import org.junit.Before;
import org.junit.Test;
import ru.job4j.inputouput.DelAbuse;

import java.io.*;
import java.security.Provider;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

public class TestDelAbuse {


       DelAbuse delAbuse = new DelAbuse();
        InputStream is = getClass().getClassLoader().getResourceAsStream("input.txt");
        String[] ab = new String[] {"1111", "22", "33"};
    InputStream is2 = getClass().getClassLoader().getResourceAsStream("input.txt");


    @Test
    public void whenContainsAbuse() throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        delAbuse.dropAbuses(is2, bos, ab);
        String s = bos.toString();
        System.out.println(s);
        boolean contains = false;
        for (String abuse : ab) {
            if (s.contains(abuse)) {
                contains = true;
                break;
            }
        }
        assertFalse(contains);
    }
}
