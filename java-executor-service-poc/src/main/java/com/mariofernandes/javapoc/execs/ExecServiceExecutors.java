package com.mariofernandes.javapoc.execs;

import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecServiceExecutors {

    private ExecutorService executorService;

    public ExecServiceExecutors() {}

    public boolean basicSingleThreadExecutor() throws InterruptedException {
        // Confirming that executorService has been shut down
        if (Objects.nonNull(executorService) && !executorService.isShutdown()) {
            executorService.shutdown();
        }
        // Creating a single-threaded executor service
        this.executorService = Executors.newSingleThreadExecutor();
        // Execute the given task in the single thread
        this.executorService.execute(() -> System.out.println("Single Thread: " + Thread.currentThread().getName()));
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
    }
}
