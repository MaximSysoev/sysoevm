package ru.job4j.simpleBlockingQueue;

public class ParallelSearch {

    public static void main(String[] args) throws InterruptedException {
        SimpleBlockingQueue<Integer> queue = new SimpleBlockingQueue<Integer>();
        final  boolean blockCunsomer = true;

        final Thread consumer = new Thread(
                () -> {
                    while (true) {
                        try {
                            if (!queue.queue.isEmpty()) {
                                System.out.println(queue.poll());
                            } else {
                                Thread.currentThread().interrupt();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();

                        }
                    }
                }
        );
        consumer.start();
        new Thread(
                () -> {
                    for (int index = 0; index != 3; index++) {
                        queue.offer(index);
                        System.out.println(queue.queue.peek());
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

        ).start();
    }
}
