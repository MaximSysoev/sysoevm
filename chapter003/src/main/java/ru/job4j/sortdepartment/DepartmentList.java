package ru.job4j.sortdepartment;
import java.util.*;

public class DepartmentList{

    private String department;

    public int compare(int[] left, int[] right) {
        int result = 1;
        int count = 0;
        int sizeLeft = left.length;
        int sizeRight = right.length;
        if (sizeLeft == sizeRight - 1) {
            for (int i = 0; i < sizeLeft; i++) {
                if (left[i] == right[i]) {
                    count++;
                }
                if (count == sizeLeft) {
                    result = -1;
                }
            }
        } else if (sizeLeft == sizeRight) {
            for (int i = 0; i < sizeLeft; i++) {
                if (left[i] == right[i]) {
                    count++;
                }
                if (count == sizeLeft) {
                    result = 0;
                } else {
                    result = 1;
                }
            }
        }
        return result;
    }

    public String getDepartment() {
        return this.department;
    }

    public static void main(String[] args) {
        TreeSet<String> treeSet = new TreeSet<String>();
        int k = 0;
        int count = 1;
        String dep;
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

        DepartmentList departmentList = new DepartmentList();
        for (int i=0; i<treeSet.toArray().length; i+=2) {
            if (i+1 < treeSet.toArray().length) {
                int ch = i + 1;
                String[] listLeft = treeSet.toArray()[i].toString().split("\\\\"); // Разбиваю массив.
                String[] listRight = treeSet.toArray()[ch].toString().split("\\\\"); // Разбиваю массив.
                int[] left = new int[listLeft.length];
                int[] right = new int[listRight.length];
                for (int j = 0; j < listLeft.length; j++) {
                    k = Integer.parseInt(listLeft[j].substring(listLeft[j].length()-1));
                    left[j] = k;
                }
                for (int j = 0; j < listRight.length; j++) {
                    k = Integer.parseInt(listRight[j].substring(listRight[j].length()-1));
                    right[j] = k;
                }
                int result = departmentList.compare(left, right);
                dep = "";
                if (result == 1 && left.length < right.length) {
                    k = right.length - left.length;
                    for (int j = 0; j < k; j++) {
                        if (j!=1) {
                            dep = dep + "K" + right[j] + "\\";
                        } else {
                            dep = dep + "SK" + right[j];
                        }
                    }
                } else if (result == -1 && left.length > 1) {
                    treeSet.add("K" + left[0]);
                }
                treeSet.add(dep);
            }
        }

    for (String list : treeSet) {
            System.out.println(list);
        }

    }
}
