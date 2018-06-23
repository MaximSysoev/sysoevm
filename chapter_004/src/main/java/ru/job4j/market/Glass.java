package ru.job4j.market;
import java.util.*;

public class Glass {

   public Map<Integer, Application> map = new TreeMap<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    });
    private int id = 0;

    public void add(Application market) {
        map.put(market.hashCode(), market);
    }
}
