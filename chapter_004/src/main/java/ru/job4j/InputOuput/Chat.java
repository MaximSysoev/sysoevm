package ru.job4j.inputouput;
import java.io.*;
import java.util.Scanner;

public class Chat {

    public static void main(String[] args) throws Exception {
        try (
            FileReader reader = new FileReader("C:\\projects\\sysoevm\\word.txt");
        ) {
            new storePhrases().phrases(new Scanner(reader));
            new isChat().chat(System.in);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
