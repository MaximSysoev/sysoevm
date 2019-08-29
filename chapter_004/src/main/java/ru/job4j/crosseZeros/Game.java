package ru.job4j.crosseZeros;

public class Game implements GamePlay {

    private int count = 0;
    private Move user = new Move(new UserInput());
    private Move comp = new Move(new CompInput());
    private String symbol = "";

    @Override
    public void inputData(GameBoard board) throws Exception {
        int ch = board.getDimension()*board.getDimension();
        if (count < ch) {
            user.step(board);
            if (count!=ch-1) {
                comp.step(board);
            }
            board.output();
            count+=2;
            inputData(board);
        }
    }

    @Override
    public boolean win(GameBoard board, int dimension) {
        String[][] arr = board.getArr();
        for (int i = 0; i < dimension; i++) {
            int numberOfMatches = 0;
            int k = 0;
            for (int j = 0; j < dimension-1; j++) {
                if (arr[i][j]==arr[i][j+1] && arr[i][j]!=null) {
                    numberOfMatches++;
                    k = j;
                } else {
                    break;
                }
            }
            if (numberOfMatches == dimension-1) {
                symbol = arr[i][k];
                return true;
            }
        }
        return false;
    }


    private void start(int dimension) throws Exception {
        this.inputData(new GameBoard(dimension));
    }

    public static void main(String[] args) throws Exception {
        Game game = new Game();
        game.start(3);
    }
}
