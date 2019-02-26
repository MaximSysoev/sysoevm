package ru.job4j.InputOuput;

import java.io.*;

public class CheckByteStream {

    public boolean isNumber(InputStream in) throws IOException {
        try(BufferedInputStream bis = new BufferedInputStream(in) ) {
            int even = (int)bis.read();
                if (even%2==0) {
                    System.out.println("Четное число " + even);
                    return true;
                }

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Нечетное число");
        return false;
    }

    public static void main(String[] args) throws IOException {
        CheckByteStream cbs = new CheckByteStream();
        System.out.println("Введите число");
        cbs.isNumber(System.in);
    }
}
