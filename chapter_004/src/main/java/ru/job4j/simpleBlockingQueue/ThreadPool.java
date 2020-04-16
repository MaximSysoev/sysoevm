package ru.job4j.simpleBlockingQueue;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool<E> {
    private final List<Thread> threads = new LinkedList<>();
    private final  SimpleBlockingQueue<Runnable> tasks = new SimpleBlockingQueue<>();
    private  ExecutorService executorService = Executors.newFixedThreadPool(10);

    public void work (Runnable job) {
        this.executorService.execute(job);
    }

    public void shutdown() {
        this.executorService.shutdown();
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

        threadPool.work(task_1);
        threadPool.work(task_2);
        threadPool.shutdown();


    }
}
