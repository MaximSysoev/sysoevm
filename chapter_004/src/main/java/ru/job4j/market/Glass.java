package ru.job4j.market;
import java.util.*;

public class Glass {

    Map<Integer, Application> map = new TreeMap<>();
    private int id = 0;

    public void add(Application market) {
        map.put(market.hashCode(), market);
    }
}
