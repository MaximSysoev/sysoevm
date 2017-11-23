package ru.job4j.chess;

import com.sun.org.apache.xml.internal.resolver.helpers.BootstrapResolver;
import java.util.Arrays;

public class Board {
    public Figure[][] figure = new Figure[8][8];

    public Figure[][] getFigure() {
        return figure;
    }

    public void setFigure(Figure[][] figure) {
        this.figure = figure;
    }

    /**
     * Проверяет, что в заданной ячейки есть фигура, если нет, то выкинуть исключение.
     * Если фигура есть, проверить может ли она так двигаться, если нет то упадет исключение.
     * Проверить что полученный путь не занят фигурами. Если занят выкинуть исключение.
     * Если всё отлично, то записать в ячейку новое положение Figure figure.clone(Cell dist).
     * @param source начальное положение фигуры.
     * @param dist конченое положение фигуры.
     * @return
     */
    public boolean move(Cell source, Cell dist) throws ImposibleMoveException, OccupiedWayException, FigureNotFoundException {
        int x = source.getX();
        int y = source.getY();
        boolean result = true;
        if (x >= 0 && y >= 0) {
            if (this.indexOf(source) == 0) {
                System.out.println("x=" + figure[1][0].position.getX() + " y=" + figure[1][0].position.getY());
                result = false;
                throw new FigureNotFoundException("Ячейка [" + x + "][" + y + "] не содержит фигуры.");
            } else {
                if (figure[1][0].position.getX() == x && figure[1][0].position.getY() == y) {
                    figure[1][0].way(dist);
                    figure[1][0].clone(dist);
                } else {
                    result = false;
                    throw new OccupiedWayException("Фигура [" + source.getX() + "][" + source.getY() + "] так не ходит.");
                }
            }
        } else {
            result = false;
            System.out.println("Здесь в Board.java");
            throw new ImposibleMoveException("Недопустимый ход [" + x + "][" + y + "]");
        }
        return result;
    }

    public void alignmentFigures() {
        this.figure[0][0] = new Horse(new Cell(0, 0));
        this.figure[1][0] = new Horse(new Cell(1, 0));
        this.figure[2][0] = new Horse(new Cell(2, 0));
        this.figure[3][0] = new Horse(new Cell(3, 0));
        this.figure[4][0] = new Horse(new Cell(4, 0));
        this.figure[5][0] = new Horse(new Cell(5, 0));
        this.figure[6][0] = new Horse(new Cell(6, 0));
        this.figure[7][0] = new Horse(new Cell(7, 0));
        this.figure[0][1] = new Horse(new Cell(0, 1));
        this.figure[1][1] = new Horse(new Cell(1, 1));
        this.figure[2][1] = new Horse(new Cell(2, 1));
        this.figure[3][1] = new Horse(new Cell(3, 1));
        this.figure[4][1] = new Horse(new Cell(4, 1));
        this.figure[5][1] = new Horse(new Cell(5, 1));
        this.figure[6][1] = new Horse(new Cell(6, 1));
        this.figure[7][1] = new Horse(new Cell(7, 1));
    }

    /**
     * Находит index в массиве figures той фигуры, которая стоит на этой клетке.
     * @param cell
     * @return
     */
    public int indexOf(Cell cell) {
        int k = 0;
        int index = 0;
        int x = cell.getX();
        int y = cell.getY();
        for (int out = 0; out < 2; out++) {
            for (int inner = 0; inner < 8; inner++) {
                if (x == figure[inner][out].position.getX() && y == figure[inner][out].position.getY()) {
                    k = index;
                }
                index++;
            }
        }
        return k;
    }

    public static void main(String[] args) {
        Board board = new Board();
        Horse horse = new Horse(null);
        board.alignmentFigures();
        board.move(new Cell(1, 0), new Cell(2, 2));
        board.move(new Cell(2, 2), new Cell(4, 3));
        // horse.moveHorse(board.figure[1][0].position.getX(), board.figure[1][0].position.getY());
    }


}
