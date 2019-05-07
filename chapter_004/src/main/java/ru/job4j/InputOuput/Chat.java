package ru.job4j.inputouput;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Chat {

    public static void main(String[] args) throws Exception {
        Path filePath = Paths.get("word.txt");
        try (
                FileReader reader = new FileReader(filePath.toString());
        ) {
            new StorePhrases().phrases(new Scanner(reader));
            new IsChat().chat(System.in);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
