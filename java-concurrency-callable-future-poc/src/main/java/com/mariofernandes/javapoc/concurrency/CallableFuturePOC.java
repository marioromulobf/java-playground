package com.mariofernandes.javapoc.concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableFuturePOC {
    public CallableFuturePOC() {}

    public Future<String> basicCallableFuture() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        // create a Callable task that returns a String result
        Callable<String> callableTask = () -> {
            String threadName = Thread.currentThread().getName();
            Thread.sleep(1000); // Spend some time
            return "It was executed by thread: " + threadName;
        };

        // submit the task and get a Future
        Future<String> resultFuture = executor.submit(callableTask);

        System.out.println("Callable task submitted. Future status:");
        System.out.println(" - Is done: " + resultFuture.isDone());
        System.out.println(" - Is cancelled: " + resultFuture.isCancelled());

        // get result - blocks until completion
        String result = resultFuture.get();
        System.out.println("Result: " + result);
        System.out.println("Future done status: " + resultFuture.isDone());

        // shutdown the executor
        executor.close();

        return resultFuture;
    }

    public static void run() {
        CallableFuturePOC poc = new CallableFuturePOC();
        try {
            System.out.println("Running basic Callable and Future ...");
            Future<String> result = poc.basicCallableFuture();
            System.out.println("Future result: ");
            System.out.println(" - Is done: " + result.isDone());
            System.out.println(" - Is cancelled: " + result.isCancelled());
            System.out.println(" - Result: " + result.get());
        } catch (Exception e) {
            System.out.println("Error executing basicCallableFuture task: " + e.getMessage());
        }
    }
}
