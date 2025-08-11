package concurrency.executorservice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class SubmitTasksWithCollections {
    private static final ExecutorService executorService = Executors.newSingleThreadExecutor();
//    private static final ExecutorService executorService = Executors.newFixedThreadPool(4);

    private static final List<Callable<String>> callables = new ArrayList<>();

    public static void main(String[] args) {
        callables.add(() -> "A");
        callables.add(() -> "B");
        callables.add(() -> "C");
        callables.add(() -> "D");

//        invokeAny();
        invokeAll();
    }

    private static void invokeAny() {
        try {
            String result = executorService.invokeAny(callables);
            System.out.println(result);
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        } finally {
            executorService.shutdown();
        }
        System.out.println("Always at the end!");
    }

    private static void invokeAll() {
        try {
            List<Future<String>> futures = executorService.invokeAll(callables);
            for(Future<String> future: futures) {
                System.out.println(future.get());
            }
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        } finally {
            executorService.shutdown();
        }
        System.out.println("Always at the end!");

    }
}
