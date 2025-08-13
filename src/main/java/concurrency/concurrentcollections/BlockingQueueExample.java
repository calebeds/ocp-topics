package concurrency.concurrentcollections;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

class BlockingQueueExample {
    public static void main(String[] args) {
        BlockingQueue<String> queue = new LinkedBlockingQueue<>();
        // regular Queue methods
        queue.offer("Red");
        queue.offer("Green");
        queue.offer("Blue");
        System.out.println("Poll: " + queue.poll());
        System.out.println("Queue: " + queue.peek());
        System.out.println("Show everything: " + queue);

        try {
            System.out.println("Offer White");
            queue.offer("White", 100, TimeUnit.MILLISECONDS);
            System.out.println("And Poll");

            queue.poll(200, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Show everything: " + queue);
    }
}
