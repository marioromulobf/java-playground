package com.mariofernandes.javapoc.concurrency;

import java.util.concurrent.locks.ReentrantLock;

public class LocksPOC {

    private int counter;

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public LocksPOC(){}

    public void basicReentrantLockFairLock() throws InterruptedException {
        setCounter(0);
        final var fairLock = new ReentrantLock(true);
        final int size = 10;

        var threads = new Thread[size];
        for(int i = 0; i < size; i++) {
            threads[i] = Thread.ofVirtual().start(() -> {
                for (int j = 0; j < 1000; j++) {
                    fairLock.lock();
                    try {
                        counter++;
                    } finally {
                        fairLock.unlock();
                    }
                }
            });
        }

        for (var thread : threads) thread.join();

        System.out.println("Counter value: " + counter);
    }

    public static void run() {
        LocksPOC poc = new LocksPOC();

        try {
            System.out.println("=== Basic ReentrantLock with Fair Lock ===");
            poc.basicReentrantLockFairLock();
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
