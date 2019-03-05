package ru.job4j.inputouput;

import java.io.*;
import java.util.Scanner;

public class DelAbuse  {
    public void dropAbuses(InputStream in, OutputStream out, String[] abuse) throws IOException {
        try(
                BufferedInputStream bis = new BufferedInputStream(in);
                BufferedOutputStream bos = new BufferedOutputStream(out);
        ) {
            Scanner sc = new Scanner(bis);
            while(sc.hasNext()) {
                byte[] buffer = sc.next().getBytes();
                bos.write(buffer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        DelAbuse delAbuse = new DelAbuse();
        String[] abuse = new String[]{"слово1", "слово2"};
        delAbuse.dropAbuses(System.in, System.out, abuse);
    }
}
