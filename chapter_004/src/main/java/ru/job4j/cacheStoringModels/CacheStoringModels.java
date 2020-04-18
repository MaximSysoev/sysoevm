package ru.job4j.cacheStoringModels;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@ThreadSafe
public class CacheStoringModels {

    @GuardedBy("this")
    public ConcurrentHashMap<Integer, Base> map = new ConcurrentHashMap<>();

    private int value;

    public void add(Base model) {
        map.put(model.getId(), model);
    }

    public void update(Base model) throws OptimisticException {
       if (value == model.getVersion()) {
           value = model.getVersion();
           model.setVersion(value+1);
           map.computeIfPresent(model.getId(), (k, v)-> model);
       } else {
            throw new OptimisticException("Модель уже обновлена");
       }
    }

    public synchronized void delete(Base model) {
        map.remove(model.getId());
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
                    } catch (Exception e) {
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
        Thread task_3 = new Thread() {
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
