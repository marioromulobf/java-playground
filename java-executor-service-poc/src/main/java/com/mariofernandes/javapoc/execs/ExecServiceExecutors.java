package com.mariofernandes.javapoc.execs;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ExecServiceExecutors {

    private ExecutorService executorService;
    private String threadName;
    private List<String> threadNames;

    public ExecServiceExecutors() {}

    public String getThreadName() {
        return threadName;
    }

    public List<String> getThreadNames() {
        return threadNames;
    }

    public boolean basicSingleThreadExecutor() throws InterruptedException {
        // Confirming that executorService has been shut down
        if (Objects.nonNull(executorService) && !executorService.isShutdown()) {
            executorService.close();
        }
        // Creating a single-threaded executor service
        this.executorService = Executors.newSingleThreadExecutor();
        // Execute the given task in the single thread
        this.executorService.execute(() -> {
            this.threadName = Thread.currentThread().getName();
            System.out.println("Single Thread: " + this.threadName);
        });
        // Orderly default shutdown of the executor service
        this.executorService.close();

        // return status of termination
        return this.executorService.awaitTermination(1, TimeUnit.SECONDS);
    }

    public boolean basicCachedThreadPool() throws InterruptedException {
        // Confirming that executorService has been shut down
        if (Objects.nonNull(executorService) && !executorService.isShutdown()) {
            executorService.close();
        }
        this.threadNames = new ArrayList<>();
        // Creating a new cached thread pool executor service
        this.executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 5; i++) {
            final int taskId = i;
            // Execute the given task in the cached thread pool
            this.executorService.execute(() -> {
                this.threadName = Thread.currentThread().getName();
                this.threadNames.add(this.threadName);
                System.out.println("Cached Thread Pool - Task " + taskId + ": " + this.threadName);
            });
        }
        // Orderly default shutdown of the executor service
        this.executorService.close();

        // return status of termination
        return this.executorService.awaitTermination(1, TimeUnit.SECONDS);
    }

    public List<Future<Integer>> basicWorkStealingPool() throws InterruptedException {
        // Confirming that executorService has been shut down
        if (Objects.nonNull(this.executorService) && !this.executorService.isShutdown()) {
            this.executorService.close();
        }
        this.threadNames = new ArrayList<>();
        List<Future<Integer>> results = new ArrayList<>();
        // Creating a new work-stealing pool executor service
        this.executorService = Executors.newWorkStealingPool();
        for (int i = 0; i < 10; i++) {
            final int taskId = i;
            // Submit a task that returns a result to the work-stealing pool
            results.add(
                this.executorService.submit(() -> {
                    this.threadName = Thread.currentThread().getName();
                    this.threadNames.add(this.threadName);
                    System.out.println("Work-Stealing Pool - Task " + taskId + ": " + this.threadName);
                    return taskId * taskId; // Example computation
                })
            );
        }
        // Orderly default shutdown of the executor service
        this.executorService.close();

        return results;
    }

    public static void run() {
        ExecServiceExecutors execServiceExecutors = new ExecServiceExecutors();

        try {
            System.out.println("Running basicSingleThreadExecutor...");
            var result = execServiceExecutors.basicSingleThreadExecutor();
            System.out.println("Single Thread Executor terminated: " + result);
        } catch (InterruptedException e) {
            System.out.println("Basic Single Thread Executor Service was interrupted: " + e.getMessage());
        }

        try {
            System.out.println("\nRunning basicCachedThreadPool...");
            var result = execServiceExecutors.basicCachedThreadPool();
            System.out.println("Cached Thread Pool Executor terminated: " + result);
            System.out.println("Threads used in Cached Thread Pool: " + execServiceExecutors.getThreadNames());
        } catch (InterruptedException e) {
            System.out.println("Basic Cached Thread Pool Executor Service was interrupted: " + e.getMessage());
        }

        try {
            System.out.println("\nRunning basicWorkStealingPool...");
            var results = execServiceExecutors.basicWorkStealingPool();
            System.out.println("Work-Stealing Pool Executor terminated: " + (results != null));
            if (results != null) {
                System.out.println("Threads used in Cached Thread Pool: " + results);
                for (int i = 0; i < results.size(); i++) {
                    try {
                        System.out.println("Result of Task " + i + ": " + results.get(i).get());
                    } catch (Exception e) {
                        System.out.println("Error retrieving result for Task " + i + ": " + e.getMessage());
                    }
                }
                System.out.println("Threads used in Cached Thread Pool: " + execServiceExecutors.getThreadNames());
            } else {
                System.out.println("No results returned from Work-Stealing Pool Executor.");
            }
        } catch (InterruptedException e) {
            System.out.println("Basic Work-Stealing Pool Executor Service was interrupted: " + e.getMessage());
        }
    }
}
