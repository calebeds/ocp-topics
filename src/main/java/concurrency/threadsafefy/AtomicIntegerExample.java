package concurrency.threadsafefy;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

class AtomicIntegerExample {
    private static final AtomicInteger atomicCount = new AtomicInteger(0);

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            executorService.submit(() -> System.out.print(atomicCount.incrementAndGet() + " "));
        }
    }
}
