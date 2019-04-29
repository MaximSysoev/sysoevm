package ru.job4j.inputouput;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Args {

 /*   public void pack(String path, String exts) {
       // Path path = Paths.get("/chapter_004/src/main/java/ru/job4j/inputouput/");
        try (
                ZipOutputStream out = new ZipOutputStream(new FileOutputStream(path + "\\" + "project.zip"));
        ){
            File subDir = new File(path);
            String subdirList[] = subDir.list();

            for (String sd:subdirList) {
                String newPath = path + sd;
                File f = new File(path + sd);
                if(f.isDirectory())
                {
                    String files[] = f.list();
                    for (int i = 0; i < files.length; i++) {
                            System.out.println("Adding: " + files[i]);
                            ZipEntry entry = new ZipEntry(sd +"\\"+files[i]);
                            out.putNextEntry(entry);
                    }
                }
                else
                {
                    ZipEntry entry = new ZipEntry(sd);
                    out.putNextEntry(entry);
                }
            }
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
*/

    public void pack(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getName()));
           /* try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(out.read());
            }*/
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Args().pack(new File("C:\\projects\\sysoevm\\checkstyle.xml"), new File("C:\\projects\\sysoevm\\project.zip"));
    }
}
