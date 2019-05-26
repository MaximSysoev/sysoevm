package ru.job4j.calculator;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class InterCalc {

    private double first;
    private double second;

    public void dataEntry() throws Exception {
        try (BufferedInputStream bis = new BufferedInputStream(System.in)) {
            Scanner scanner = new Scanner(bis);
            System.out.print("Первое значение: ");
            this.first = scanner.nextDouble();
            System.out.print("Второе значение: ");
            this.second = scanner.nextDouble();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void actionSelect() throws Exception {
        try (BufferedInputStream bis = new BufferedInputStream(System.in)) {

            System.out.println("1 + \n2 - \n3 * \n4 \\\n5 exit");
            System.out.print("Выберите действие: ");
            Scanner scanner = new Scanner(bis);
            int num = scanner.nextInt();
            switch (num) {
                case 1:
                    this.dataEntry();
                    new Calculator().add(first, second);
                    break;
                case 2:
                    this.dataEntry();
                    new Calculator().substract(first, second);
                    break;
                case 3:
                    this.dataEntry();
                    new Calculator().multiply(first, second);
                    break;
                case 4:
                    this.dataEntry();
                    new Calculator().div(first, second);
                    break;
                case 5:
                    System.out.println("exit");
                    break;
                 default:

                     break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws Exception {
        InterCalc interCalc = new InterCalc();
        interCalc.actionSelect();
    }
}
