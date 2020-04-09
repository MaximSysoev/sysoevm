package ru.job4j.cacheStoringModels;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@ThreadSafe
public class CacheStoringModels extends Thread {

    @GuardedBy("this")
    public ConcurrentHashMap<Integer, Base> map = new ConcurrentHashMap<>();

    private EmulatedCAS value;

    public void add(Base model) {
        map.put(model.getId(), model);
    }

    public void update(Base model) throws OptimisticException {
        value = new EmulatedCAS(model.getVersion());
        int oldValue = value.getValue();
        if (value.compareAndSwap(oldValue, oldValue + 1) != oldValue) {
            oldValue = model.getVersion();
            throw new OptimisticException("Данные уже обновлены");
        }
        model.setVersion(oldValue + 1);
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

            task_1.start();
            task_2.start();

    }

}
