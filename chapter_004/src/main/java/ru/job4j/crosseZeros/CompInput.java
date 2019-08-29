package ru.job4j.crosseZeros;

public class CompInput implements Input {
    @Override
    public void inputData(GameBoard board) throws Exception {
        String[][] arr = board.getArr();
        int a = 0;
        int b = board.getDimension();
        int x = a + (int) (Math.random() * b);
        int y = a + (int) (Math.random() * b);
        if (arr[x][y]==null) {
            board.nextMove(x,y,"0");
        } else {
            inputData(board);
        }
    }
}
