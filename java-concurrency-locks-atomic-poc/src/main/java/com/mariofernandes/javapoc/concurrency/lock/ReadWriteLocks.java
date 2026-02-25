package com.mariofernandes.javapoc.concurrency.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLocks {

    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private Map<String, String> cache = new HashMap<>();

    public ReadWriteLocks() {}

    private String read(String key) {
        readWriteLock.readLock().lock(); // Multiple threads can hold readLock simultaneously
        try {
            return cache.get(key);
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    private void write(String key, String value) {
        readWriteLock.writeLock().lock(); // Exclusive, blocks all other read and write locks
        try {
            cache.put(key, value);
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public Map<String, String> multiplesReadAndWrite() throws InterruptedException {
        final String key = "lang";
        final int size = 10;
        final int readerSize = 8;
        write(key, "Java");

        var threads = new Thread[size];
        for (int i = 0; i < readerSize; i++) {
            final int id = i;
            threads[i] = Thread.ofVirtual().start(() -> System.out.println("Read " + id + ": " + read(key)));
        }
        for (int i = readerSize; i < size; i++) {
            final int id = i;
            threads[i] = Thread.ofVirtual().start(() -> {
                write(key, "Java " + id);
                System.out.println("Written: Java " + id);
            });
        }
        for (var thread : threads) thread.join();

        return cache;
    }

    public static void run() {
        ReadWriteLocks readWriteLocks = new ReadWriteLocks();
        System.out.println("=== ReentrantReadWriteLock with Unfair Locks ===");
        try {
            var result = readWriteLocks.multiplesReadAndWrite();
            System.out.println("Final cache state: " + result);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
