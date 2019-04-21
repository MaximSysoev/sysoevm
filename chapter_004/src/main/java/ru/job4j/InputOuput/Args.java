package ru.job4j.inputouput;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Args {

    public static void main(String[] args) {

        Path path = Paths.get("/chapter_004/src/main/java/ru/job4j/inputouput/");

        try(
           ZipOutputStream zout = new ZipOutputStream(new FileOutputStream("C:\\projects\\sysoevm\\project.zip"));
        ){

        for (Path element : path) {
           File file = new File(element.toAbsolutePath().toString());
           for (int i = 0; i < file.listFiles().length; i++) {
               File f = new File(file.listFiles()[i].getPath());
               if (f.isDirectory()) {
                   String[] files = f.list();
                   for  (int j = 0; j <files.length; j++) {
                       zout.putNextEntry(new ZipEntry(files[j]));
                   }
               }
           }
           break;
        }

            /*for (int i = 0; i < file.listFiles().length; i++) {
                FileInputStream fis = new FileInputStream(file.listFiles()[i]);
                zout.putNextEntry(new ZipEntry(file.listFiles()[i].getName()));
                int length;
            }*/
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
