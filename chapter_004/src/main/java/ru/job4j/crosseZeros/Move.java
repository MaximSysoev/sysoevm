package ru.job4j.crosseZeros;
import java.io.BufferedInputStream;
import java.util.Scanner;

public class Move {

    private Input input;

    public Move(Input input) {
        this.input = input;
    }

    public void step(GameBoard board) throws Exception {
        input.inputData(board);
    }

    public static void main(String[] args) throws Exception {
        GameBoard board = new GameBoard(3);
        Move user = new Move(new UserInput());
        Move comp = new Move(new CompInput());
        user.step(board);
        comp.step(board);
        board.output();
    }

/*
    private int dimension;
    private int count = 0;
    private int winsUser = 0;
    private int winComp = 0;
    private String symbol = "";
    private String[][] arr;

    public Play(int dimension) {
        this.dimension = dimension;
        this.arr = new String[dimension][dimension];
    }

    public int getDimension() {
        return dimension;
    }

    public String[][] getArr() {
        return arr;
    }

    public void inputData() throws Exception {
        int steps = this.dimension * this.dimension;
        try (BufferedInputStream bis = new BufferedInputStream(System.in)) {
            Scanner scanner = new Scanner(bis);

            System.out.print("Введите координаты X: ");
            int coordX = scanner.nextInt();

            System.out.print("Введите координаты Y: ");
            int coordY = scanner.nextInt();

            if (this.arr[coordX][coordY] == null) {
                this.arr[coordX][coordY] = "x";
                 if (count < steps) {
                     if (count != steps - 1) {
                        compInput();
                     }
                     out();
                     count += 2;
                     if (!win()) {
                         inputData();
                     } else {
                         if (symbol=="x") {
                             winsUser++;
                             System.out.println("Победил пользователь");
                         } else if (symbol=="0") {
                             winComp++;
                             System.out.println("Победил комп");
                         }
                     }
                }
             } else {
                inputData();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void start() throws Exception {
        inputData();
    }

    public void compInput() {
        int a = 0;
        int b = this.dimension;
        int coordX = a + (int) (Math.random() * b);
        int coordY = a + (int) (Math.random() * b);
        if (arr[coordX][coordY]==null) {
            arr[coordX][coordY] = "0";
        } else {
            compInput();
        }
    }

    public void out() {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean win() {
        for (int i = 0; i < this.dimension; i++) {
            int numberOfMatches = 0;
            int k = 0;
            for (int j = 0; j < this.dimension-1; j++) {
                if (arr[i][j]==arr[i][j+1] && arr[i][j]!=null) {
                    numberOfMatches++;
                    k = j;
                } else {
                    break;
                }
            }
            if (numberOfMatches == this.dimension-1) {
                symbol = arr[i][k];
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        new Play(3).start();
    }
*/
}
