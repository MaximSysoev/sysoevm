package ru.job4j.simpleBlockingQueue;

public class ParallelSearch extends Thread {

    public static void main(String[] args) throws InterruptedException {
        SimpleBlockingQueue<Integer> queue = new SimpleBlockingQueue<Integer>();
        final  boolean blockCunsomer = true;
        final Thread consumer = new Thread(
                () -> {
                    while (!Thread.currentThread().isInterrupted()) {
                        try {
                            if (!queue.queue.isEmpty()) {
                                queue.poll();
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
                        try {
                            Thread.sleep(500);
                            System.out.println(queue.queue.poll());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

        ).start();
    }
}
