package ru.job4j.chess;

import com.sun.org.apache.xml.internal.resolver.helpers.BootstrapResolver;

import java.util.Arrays;

public class Board extends Figure {
    private Figure[] figures = new Figure[32];
    private Cell[][] cell = new Cell[9][9];
    private boolean result = true;

    /**
     * Массив с ходами фигуры конь.
     */
    private Cell[] MoveOfTheHorse = new Cell[8];
    private int index = 0;

    public Board (Cell position) {
        super(position);
    }

    /**
     * Задаёт фигуре новые координаты.
     * @param dist
     */
    public void clone(Cell dist) {
        figures[1].position.setX(dist.getX());
        figures[1].position.setY(dist.getY());
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
        cell[x][y] = source;
        if (x > 0 && y > 0) {
            if (cell[x][y] == null) {
                result = false;
                throw new FigureNotFoundException("Ячейка [" + x + "][" + y + "] не содержит фигуры.");
            } else {
                if (figures[1].position.getX() == x && figures[1].position.getY() == y) {
                   // result = true;
                    way(dist);
                    clone(dist);
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

    /**
     * Расстановка белых фигур.
     */
    public void alignmentWhiteFigures() {
        for (int i = 1; i < 3; i++) {
            for (int j = 1; j < 9; j++) {
                Cell dist = new Cell(j, i);
                this.figures[index] = new Board(dist);
                this.cell[j][i] = dist;
                this.index++;
            }
        }
    }

    /**
     * Расстановка чёрных фигур.
     */
    public void alignmentBlackFigures() {
        for (int i = 8; i > 6; i--) {
            for (int j = 1; j < 9; j++) {
                Cell dist = new Cell(j, i);
                this.figures[index] = new Board(dist);
                this.cell[j][i] = dist;
                this.index++;
            }
        }
    }

    /**
     * Все ходы фигурой лошадь.
     * @param number номер фигуры.
     */
    public void MoveHourse(int number) {
        int x = figures[number].position.getX();
        int y = figures[number].position.getY();
        // Первый ход влево->вверх
        MoveOfTheHorse[0] = new Cell(x - 2, y + 1);
        // Второй ход влево->вниз
        MoveOfTheHorse[1] = new Cell(x - 2, y - 1);
        // Третий ход вверх->влево
        MoveOfTheHorse[2] = new Cell(x - 1, y + 2);
        // Четвёртый ход вверх->вправо
        MoveOfTheHorse[3] = new Cell(x + 1, y + 2);
        // Пятый ход вправо->вверх
        MoveOfTheHorse[4] = new Cell(x + 2, y + 1);
        // Шестой ход вправо->вниз
        MoveOfTheHorse[5] = new Cell(x + 2, y - 1);
        // Седьмой ход вниз->вправо
        MoveOfTheHorse[6] = new Cell(x + 1, y - 2);
        // Восьмой ход вниз->влево
        MoveOfTheHorse[7] = new Cell(x - 1, y - 2);
    }

    /**
     * Задаёт ячейку куда следует пойти.
     * Если фигура может туда пойти, то Вернуть массив ячеек, которые должна пройти фигура.
     * @param dist - ячейка.
     * @return массив с ячейками.
     */
    public Cell[] way(Cell dist) throws ImposibleMoveException, OccupiedWayException {
        MoveHourse(1);
        int x = dist.getX();
        int y = dist.getY();
        int count = 0;
        if (cell[x][y] == null && x > 0 && y > 0) {
            for (int i = 0; i < 8; i++) {
                if (x == MoveOfTheHorse[i].getX() && y == MoveOfTheHorse[i].getY() && MoveOfTheHorse[i].getX() > 0 && MoveOfTheHorse[i].getY() > 0) {
                    System.out.println("Фигура может пойти в ячейку [" + x + "][" + y + "]");
                    if (y == figures[1].position.getY() + 2) {
                        System.out.println("Клетки через которые проходит фигура: [" + figures[1].position.getX() + "][" + (figures[1].position.getY() + 1) + "]");
                        System.out.println("Клетки через которые проходит фигура: [" + figures[1].position.getX() + "][" + (figures[1].position.getY() + 2) + "]");
                    } else if (y == figures[1].position.getY() - 2) {
                        System.out.println("Клетки через которые проходит фигура: [" + figures[1].position.getX() + "][" + (figures[1].position.getY() - 1) + "]");
                        System.out.println("Клетки через которые проходит фигура: [" + figures[1].position.getX() + "][" + (figures[1].position.getY() - 2) + "]");
                    } else if (x == figures[1].position.getX() + 2) {
                        System.out.println("Клетки через которые проходит фигура: [" + (figures[1].position.getX() + 1) + "][" + figures[1].position.getY() + "]");
                        System.out.println("Клетки через которые проходит фигура: [" + (figures[1].position.getX() + 2) + "][" + figures[1].position.getY() + "]");
                    } else if (x == figures[1].position.getX() - 2) {
                        System.out.println("Клетки через которые проходит фигура: [" + (figures[1].position.getX() - 1) + "][" + figures[1].position.getY() + "]");
                        System.out.println("Клетки через которые проходит фигура: [" + (figures[1].position.getX() - 2) + "][" + figures[1].position.getY() + "]");
                    }
                    break;
                 } else {
                    count++;
                }
            }
            if (count == MoveOfTheHorse.length) {
                throw new ImposibleMoveException("Недопустимый ход [" + x + "][" + y + "]");
            }
        } else {
            throw new ImposibleMoveException("Недопустимый ход [" + x + "][" + y + "]");
        }
        return MoveOfTheHorse;
    }


  /*  public static void main(String[] args) {
        Board board = new Board(new Cell(0, 0));
        board.alignmentWhiteFigures();
        board.alignmentBlackFigures();


        board.move(new Cell(2, 1), new Cell(1, 3));
        System.out.println("--------------------");


        board.move(new Cell(1, 3), new Cell(3, 4));
        System.out.println("--------------------");

        board.move(new Cell(3, 4), new Cell(5, 5));
        System.out.println("--------------------");

        board.move(new Cell(5, 5), new Cell(4, 3));

    }*/


}
