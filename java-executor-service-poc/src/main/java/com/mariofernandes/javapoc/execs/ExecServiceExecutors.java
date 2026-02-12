package com.mariofernandes.javapoc.execs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
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

    public void basicSubmitMethod() throws ExecutionException, InterruptedException {
        confirmExecutorServiceShutdown();
        this.executorService = Executors.newFixedThreadPool(2);

        // execute - fire and forget
        this.executorService.execute(() -> System.out.println("execute() : No return value"));

        // submit (Runnable) - returns Future<?>
        Future<?> future1 = this.executorService.submit(() -> System.out.println("submit(Runnable): returns Future<?>"));
        System.out.println("Future<?>: " + future1.get());

        // submit (Runnable, result) - returns Future<T>
        Future<String> future2 = this.executorService.submit(() -> System.out.println("submit(Runnable, T): returns Future<T>"), Thread.currentThread().getName());
        System.out.println("Future<String>: " + future2.get());

        // submit (Callable) - returns Future<T>
        Future<Integer> future3 = this.executorService.submit(() -> {
            this.threadName = Thread.currentThread().getName();
            System.out.println("submit(Callable): returns Future<T>");
            return this.threadName.length(); // Example return value
        });
        System.out.println("Future<Integer>: " + future3.get());
        this.executorService.close();
    }

    public List<Future<String>> basicInvokeAllMethod() throws InterruptedException {
        confirmExecutorServiceShutdown();

        this.executorService = Executors.newFixedThreadPool(3);
        this.threadNames = new ArrayList<>();

        // Prepare tasks for invokeAll
        List<Callable<String>> tasks = Arrays.asList(
                () -> {
                    String threadName = Thread.currentThread().getName();
                    Thread.sleep(200);
                    this.threadNames.add(threadName);
                    return "Task 1 executed by " + threadName;
                },
                () -> {
                    String threadName = Thread.currentThread().getName();
                    Thread.sleep(100);
                    this.threadNames.add(threadName);
                    return "Task 2 executed by " + threadName;
                },
                () -> {
                    String threadName = Thread.currentThread().getName();
                    Thread.sleep(300);
                    this.threadNames.add(threadName);
                    return "Task 3 executed by " + threadName;
                }
        );

        // Execute all tasks and return a list of Futures
        List<Future<String>> results = this.executorService.invokeAll(tasks);
        this.executorService.close();

        return results;
    }

    public String basicInvokeAnyMethod() throws ExecutionException, InterruptedException {
        confirmExecutorServiceShutdown();

        this.executorService = Executors.newFixedThreadPool(3);
        this.threadNames = new ArrayList<>();

        // Prepare tasks for invokeAny
        List<Callable<String>> tasks = Arrays.asList(
                () -> {
                    String threadName = Thread.currentThread().getName();
                    Thread.sleep(200);
                    this.threadNames.add(threadName);
                    return threadName;
                },
                () -> {
                    String threadName = Thread.currentThread().getName();
                    Thread.sleep(100);
                    this.threadNames.add(threadName);
                    return threadName;
                },
                () -> {
                    String threadName = Thread.currentThread().getName();
                    Thread.sleep(300);
                    this.threadNames.add(threadName);
                    return threadName;
                }
        );

        // Execute any one of the tasks and return its result
        this.threadName = this.executorService.invokeAny(tasks);
        this.executorService.close();

        return this.threadName;
    }

    private void confirmExecutorServiceShutdown() {
        if (Objects.nonNull(this.executorService) && !this.executorService.isShutdown()) {
            this.executorService.close();
        }
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

        try {
            System.out.println("\nRunning basicSubmitMethod...");
            execServiceExecutors.basicSubmitMethod();
        } catch (ExecutionException | InterruptedException e) {
            System.out.println("Basic Submit Method Executor Service was interrupted: " + e.getMessage());
        }

        try {
            System.out.println("\nRunning basicInvokeAllMethod...");
            var results = execServiceExecutors.basicInvokeAllMethod();
            System.out.println("InvokeAll Method Executor terminated: " + (results != null));
            if (results != null) {
                for (Future<String> result : results) {
                    System.out.println("Result: " + result.get());
                }
                System.out.println("Threads used in InvokeAll Method Executor: " + execServiceExecutors.getThreadNames());
            } else {
                System.out.println("No results returned from InvokeAll Method Executor.");
            }
        } catch (InterruptedException e) {
            System.out.println("Basic InvokeAll Method Executor Service was interrupted: " + e.getMessage());
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

        try {
            System.out.println("\nRunning basicInvokeAnyMethod...");

            var result = execServiceExecutors.basicInvokeAnyMethod();

            System.out.println("InvokeAny Method Executor terminated: " + (result != null));
            System.out.println("Result from InvokeAny Method Executor: " + result);
            System.out.println("Threads used in InvokeAny Method Executor: " + execServiceExecutors.getThreadNames());

        } catch (ExecutionException | InterruptedException e) {
            System.out.println("Basic InvokeAny Method Executor Service was interrupted: " + e.getMessage());
        }
    }
}
