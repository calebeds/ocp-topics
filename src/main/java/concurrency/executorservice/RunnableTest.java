package concurrency.executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class RunnableTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        // execute the Runnable task (asynchronously) - void run()
        executorService.execute(() -> System.out.println("Runnable example"));

        // shutdown the executor service otherwise this application will never terminate;
        // existing tasks will be allowed to complete but no new tasks accepted
        executorService.shutdown();
    }
}
