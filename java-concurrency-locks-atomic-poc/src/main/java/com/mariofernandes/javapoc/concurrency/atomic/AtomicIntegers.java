package com.mariofernandes.javapoc.concurrency.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegers {

    private AtomicInteger counter = new AtomicInteger(0);
    public AtomicIntegers() {}

    public Long basicAtomicIntegerIncrement() throws InterruptedException {
        var threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = Thread.ofVirtual().start(() -> {
                for (int j = 0; j < 1000; j++) {
                    counter.incrementAndGet();
                }
            });
        }

        for (Thread thread : threads) thread.join();

        return counter.longValue();
    }

    public static void run() {
        AtomicIntegers atomics = new AtomicIntegers();
        System.out.println("\n=== Atomic Integers ===");
        try {
            System.out.println("Expected value 10000, final Counter Value: " + atomics.basicAtomicIntegerIncrement());
        } catch (Exception e) {
            System.out.println("Thread interrupted: " + e.getMessage());
        }
    }
}
