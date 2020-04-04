package ru.job4j.cacheStoringModels;

import java.util.concurrent.ConcurrentHashMap;

public class CacheStoringModels extends Thread {
    private final Object lock = new Object();
    public ConcurrentHashMap<Integer, Base> map = new ConcurrentHashMap<>();

    public void add(Base model) {
        map.put(model.getId(), model);
    }

    public void update(Base model) throws OptimisticException, InterruptedException {
        synchronized (this.lock) {
            try {
                if (map.get(model.getId()).getVersion() == model.getVersion()) {
                    map.get(model.getId()).setVersion(model.getVersion());
                   // this.lock.wait();
                }
            } catch (OptimisticException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void delete(Base model) {

    }

    public static void main(String[] args) throws InterruptedException {
        CacheStoringModels csm = new CacheStoringModels();
        Base model = new Base(0,0);
        csm.add(model);

            Thread task_1 = new Thread() {
                @Override
                public void run() {
                    try {
                        csm.update(model);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };

            Thread task_2 = new Thread() {
                @Override
                public void run() {
                    try {
                        csm.update(model);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            };

            task_1.start();
            task_2.start();
    }

}
