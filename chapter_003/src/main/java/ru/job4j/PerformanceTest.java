package ru.job4j;

import java.util.*;

/**
 * PerformanceTest - в этом классе тестируются коллекции.
 */
public class PerformanceTest {
    /**
     * Точка входа в программу.
     * @param args – аргументы метода.
     */
    public static void main(String[] args) {
        ArrList testArrList = new ArrList();
        LinkList testLinkList = new LinkList();
        TreSet testTreSet = new TreSet();

        ArrayList<String> al = new ArrayList<String>();
        LinkedList<String> ll = new LinkedList<String>();
        TreeSet<String> ts = new TreeSet<String>();

        long timeAddAl = testArrList.add(al, 100);
        long timeDelAl = testArrList.delete(al, 10);
        long timeAddLl = testLinkList.add(ll, 100);
        long timeDelLl = testLinkList.delete(ll, 10);
        long timeAddTs = testTreSet.add(ts, 100);
        long timeDelTs = testTreSet.delete(ts, 10);

        System.out.println("Add ArrayList:  " + timeAddAl + "   |   Del ArrayList:  " + timeDelAl);
        System.out.println("Add LinkedList: " + timeAddLl + "   |   Del LinkedList: " + timeDelLl);
        System.out.println("Add TreeSet:    " + timeAddTs + "   |   Del TreeSet:    " + timeDelTs);
    }
}
