package ru.job4j.array;
import java.util.Arrays;

public class ArrayDuplicate {
    public String[] remove(String[] list) {
        int i = 0, k = 0, index = 0;

        String str = "", newStr = "";

        for (i = 0; i < list.length; i++) {
            k = i + 1;
            while (k < list.length) {
                if (list[i] == list[k]) {
                    list[k] = null;
                }
                k++;
            }
        }

        for (i = 0; i < list.length; i++) {
            if (list[i] != null) {
                str = str + list[i] + " ";
            }
            list[i]=null;
        }

        for (char element : str.toCharArray()) {
            if (element != ' ') {
                newStr = newStr + element;
            } else {
                list[index] = newStr;
                newStr = "";
                index++;
            }
        }

        return Arrays.copyOf(list, 3);
    }
}
