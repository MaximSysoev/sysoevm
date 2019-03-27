package ru.job4j.inputouput;

import ru.job4j.simpletree.Node;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Search {

   private List<String> list = new ArrayList<>();

   public void add(File dir, List<String> exts) {
       for (int i = 0; i < dir.listFiles().length; i++) {
           File file = new File(dir.listFiles()[i].getPath());
           String path = file.getName().toString();
           if (!file.isDirectory()) {
               for (int j = 0; j < exts.size(); j++) {
                   if (path.contains(exts.get(j))) {
                       list.add(path);
                   }
               }
           } else {
               add(file, exts);
           }
       }
   }

   public static void main(String[] args) {
       File dir1 = new File(System.getProperty("java.io.tmpdir"));
       List<String> exts = new ArrayList<>();
       exts.add(".txt");
       Search search = new Search();
       search.add(dir1, exts);
       for (int i = 0; i < search.list.size(); i++) {
           System.out.println(search.list.get(i));
       }

   }

}
