package ru.job4j.casQueue;

import javax.annotation.concurrent.ThreadSafe;
import java.util.concurrent.atomic.AtomicReference;

@ThreadSafe
public class CASQueue<T> {

    private AtomicReference<Node<T>> head = new AtomicReference<>();
    private AtomicReference<Node<T>> tail = new AtomicReference<>();

    public void push(T value) {
        Node<T> temp = new Node<>(value);
        Node<T> ref;
        do {
            ref = head.get();
            temp.next = ref;
        } while (!head.compareAndSet(ref, temp));
    }

    public T poll() {
            Node<T> ref;
            Node<T> temp;
            do {
                ref = head.get();
                if (ref == null) {
                    throw new IllegalStateException("Stack is empty");
                }
                temp = ref.next;
            } while (!head.compareAndSet(ref, temp));
            ref.next = null;
            return ref.value;
        }


    private static class Node<T> {

        final T value;
        Node<T> next;

        public Node(final T value) {
            this.value = value;
        }
     }

     public static void main(String[] args) {
        CASQueue<Integer> casQueue = new CASQueue<>();

        Thread thread1 = new Thread() {
            @Override
            public void run() {
                casQueue.push(1);
            }
        };

         Thread thread2 = new Thread() {
             @Override
             public void run() {
                 casQueue.push(2);
             }
         };

         thread1.start();
         thread2.start();

     }
}

