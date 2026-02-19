package com.mariofernandes.javapoc.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

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

    public List<Future<String>> basicTimeoutAndCancellation() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // Task 1 - Slow task that will be timeout
        Callable<String> slowTask = () -> {
            Thread.sleep(5000); // 5 seconds
            return "Slow task completed";
        };

        // Task 2 - Long task that will be cancelled
        Callable<String> longTask = () -> {
            for (int i = 0; i < 10; i++) {
                if (Thread.currentThread().isInterrupted()) {
                    return "Long task was interrupted";
                }
                Thread.sleep(500);
            }
            return "Long task completed";
        };

        Future<String> slowFuture = executor.submit(slowTask);
        try {
            String slowResult = slowFuture.get(2, TimeUnit.SECONDS);
            System.out.println("Slow task result: " + slowResult);
        } catch (TimeoutException e) {
            boolean cancelled = slowFuture.cancel(true);
            System.out.println("Slow task timed out:");
            System.out.println(" - cancelled: " + cancelled);
            System.out.println(" - isCancelled: " + slowFuture.isCancelled());
        }

        Future<String> longFuture = executor.submit(longTask);
        Thread.sleep(1500);
        boolean cancelled = longFuture.cancel(true);
        try {
            String longResult = longFuture.get();
            System.out.println("Long task result: " + longResult);
        } catch (CancellationException e) {
            System.out.println("Long task was cancelled:");
            System.out.println(" - cancelled: " + cancelled);
            System.out.println(" - isCancelled: " + longFuture.isCancelled());
        }
        executor.close();

        return List.of(slowFuture, longFuture);
    }

    public List<Future<String>> basicInvokeAllWithTimeout() throws InterruptedException {
        final int LIMIT = 3;
        List<Callable<String>> tasks = new ArrayList<>();
        ExecutorService executor = Executors.newFixedThreadPool(LIMIT);

        for (int i = 1; i <= LIMIT; i++) {
            final int taskId = i;
            tasks.add(() -> {
                Thread.sleep(taskId * 1500);
                return "Completed task " + taskId;
            });
        }

        List<Future<String>> result = executor.invokeAll(tasks, 2, TimeUnit.SECONDS);
        result.forEach(future -> {
            System.out.println("Future status: " + future.state());
        });

        executor.close();
        return result;
    }

    public List<String> basicInvokeAnyWithTimeout() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        List<Callable<String>> tasks = List.of(
                () -> {
                    Thread.sleep(3000);
                    return "Slow task completed";
                },
                () -> {
                    Thread.sleep(1000);
                    return "Medium task completed";
                },
                () -> {
                    Thread.sleep(500);
                    return "Fast task completed";
                }
        );

        List<String> results = new ArrayList<>();
        results.add(executor.invokeAny(tasks));

        try {
            results.add(executor.invokeAny(tasks, 200, TimeUnit.MILLISECONDS));
        } catch (TimeoutException e) {
            System.out.println("invokeAny timed out: " + e.getMessage());
        }
        executor.close();
        return results;
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

        try {
            System.out.println("\nRunning basic timeout and cancellation ...");
            List<Future<String>> result = poc.basicTimeoutAndCancellation();
                result.forEach(future -> {
                    System.out.println("Future status:");
                    System.out.println(" - Is done: " + future.isDone());
                    System.out.println(" - Is cancelled: " + future.isCancelled());
                    try {
                        System.out.println(" - Result: " + future.get());
                    } catch (CancellationException e) {
                        System.out.println(" - Error getting result: " + e.getMessage());
                    } catch (Exception e) {
                        System.out.println("Error executing basicTimeoutAndCancellation task: " + e.getMessage());
                    }
                });
        } catch (Exception e) {
            System.out.println("Error executing basicTimeoutAndCancellation task: " + e.getMessage());
        }

        try {
            System.out.println("\nRunning basic invoke all with timeout ...");
            List<Future<String>> result = poc.basicInvokeAllWithTimeout();
            for (int i = 0; i < result.size(); i++) {
                Future<String> future = result.get(i);
                System.out.println("Future " + (i + 1) + " status:");
                System.out.println(" - Is done: " + future.isDone());
                System.out.println(" - Is cancelled: " + future.isCancelled());
                System.out.println(" - State: " + future.state());
                try {
                    System.out.println(" - Result: " + future.get());
                } catch (CancellationException e) {
                    System.out.println(" - Error getting result: " + e.getMessage());
                }
            }
        } catch (Exception e) {
            System.out.println("Error executing basicInvokeAllWithTimeout task: " + e.getMessage());
        }

        try {
            System.out.println("\nRunning basic invoke any with timeout ...");
            var result = poc.basicInvokeAnyWithTimeout();
            result.forEach(res -> {
                System.out.println("Result: " + res);
            });
        } catch (Exception e) {
            System.out.println("Error executing basicInvokeAnyWithTimeout task: " + e.getMessage());
        }
    }
}
