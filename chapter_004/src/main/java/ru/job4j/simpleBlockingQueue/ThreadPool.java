package ru.job4j.simpleBlockingQueue;
import java.util.LinkedList;
import java.util.List;

public class ThreadPool<E> {
    private final List<Thread> threads = new LinkedList<>();
    private final  SimpleBlockingQueue<Runnable> tasks = new SimpleBlockingQueue<>();

    public void add(Thread thread) {
        threads.add(thread);
    }

    public void work (Runnable job) {
        new Thread(job).start();
    }

    public void shutdown() {
        for (Thread thread:threads) {
            thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        ThreadPool threadPool = new ThreadPool();

        Thread task_1 = new Thread() {
            @Override
            public void run() {
                try {
                    threadPool.tasks.doSomething(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread task_2 = new Thread() {
            @Override
            public void run() {
                threadPool.tasks.changeBlock();
            }
        };

         threadPool.add(task_1);
         threadPool.add(task_2);
         threadPool.work(task_1);
         threadPool.work(task_2);

         threadPool.shutdown();

    }
}
