package ru.job4j.simpleBlockingQueue;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
import java.util.LinkedList;
import java.util.Queue;

@ThreadSafe
public class SimpleBlockingQueue<T> {

    private final Object lock = new Object();

    @GuardedBy("this")
    public final Queue<T> queue = new LinkedList<>();

    // Вставляет элемент в конец очереди
    public synchronized void offer(T value) {
        this.queue.offer(value);
    }

    // возвращает и удаляет головной элемент
    public synchronized T poll() {
        return this.queue.poll();
    }

    public synchronized void doSomething(T value) throws InterruptedException {
        synchronized (this.lock) {
            while (this.queue.peek()==null) {
                try {
                    System.out.println(String.format("%s wait", Thread.currentThread().getId()));
                    offer(value);
                    this.lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(String.format("%s userfull work", Thread.currentThread().getId()));
        }
    }

    public synchronized void changeBlock() {
        synchronized (this.lock) {
            System.out.println(String.format("%s enable", Thread.currentThread().getId()));
            poll();
            this.lock.notify();
        }
    }

    public static void main (String[] args) throws InterruptedException {

        // producer блокирует поток если очередь заполнена
        // до тех пор пока Cunsomer не извлечет данные из очереди
        final SimpleBlockingQueue sbq = new SimpleBlockingQueue();

        //customer
        Thread cunsomer =  new Thread() {
            @Override
            public void run() {
                try {
                    sbq.doSomething(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        //producer
        Thread producer = new Thread() {
            @Override
            public void run() {
                sbq.changeBlock();
            }
        };

        cunsomer.start();
        producer.start();



    }

}
