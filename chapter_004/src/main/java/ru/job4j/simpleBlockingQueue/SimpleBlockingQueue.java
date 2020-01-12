package ru.job4j.simpleBlockingQueue;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
import java.util.LinkedList;
import java.util.Queue;

@ThreadSafe
public class SimpleBlockingQueue<T> {

    private final Object lock = new Object();

    @GuardedBy("this")
    private final Queue<T> queue = new LinkedList<>();

    //Вставляет элемент в конец очереди
    public synchronized void offer(T value) {
        this.queue.offer(value);
    }

    // возвращает и удаляет головной элемент
    public synchronized T poll() {
            return this.queue.poll();
         }

    public void doSomething(T value) throws InterruptedException {
        synchronized (this.lock) {
            if (queue.peek()==null) {
                offer(value);
                lock.wait();
            }
        }
    }

    public synchronized void changeBlock() {
        synchronized (this.lock) {
            if (queue.peek()!=null) {
                this.poll();
            }
            lock.notify();
        }
    }

    public static void main (String[] args) throws InterruptedException {

        // producer блокирует если очередь заполнена
        // до тех пор пока Cunsomer не извлечет данные из очередиы
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
