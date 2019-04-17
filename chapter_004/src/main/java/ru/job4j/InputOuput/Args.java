package ru.job4j.inputouput;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Args {

    public static void main(String[] args) {
        File file = new File("C:\\projects\\sysoevm\\");
        byte[] buffer = new byte[1024];
        try(
           ZipOutputStream zout = new ZipOutputStream(new FileOutputStream("C:\\projects\\sysoevm\\project.zip"));
           FileOutputStream fos = new FileOutputStream("C:\\projects\\sysoevm\\project.zip");
        ){
            File[] files = file.listFiles();

            for (int i = 0; i < file.listFiles().length; i++) {
                FileInputStream fis = new FileInputStream(file.listFiles()[i]);
                zout.putNextEntry(new ZipEntry(file.listFiles()[i].getName()));
                int length;
                while((length = fis.read(buffer)) > 0) {
                    zout.write(buffer, 0, length);
                }
                fis.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
