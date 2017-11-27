package ru.job4j.chess;

import com.sun.org.apache.xml.internal.resolver.helpers.BootstrapResolver;

import java.awt.event.HierarchyBoundsAdapter;
import java.util.Arrays;

public class Board {
    public Figure[][] cell = new Figure[8][8]; // Клетки доски.
    Figure figure; // Фигура доски.

    public Board() {

    }

    public Board(Figure figure) {
        this.figure = figure;
    }

    /**
     * Проверяет, что в заданной ячейки есть фигура, если нет, то выкинуть исключение.
     * Если фигура есть, проверить может ли она так двигаться, если нет то упадет исключение.
     * Проверить что полученный путь не занят фигурами. Если занят выкинуть исключение.
     * Если всё отлично, то записать в ячейку новое положение Figure figure.clone(Cell dist).
     * @param source начальное положение фигуры.
     * @param dest конечное положение фигуры.
     * @return
     */
    public boolean move(Cell source, Cell dest) throws ImposibleMoveException, OccupiedWayException, FigureNotFoundException {
        int x = source.getX();
        int y = source.getY();
        boolean result = true;
        if (x >= 0 && y >= 0) {
            if (this.cell[x][y] == null) { // Если клетка пустая, то выбрасывается исключение.
                result = false;
                throw new FigureNotFoundException("Ячейка [" + x + "][" + y + "] не содержит фигуры.");
            } else {
                if (figure.position.getX() == x && figure.position.getY() == y) {
                    this.cell[x][y] = null;
                    this.cell[dest.getX()][dest.getY()] = new Horse(new Cell(dest.getX(), dest.getY()));
                    figure.way(dest);
                    figure = figure.clone(dest);
                } else {
                    result = false;
                    throw new OccupiedWayException("Фигура [" + source.getX() + "][" + source.getY() + "] так не ходит.");
                }
            }
        } else {
            result = false;
            throw new ImposibleMoveException("Недопустимый ход [" + x + "][" + y + "]");
        }
        return result;
    }

    public static void main(String[] args) {
        Horse horse = new Horse( new Cell(1, 0) ); // Создан экземпляр объекта класса Horse;
        Board figureHorse = new Board( horse ); // Создан экземпляр объекта класса Board. Присвоен объект figure;
        figureHorse.cell[horse.position.getX()][horse.position.getY()] = horse; // Начальное положение фигуры Конь записывается в массив клеток cell;

        /* Ходы фигурой конь. */
        figureHorse.move(new Cell(1, 0), new Cell(2, 2));
        System.out.println("---1---");
        figureHorse.move(new Cell(2, 2), new Cell(4, 3));
        System.out.println("---2---");
        figureHorse.move(new Cell(4, 3), new Cell(2, 2));
        System.out.println("---3---");
        figureHorse.move(new Cell(2, 2), new Cell(1, 0));

    }
}
