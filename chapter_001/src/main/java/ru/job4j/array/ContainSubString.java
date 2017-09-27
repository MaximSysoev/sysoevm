package ru.job4j.array;

public class ContainSubString {

    public boolean contains(String origin, String sub) {
        String subTest="";
        for (int i = 0; i < origin.length(); i++) {
            if (origin.charAt(i) == sub.charAt(0)) {
                subTest = "";
                subTest =subTest + sub.charAt(0);
                for (int j = 1; j < sub.length(); j++) {
                    if (origin.charAt(i + j) == sub.charAt(j)) {
                        subTest = subTest + origin.charAt(i + j);
                        i = subTest.equals(sub) ? origin.length() : i;
                    }
                }
            }
        }
        return (subTest.equals(sub)) ? true : false;
    }

}

