package ru.job4j.chess;

public abstract class Figure {

    final Cell position;

    public Figure(Cell position) {
        this.position = position;
    }

    /**
     * Делает ход.
     * @param dist - задаёт ячейку куда следует пойти.
     * @return массив с ячейками.
     */
    abstract Cell[] way(Cell dist);
}