package ru.job4j.inputouput;

import java.io.BufferedInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;

public class IsChat {

    private boolean stop = false;

    private StorePhrases store = new StorePhrases();

    public void recordChat(String phrase, String log) throws Exception {
        try(PrintWriter output = new PrintWriter(new FileWriter(log,true))) {
            output.printf("%s\r\n", phrase);
        }
    }

    public void chat(InputStream in) throws Exception {
        System.out.print("Ввод команды: ");
        try (BufferedInputStream bis = new BufferedInputStream(in)) {
            Scanner scanner = new Scanner(bis);


            while (scanner.hasNext()) {
                String word = scanner.nextLine();
                String phrase = word + " " + store.rand();
                if (word.equals("стоп")) {
                    stop = true;
                    System.out.println("Данные будут записываться после ввода команды «продолжить»");
                } else if (word.equals("продолжить")) {
                    stop = false;
                    System.out.println("Продолжение ввода...");
                } else if (word.equals("завершить")) {
                    if (stop == false) {
                        System.out.println("Завершение работы");
                        break;
                    } else {
                        System.out.println("Данные будут записываться после ввода команды «продолжить»");
                    }
                } else {
                    if (stop == true) {
                        System.out.println("Запись чата приостановлена. Для возобновления введите «продолжить»");
                    } else {
                        recordChat(phrase, Paths.get("log.txt").toString());
                    }
                }
                System.out.print("Ввод команды: ");
            }

            /*if (stop == false) {
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
                    recordChat(phrase, Paths.get("log.txt").toString());
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
            }*/
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
