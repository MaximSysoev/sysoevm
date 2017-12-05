package ru.job4j.Convert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class testConvertList {
    /**
     * Тестовый метод преобразования в коллекцию.
     */
    @Test
    public void whenConvertToList() {
        int[][] array = new int[2][2];
        ConvertList clst = new ConvertList();
        List<Integer> list = clst.toList(array);
        ArrayList<Integer> except = new ArrayList<Integer>();
        except.add(1);
        except.add(2);
        except.add(3);
        except.add(4);
        assertThat(list,  is(except));
    }

    /**
     * Тестовый метод преобразования в массив.
     */
    @Test
    public void whenConvertToArray() {
        int[][] array = new int[3][3];
        ConvertList clst = new ConvertList();
        List<Integer> list = clst.toList(array);
        int[][] arrToArray = clst.toArray(list, 3);
        int[][] expect = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        assertThat(arrToArray, is(expect));
    }

    @Test
    public void whenConvertArrayList() {
        ConvertList clst = new ConvertList();
        List<int[]> list = new ArrayList<int[]>();
        List<Integer> expect = new ArrayList<Integer>();
        list.add(new int[] {1, 2, 3});
        list.add(new int[] {4, 5, 6});
        expect.add(1);
        expect.add(2);
        expect.add(3);
        expect.add(4);
        expect.add(5);
        expect.add(6);
        List<Integer> result = clst.convert(list);
        assertThat(result, is(expect));
    }
}
