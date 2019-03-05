package ru.job4j.inputouput;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.*;
import java.util.Scanner;

public class DelAbuse  {
    public void dropAbuses(InputStream in, OutputStream out, String[] abuse) throws IOException {
        try(BufferedInputStream bis = new BufferedInputStream(in)) {
            Scanner sc = new Scanner(bis);
            int count = 0;
            while(sc.hasNext()) {
                String s = sc.next();
                byte[] buffer = s.getBytes();
                for (int i = 0; i < abuse.length; i++) {
                    if (s.equals(abuse[i])) {
                        count = 1;
                        break;
                    }
                }
                if (count == 0) {
                   out.write(buffer);
                } else {
                    count = 0;
                }

                System.out.println(out.toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        DelAbuse delAbuse = new DelAbuse();
        String[] abuse = new String[]{"слово1", "слово2"};
        delAbuse.dropAbuses(System.in, new ByteOutputStream(), abuse);
    }
}
