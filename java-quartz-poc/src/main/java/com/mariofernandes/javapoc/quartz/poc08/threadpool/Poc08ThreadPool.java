package com.mariofernandes.javapoc.quartz.poc08.threadpool;

import org.quartz.SchedulerConfigException;
import org.quartz.spi.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Poc08ThreadPool implements ThreadPool {
    private boolean virtualThreads;
    private int threadCount = 10;
    private ExecutorService executor;
    private Semaphore availableThreads;

    @Override
    public void initialize() throws SchedulerConfigException {
        if (threadCount <= 0) {
            throw new SchedulerConfigException("Thread count must be greater than 0");
        }

        // VirtualThreadPerTaskExecutor has no concurrency limit.
        // To keep Quartz's behavior consistent, we use threadCount as a limit for the number of concurrent jobs.
        availableThreads = new Semaphore(threadCount);
        if (virtualThreads) {
            executor = Executors.newVirtualThreadPerTaskExecutor();
        } else {
            executor = Executors.newFixedThreadPool(threadCount);
        }
    }

    @Override
    public boolean runInThread(Runnable runnable) {
        if (executor == null) {
            return false;
        }

        if (!availableThreads.tryAcquire()) {
            return false; // No available threads
        }

        try {
            executor.submit(() -> {
                try {
                    runnable.run();
                } finally {
                    availableThreads.release();
                }
            });
            return true;
        } catch (Exception e) {
            availableThreads.release();
            return false;
        }
    }

    @Override
    public int blockForAvailableThreads() {
        return availableThreads.availablePermits();
    }

    @Override
    public void shutdown(boolean waitForJobsToComplete) {
        if (executor == null) {
            return;
        }
        if  (waitForJobsToComplete) {
            executor.close();
        } else {
            executor.shutdown();
        }
    }

    @Override
    public int getPoolSize() {
        return threadCount;
    }

    @Override
    public void setInstanceId(String schedInstId) {
        // Not needed for this implementation
    }

    @Override
    public void setInstanceName(String schedName) {
        // Not needed for this implementation
    }

    public void setThreadCount(int threadCount) {
        this.threadCount = threadCount;
    }

    public void setVirtualThreads(boolean virtualThreads) {
        this.virtualThreads = virtualThreads;
    }
}