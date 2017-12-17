package ru.job4j.loop;

import org.junit.Test;
import ru.job4j.condition.Paint;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * PaintTest класс.
 */
public class PaintTest {
    /**
     * Рисует пирамиду высотой 2 строки.
     */
    @Test
    public void whenPiramidWithHeightTwoThenStringWithTwoRows() {
        Paint paint = new Paint();
        String result = paint.piramid(2);
        assertThat(result, is("^\r\n^^^\r\n"));
    }

    /**
     * Рисует пирамиду высотой 3 строки.
     */
    @Test
    public void whenPiramidWithHeightThreeThenStringWithThreeRows() {
        Paint paint = new Paint();
        String result = paint.piramid(3);
        assertThat(result, is("^\r\n^^^\r\n^^^^^\r\n"));
    }
}
