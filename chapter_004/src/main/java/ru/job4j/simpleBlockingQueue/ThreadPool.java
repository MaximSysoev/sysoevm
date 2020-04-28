package ru.job4j.simpleBlockingQueue;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool<E> {
    private final List<Thread> threads = new LinkedList<>();
    private final  SimpleBlockingQueue<Runnable> tasks = new SimpleBlockingQueue<>();

    public void work (Runnable job) {
        Thread thread = new Thread(job);
        threads.add(thread);
        thread.start();
    }


    public void shutdown() {
        for (Thread thread:threads) {
            thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        ThreadPool threadPool = new ThreadPool();

        Runnable task1 = new Runnable() {
            @Override
            public void run() {
                try {
                    threadPool.tasks.doSomething(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable task2 = new Runnable() {
            @Override
            public void run() {
                threadPool.tasks.changeBlock();
            }
        };

        threadPool.work(task1);
        threadPool.work(task2);
        threadPool.shutdown();

    }
}
