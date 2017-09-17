package ru.job4j.max;

public class Max {
    public int max(int first, int second) {
        int maxvalue = first  < second ? second : first;
        return maxvalue;
    }

    public int max (int first, int second, int third) {
        int maxValue = this.max(first, second);
        int result = this.max(maxValue, third);
        return result;
    }
}
