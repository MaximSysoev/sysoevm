package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BoardTest {
    public void WhenBoardThreeOnThree() {
        Board board = new Board();
        StringBuilder builder= new StringBuilder();
        builder.append("x x x\r\n x \r\nx x");
        assertThat(board.paint(3,3), is(builder.toString()));
    }

    public void WhenBoardFiveOnFour() {
        Board board = new Board();
        StringBuilder builder= new StringBuilder();
        builder.append("x x x x\r\n x x \r\nx x x\r\n x x ");
        assertThat(board.paint(5,4), is(builder.toString()));
    }

}
