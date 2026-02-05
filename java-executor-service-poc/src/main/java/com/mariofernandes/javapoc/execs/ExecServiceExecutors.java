package com.mariofernandes.javapoc.execs;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
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
            executorService.shutdown();
        }
        // Creating a single-threaded executor service
        this.executorService = Executors.newSingleThreadExecutor();
        // Execute the given task in the single thread
        this.executorService.execute(() -> {
            this.threadName = Thread.currentThread().getName();
            System.out.println("Single Thread: " + this.threadName);
        });
        // Initiating an orderly shutdown
        this.executorService.shutdown();

        // return status of termination
        return this.executorService.awaitTermination(1, TimeUnit.SECONDS);
    }

    public boolean basicCachedThreadPool() throws InterruptedException {
        // Confirming that executorService has been shut down
        if (Objects.nonNull(executorService) && !executorService.isShutdown()) {
            executorService.shutdown();
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
        // Initiating an orderly shutdown
        this.executorService.shutdown();

        // return status of termination
        return this.executorService.awaitTermination(1, TimeUnit.SECONDS);
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
    }
}
