package ru.job4j.condition;


public class Paint {
    public String piramid(int h) {
        StringBuilder builder = new StringBuilder();
        int count = 1;
        for (int i = 1; i <= h; i++) {
            for (int j = 1; j<=count; j++) {
                builder.append("^");
            }
            count+=2;
            builder.append(System.getProperty("line.separator"));
        }
        return  builder.toString();
    }
 }
