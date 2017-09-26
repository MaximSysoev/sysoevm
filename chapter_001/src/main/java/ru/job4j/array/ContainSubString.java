package ru.job4j.array;

public class ContainSubString {

    public boolean contains(String origin, String sub) {
        String subTest="";
        for (int i = 0; i < origin.length(); i++) {
            for (int j = 0; j < sub.length(); j++) {
                if (origin.charAt(i)==sub.charAt(j)) {
                    subTest = subTest + origin.charAt(i);
                    i++;
                } else {
                    break;
                }
            }
        }

        if (subTest.equals(sub)) {
            return true;
        } else {
            return false;
        }
    }

}

