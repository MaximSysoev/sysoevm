package ru.job4j.loop;

public class Factorial {
    public int Calc(int n) {
        int fact = 1;
        if (n != 0) {
            for (int i = 1; i <= n; i++) {
                fact = fact * i;
            }
        }
        else {
            fact = 1;
        }
        return fact;
    }
}
