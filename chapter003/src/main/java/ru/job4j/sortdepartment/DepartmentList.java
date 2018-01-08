package ru.job4j.sortdepartment;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DepartmentList{

    private String department;

    public int compare(int[] left, int[] right) {
        int result = 0;
        int diff = left.length - right.length;
        for (int index = 0; index < Math.abs(diff); index++) {
            result = Integer.compare(left[index], right[index]);
            if (result != 0) {
                break;
            }
        }
        if (result == 0) {
            result = diff;
        }
        System.out.println(result);
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
        System.out.println();

        for (int i = 0; i < lst.size(); i+=2) {
            if (index < lst.size()) {
                int[] left = new int[lst.get(i).size()];
                int[] right = new int[lst.get(index).size()];
                int k = 0;
                for (String s : lst.get(i)) {
                    left[k] = Integer.parseInt(s.substring(s.length()-1));
                }

                for (String s : lst.get(index)) {
                    right[k] = Integer.parseInt(s.substring(s.length()-1));
                }
                index+=2;
                this.compare(left, right);
            } else {
                index-=2;
                int[] left = new int[lst.get(i).size()];
                int[] right = new int[lst.get(index).size()];
                int k = 0;
                for (String s : lst.get(i)) {
                    left[k] = Integer.parseInt(s.substring(s.length()-1));
                }

                for (String s : lst.get(index)) {
                    right[k] = Integer.parseInt(s.substring(s.length()-1));
                }
                this.compare(left, right);
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
                        "K2\\SK1\\SSK2"
                )
        );
        List<List<String>> lst = departmentList.convert(treeSet);

        int result = departmentList.compare(new int[] {1,1,2}, new int[] {1, 2});

    }

}
