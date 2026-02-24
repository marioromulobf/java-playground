package com.mariofernandes.javapoc.concurrency.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLocks {
    private final ReentrantLock fairLock = new ReentrantLock(true);
    private final ReentrantLock unfairLock = new ReentrantLock(false);

    private int counter = 0;
    private int sharedResource = 0;

    public int getCounter() {
        fairLock.lock();
        try {
            return counter;
        } finally {
            fairLock.unlock();
        }
    }

    public void setCounter(int counter) {
        fairLock.lock();
        try {
            this.counter = counter;
        } finally {
            fairLock.unlock();
        }
    }

    public int getSharedResource() {
        return sharedResource;
    }

    public void increment() {
        //System.out.println("Hold count: " + fairLock.getHoldCount() + ", Is held by current thread: " + fairLock.isHeldByCurrentThread());
        fairLock.lock(); // last statement before the try block, always before try prevents unlocking something you never locked
        try {
            counter++;
            //System.out.println("Counter incremented to: " + counter);
            if (fairLock.getHoldCount() < 3 && counter < 1000) {
                increment();
            }// else {
            //    System.out.println("Hold count after recursive call: " + fairLock.getHoldCount());
            //}
        } finally {
            fairLock.unlock(); // first statement in the finally block
        }
    }

    // High-priority: must get lock or skip update
    public boolean urgentUpdate(int value) {
        // no waiting, now or never
        if (unfairLock.tryLock()) {
            try {
                sharedResource = value;
                return true;
            } finally {
                unfairLock.unlock();
            }
        }
        System.out.println("Urgent update skipped, resource is busy.");
        return false;
    }

    // Normal-priority: will wait up to 200ms
    public boolean normalUpdate(int value) throws InterruptedException {
        if (unfairLock.tryLock(200, TimeUnit.MILLISECONDS)) {
            try {
                sharedResource += value;
                return true;
            } finally {
                unfairLock.unlock();
            }
        }
        System.out.println("Normal update timed out.");
        return false;
    }

    // Low-priority: will wait indefinitely
    public void backgroundUpdate(int value) throws InterruptedException {
        unfairLock.lockInterruptibly(); // waiting indefinitely, but can be interrupted
        try {
            sharedResource -= value;
        } finally {
            unfairLock.unlock();
        }
    }

    public static void run() {
        final int size = 10;
        ReentrantLocks poc = new ReentrantLocks();
        var threads = new Thread[size];

        for(int i = 0; i < size; i++) {
            threads[i] = Thread.ofVirtual().start(() -> {
                for (int j = 0; j < 1000; j++) {
                    poc.increment();
                }
            });
        }

        try {
            for (var thread : threads) thread.join();
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }

        System.out.println("Expected 10666, got final counter value: " + poc.counter);

        var holderThread = Thread.ofVirtual().start(() -> {
            try {
                poc.backgroundUpdate(50);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Background update interrupted.");
            }
        });

        var urgentThread = Thread.ofVirtual().start(() -> {
            System.out.println("Urgent update: " + poc.urgentUpdate(999));
        });

        var normalThread = Thread.ofVirtual().start(() -> {
            try {
                System.out.println("Normal update: " + poc.normalUpdate(100));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Normal update interrupted.");
            }
        });

        try {
            holderThread.join();
            urgentThread.join();
            normalThread.join();
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            System.out.println("Final shared resource value: " + poc.getSharedResource());
        }
    }

}
