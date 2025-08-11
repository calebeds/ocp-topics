package concurrency.executorservice;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class ScheduledExecutors {
    private static final ScheduledExecutorService scheduledExecutor = Executors.newScheduledThreadPool(10);

    public static void main(String[] args) {
//        showSchedule();
//        scheduleWithFixedDelay();
        scheduleAtFixedRate();
    }

    private static void showSchedule() {
        System.out.println("Start...");
        Future<String> future = scheduledExecutor.schedule(() -> "A", 2, TimeUnit.SECONDS);

        try {
            System.out.println(future.get());
        } catch (ExecutionException| InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            scheduledExecutor.shutdown();
        }

        System.out.println("Always at the end!");
    }

    private static void scheduleWithFixedDelay() {
        System.out.println("Start...");

        final long INITIAL_DELAY = 2000, WAIT_PERIOD_AFTER_PREVIOUS_TASK_FINISHED = 300;
        scheduledExecutor.scheduleWithFixedDelay(() -> System.out.println("Thread id: " + Thread.currentThread().getId()),
                INITIAL_DELAY, WAIT_PERIOD_AFTER_PREVIOUS_TASK_FINISHED, TimeUnit.MILLISECONDS);
//        scheduledExecutor.shutdown(); // if I shut it down, nothing happens
    }

    private static void scheduleAtFixedRate() {
        System.out.println("Start...");

        final long INITIAL_DELAY = 2000, WAIT_PERIOD_BEFORE_STARTING_NEW_TASK = 300;
        scheduledExecutor.scheduleAtFixedRate(() -> System.out.println("Thread id: " + Thread.currentThread().getId()),
                INITIAL_DELAY, WAIT_PERIOD_BEFORE_STARTING_NEW_TASK, TimeUnit.MILLISECONDS);
    }
}
