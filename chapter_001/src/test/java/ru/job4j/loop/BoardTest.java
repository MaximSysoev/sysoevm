package ru.job4j.loop;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * BoardTest - класс.
 */
public class BoardTest {
    /**
     * Заполнение 3х3.
     */
    @Test
    public void whenBoardThreeOnThree() {
        Board board = new Board();
        StringBuilder builder = new StringBuilder();
        builder.append("x x\r\n x \r\nx x\r\n");
        assertThat(board.paint(3, 3), is(builder.toString()));
    }

    /**
     * Заполнение 5х4.
     */
    @Test
    public void whenBoardFiveOnFour() {
        Board board = new Board();
        StringBuilder builder = new StringBuilder();
        builder.append("x x x\r\n x x \r\nx x x\r\n x x \r\n");
        assertThat(board.paint(5, 4), is(builder.toString()));
    }

}
