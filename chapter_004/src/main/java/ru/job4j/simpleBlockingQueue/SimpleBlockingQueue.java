package ru.job4j.simpleBlockingQueue;

import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

@ThreadSafe
public class SimpleBlockingQueue {

    private final Object lock = new Object();

    @GuardedBy("this")
    private Queue<Integer> queue = new LinkedList<>();

    //Вставляет элемент в конец очереди
    public void offer(int value) {
        queue.offer(value);
    }

    // возвращает и удаляет головной элемент
    public int poll() {
        return queue.poll();
    }

    public void doSomething() throws InterruptedException {
        synchronized (this.lock) {
            if (queue.peek()==null) {
                offer(0);
                lock.wait();
            }
        }
    }

    public void changeBlock() {
        synchronized (this.lock) {
            if (queue.peek()!=null) {
                poll();
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
                    sbq.doSomething();
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
