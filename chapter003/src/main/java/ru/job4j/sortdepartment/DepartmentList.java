package ru.job4j.sortdepartment;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DepartmentList{

    private String department;

    public int compare(int[] left, int[] right) {
        int result = 0;
        int diff = Math.abs(left.length - right.length);

       if (left.length <= right.length) {
           for (int index = 0; index < left.length; index++) {
               result = Integer.compare(left[index], right[index]);
           }
       } else {
           for (int index = 0; index < right.length; index++) {
               result = Integer.compare(left[index], right[index]);
           }
       }

        if (result == 0) {
            result = diff;
        }

      /*  if (left.length <= right.length) {
            for (int index = 0; index < Math.abs(diff); index++) {
                result = Integer.compare(left[index], right[index]);
                if (result != 0) {
                    break;
                }
            }
            if (result == 0) {
                result = diff;
            }
        } else {
            result = 1;
        } */
        return result;
    }


    public List<List<String>> convert(Set<String> list) {
        List<List<String>> lst = new ArrayList<>();
        int index = 1;
        for (String s : list) {
            lst.add(Arrays.asList(s.split("\\\\")));
        }

        System.out.print(lst + " / " + lst.size());
        System.out.println();

        for (int i = 0; i < lst.size(); i++) {
            if (index < lst.size()) {
                int[] left = new int[lst.get(i).size()];
                int[] right = new int[lst.get(index).size()];
                int k = 0;
                for (String s : lst.get(i)) {
                    left[k] = Integer.parseInt(s.substring(s.length()-1));
                    k++;
                }
                k = 0;
                for (String s : lst.get(index)) {
                    right[k] = Integer.parseInt(s.substring(s.length()-1));
                    k++;
                }

               System.out.println(this.compare(left, right));
                index++;
            }
        }
        return lst;
    }

    public static void main(String[] args) {
        DepartmentList departmentList = new DepartmentList();
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.addAll(
                Arrays.asList(
                        "K1\\SK1",
                        "K2\\SK1\\SSK1",
                        "K1\\SK2",
                        "K1\\SK1\\SSK1",
                        "K2",
                        "K1\\SK1\\SSK2",
                        "K2\\SK1\\SSK2",
                        "K3\\SK3\\SSK1"
                )
        );
        List<List<String>> lst = departmentList.convert(treeSet);
    }

}
