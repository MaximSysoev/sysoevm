package ru.job4j.chess;

public class Horse extends Figure {
    Board board = new Board();


    public Horse(Cell cell) {
        super(cell);
    }

    public void initHorse() {
        Horse horse = new Horse(new Cell(1, 0));
    }

    /**
     * Массив с ходами фигуры конь.
     */
    private Cell[] MoveHorse = new Cell[8];

    /**
     * Все ходы фигурой лошадь.
     */
    public void moveHorse(int x, int y) {
        // Первый ход влево->вверх
        MoveHorse[0] = new Cell(x - 2, y + 1);
        // Второй ход влево->вниз
        MoveHorse[1] = new Cell(x - 2, y - 1);
        // Третий ход вверх->влево
        MoveHorse[2] = new Cell(x - 1, y + 2);
        // Четвёртый ход вверх->вправо
        MoveHorse[3] = new Cell(x + 1, y + 2);
        // Пятый ход вправо->вверх
        MoveHorse[4] = new Cell(x + 2, y + 1);
        // Шестой ход вправо->вниз
        MoveHorse[5] = new Cell(x + 2, y - 1);
        // Седьмой ход вниз->вправо
        MoveHorse[6] = new Cell(x + 1, y - 2);
        // Восьмой ход вниз->влево
        MoveHorse[7] = new Cell(x - 1, y - 2);
    }

    public void test(Cell dist) {
        board.figure[1][0] = new Horse(dist);
        //System.out.println("В clone figures= " + board.figure[1][0].position.getX() + " " +  board.figure[1][0].position.getY());
       // System.out.println("В test: " + board.getFigure()[1][0]);
    }

    public void clone(Cell dist) {
        board.figure[1][0] = new Horse(dist);
    }

    /**
     * Задаёт ячейку куда следует пойти.
     * Если фигура может туда пойти, то Вернуть массив ячеек, которые должна пройти фигура.
     * @param dist - ячейка.
     * @return массив с ячейками.
     */
    public Cell[] way(Cell dist) throws ImposibleMoveException {
        int x = dist.getX();
        int y = dist.getY();
        board.alignmentFigures();
        moveHorse(board.figure[1][0].position.getX(), board.figure[1][0].position.getY());

        if (board.indexOf(dist) == 0) {
            for (int i = 0; i < 8; i++) {
                if (x == MoveHorse[i].getX() && y == MoveHorse[i].getY() && MoveHorse[i].getX() > 0 && MoveHorse[i].getY() > 0) {
                    System.out.println("Фигура может пойти в ячейку [" + x + "][" + y + "]");
                    if (y == board.figure[1][0].position.getY() + 2) {
                        System.out.println("Клетки через которые проходит фигура: [" + board.figure[1][0].position.getX() + "][" + (board.figure[1][0].position.getY() + 1) + "]");
                        System.out.println("Клетки через которые проходит фигура: [" + board.figure[1][0].position.getX() + "][" + (board.figure[1][0].position.getY() + 2) + "]");
                    } else if (y == board.figure[1][0].position.getY() - 2) {
                        System.out.println("Клетки через которые проходит фигура: [" + board.figure[1][0].position.getX() + "][" + (board.figure[1][0].position.getY() - 1) + "]");
                        System.out.println("Клетки через которые проходит фигура: [" + board.figure[1][0].position.getX() + "][" + (board.figure[1][0].position.getY() - 2) + "]");
                    } else if (x == board.figure[1][0].position.getX() + 2) {
                        System.out.println("Клетки через которые проходит фигура: [" + (board.figure[1][0].position.getX() + 1) + "][" + board.figure[1][0].position.getY() + "]");
                        System.out.println("Клетки через которые проходит фигура: [" + (board.figure[1][0].position.getX() + 2) + "][" + board.figure[1][0].position.getY() + "]");
                    } else if (x == board.figure[1][0].position.getX() - 2) {
                        System.out.println("Клетки через которые проходит фигура: [" + (board.figure[1][0].position.getX() - 1) + "][" + board.figure[1][0].position.getY() + "]");
                        System.out.println("Клетки через которые проходит фигура: [" + (board.figure[1][0].position.getX() - 2) + "][" + board.figure[1][0].position.getY() + "]");
                    }
                    break;
                }
            }
        } else {
            System.out.println("Здесь в Horse.java");
            throw new ImposibleMoveException("Недопустимый ход [" + x + "][" + y + "]");
        }
         return MoveHorse;
    }
}
