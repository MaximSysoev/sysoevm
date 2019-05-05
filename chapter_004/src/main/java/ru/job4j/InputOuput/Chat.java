package ru.job4j.inputouput;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Chat {

    private static String[] store;
    private boolean stop = false;

    public String[] words(Scanner scan) {
        String s = "";
        while(scan.hasNextLine()) {
            s = s + "," + scan.nextLine();
        }
        store = s.split(",");
        return store;
    }

    public String rand() {
        String word = "";
        for (int i = 0; i < store.length; i++) {
            int idx = new Random().nextInt(store.length);
            word = store[idx];
            break;
        }
        return word;
    }

    public void recordChat(String s) throws Exception {
        /*try (
            FileWriter writer = new FileWriter("C:\\projects\\sysoevm\\log.txt");
            BufferedReader br = new BufferedReader(new FileReader("C:\\projects\\sysoevm\\log.txt"));
        ) {
            if (br.readLine() == null) {
                writer.write(s);
            } else {

            }
            //writer.write(s + "\n");
            writer.flush();
        }*/
        // append = true
        try(PrintWriter output = new PrintWriter(new FileWriter("C:\\projects\\sysoevm\\log.txt",true)))
        {
            output.printf("%s\r\n", s);
        }
    }

    public void isChat(InputStream in) throws Exception {
        System.out.print("Ввод: ");
        try (BufferedInputStream bis = new BufferedInputStream(in)) {
            Scanner scanner = new Scanner(bis);
            String word = scanner.nextLine();
            String phrase = word + " " + rand();
            if (stop==false) {
                if (word.equals("продолжить")) {
                    System.out.println("Продолжение ввода...");
                    isChat(System.in);
                } else if (word.equals("стоп")) {
                    stop = true;
                    System.out.println("Данные будут записываться после ввода команды «продолжить»");
                    isChat(System.in);
                } else if (word.equals("завершить")) {
                    System.out.println("Завершение работы");
                } else {
                    recordChat(phrase);
                    isChat(System.in);
                }
            } else  if (stop == true) {
                System.out.println("Запись чата приостановлена. Для возобновления введите «продолжить»");
                if (word.equals("продолжить")) {
                    stop = false;
                    System.out.println("Теперь можно везти запись");
                    isChat(System.in);
                } else {
                    isChat(System.in);
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws Exception {
        try (
            FileReader reader = new FileReader("C:\\projects\\sysoevm\\word.txt");
        ) {
           new Chat().words(new Scanner(reader));
           new Chat().isChat(System.in);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
