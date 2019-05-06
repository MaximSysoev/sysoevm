package ru.job4j.inputouput;

import java.io.BufferedInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class isChat {

    private boolean stop = false;
    private storePhrases store = new storePhrases();

    public void recordChat(String phrase, String log) throws Exception {
        try(PrintWriter output = new PrintWriter(new FileWriter(log,true))) {
            output.printf("%s\r\n", phrase);
        }
    }

    public void chat(InputStream in) throws Exception {
        System.out.print("Ввод: ");
        try (BufferedInputStream bis = new BufferedInputStream(in)) {
            Scanner scanner = new Scanner(bis);
            String word = scanner.nextLine();
            String phrase = word + " " + store.rand();
            if (stop == false) {
                if (word.equals("продолжить")) {
                    System.out.println("Продолжение ввода...");
                    chat(System.in);
                } else if (word.equals("стоп")) {
                    stop = true;
                    System.out.println("Данные будут записываться после ввода команды «продолжить»");
                    chat(System.in);
                } else if (word.equals("завершить")) {
                    System.out.println("Завершение работы");
                } else {
                    recordChat(phrase, "C:\\projects\\sysoevm\\log.txt");
                    chat(System.in);
                }
            } else  if (stop == true) {
                System.out.println("Запись чата приостановлена. Для возобновления введите «продолжить»");
                if (word.equals("продолжить")) {
                    stop = false;
                    System.out.println("Теперь можно везти запись");
                    chat(System.in);
                } else {
                    chat(System.in);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
