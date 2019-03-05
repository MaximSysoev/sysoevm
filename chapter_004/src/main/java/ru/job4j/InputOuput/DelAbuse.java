package ru.job4j.inputouput;

import java.io.*;
import java.util.Scanner;

public class DelAbuse  {
    public void dropAbuses(InputStream in, OutputStream out, String[] abuse) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(in);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        Scanner sc = new Scanner(bis);

        int count = 0;
        try {
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
                    bos.write(buffer);
                } else {
                    count = 0;
                }

                System.out.println(bos.toString());
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        DelAbuse delAbuse = new DelAbuse();
        String[] abuse = new String[]{"плохое", "слово"};
        delAbuse.dropAbuses(System.in, System.out, abuse);
    }
}
