package ru.job4j.crosseZeros;
import java.io.BufferedInputStream;
import java.util.Scanner;

public class UserInput implements Input {
    @Override
    public void inputData(GameBoard board) throws Exception {
        String[][] arr = board.getArr();
        int x = 0;
        int y = 0;
        try (BufferedInputStream bis = new BufferedInputStream(System.in)) {
            Scanner scanner = new Scanner(bis);
            System.out.print("Введите координаты X: ");
            if (scanner.hasNextLine()) {
                x = scanner.nextInt();
            }

            System.out.print("Введите координаты Y: ");
            if (scanner.hasNextLine()) {
                y = scanner.nextInt();
            }

            if (arr[x][y] == null) {
                board.nextMove(x, y, "x");
            } else {
                System.out.println("Текущее поле занято, введите координаты заново");
                inputData(board);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
