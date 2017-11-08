package ru.job4j.chess;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BoardTest {

    @Test
    public void WhenHourseWalksInCellOneThree() {
        Board board = new Board(new Cell(0, 0));
        board.alignmentWhiteFigures();
        board.alignmentBlackFigures();
        boolean result = board.move(new Cell(2, 1), new Cell(1, 3));
        assertThat(result, is(true));
    }

}
