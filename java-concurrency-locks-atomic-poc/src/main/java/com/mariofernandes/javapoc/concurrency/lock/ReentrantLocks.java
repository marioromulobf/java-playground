package com.mariofernandes.javapoc.concurrency.lock;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLocks {
    private final ReentrantLock fairLock = new ReentrantLock(true);
    private int counter = 0;

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
    }

}
