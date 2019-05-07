package ru.job4j.inputouput;
import java.util.Random;
import java.util.Scanner;
public class StorePhrases {
    private static String[] store;
    public void phrases(Scanner scan) {
        String s = "";
        while(scan.hasNextLine()) {
            s = s + "," + scan.nextLine();
        }
        store = s.split(",");
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
}
