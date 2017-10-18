package ru.job4j.strategy;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тестовый класс PaintTest.
 */
public class PaintTest {
    /**
     * Прорисовка квадрата.
     */
    @Test
    public void whenPaintSquare() {
        Paint paint = new Paint();
        paint.draw(new Square());
        String result = paint.getResult();
        StringBuilder pic = new StringBuilder();
        pic.append("++++\n");
        pic.append("++++\n");
        pic.append("++++");
        assertThat(result, is(pic.toString()));
    }

    /**
     * Прорисовка треугольника.
     */
    @Test
    public void whenPaintTriangle() {
        Paint paint = new Paint();
        paint.draw(new Triangle());
        String result = paint.getResult();
        StringBuilder pic = new StringBuilder();
        pic.append("   +   \n");
        pic.append("  +++  \n");
        pic.append(" +++++ \n");
        pic.append("++++++++");
        assertThat(result, is(pic.toString()));
    }
}
