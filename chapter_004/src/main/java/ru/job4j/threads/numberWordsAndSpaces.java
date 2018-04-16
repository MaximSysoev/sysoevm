package ru.job4j.threads;

public class NumberWordsAndSpaces {

    public String str;
    private int countSpaces = 0;
    private int countWords = 0;

    public NumberWordsAndSpaces(String str) {
        this.str = str;
    }

    public void counting() {
        String word = "";
        int innerCount = 0;
        for (int i = 0; i < str.length(); i++) {
            if (innerCount == str.length() - 1 && str.charAt(i)!=' ') {
                countWords++;
            }
            if ( str.charAt(i) != ' ') {
                word = word + Character.toString( str.charAt(i) );
            } else {
                if (!word.equals("")) {
                    word = "";
                    countWords++;
                }
                countSpaces++;
            }
            innerCount++;
        }
    }

    public int countWords() {
        return countWords;
    }

    public int countSpaces() {
        return countSpaces;
    }

    public static final class CalculateWords implements  Runnable {
        @Override
        public void run() {
            NumberWordsAndSpaces nws = new NumberWordsAndSpaces("word1 word2 word3   word4    word5 word6");
            nws.counting();
            System.out.println(nws.countWords());
        }
    }

    public static final class CalculateSpaces implements Runnable {
        @Override
        public void run() {
            NumberWordsAndSpaces nws = new NumberWordsAndSpaces("word1 word2 word3   word4    word5 word6");
            nws.counting();
            System.out.println(nws.countSpaces());
        }
    }

}
