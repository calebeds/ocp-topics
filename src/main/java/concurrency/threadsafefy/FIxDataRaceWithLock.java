package concurrency.threadsafefy;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class FIxDataRaceWithLock {
    private static int count = 0;
    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> addToCounter())
                    .start();
        }
    }

    private static void addToCounter() {
        if(lock.tryLock()) {
            try {
//                lock.lock();
                int c = count;
                System.out.printf("Before: %s | Thread id: %s %n", count, Thread.currentThread().getId());
                count = c + 1;
                System.out.printf("After: %s | Thread id: %s %n", count, Thread.currentThread().getId());
            } finally {
                lock.unlock();
            }
        } else {
            System.out.println("Failed to get lock");
        }
    }
}
