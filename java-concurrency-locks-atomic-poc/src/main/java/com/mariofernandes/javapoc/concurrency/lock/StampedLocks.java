package com.mariofernandes.javapoc.concurrency.lock;

import java.math.BigDecimal;
import java.util.concurrent.locks.StampedLock;

public class StampedLocks {

    private StampedLock stampedLock = new StampedLock();
    private double x;
    private double y;

    public StampedLocks() {}

    private void move(double deltaX, double deltaY) {
        long stamp = stampedLock.writeLock();
        try {
            x += deltaX;
            y += deltaY;
        } finally {
            stampedLock.unlockWrite(stamp);
        }
    }

    private double distanceFromOrigin() {
        long stamp = stampedLock.tryOptimisticRead();
        double currentX = x;
        double currentY = y;
        if (!stampedLock.validate(stamp)) {
            stamp = stampedLock.readLock();
            try {
                currentX = x;
                currentY = y;
            } finally {
                stampedLock.unlockRead(stamp);
            }
        }

        return Math.sqrt(currentX * currentX + currentY * currentY);
    }

    public double basicStampedLock() throws InterruptedException {
        var threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = Thread.ofVirtual().start(() -> {
                for (int j = 0; j < 100; j++) {
                    move(1, 1);
                    distanceFromOrigin();
                }
            });
        }
        for (var thread : threads) thread.join();

        return distanceFromOrigin();
    }

    public static void run() {
        StampedLocks stampedLocks = new StampedLocks();
        System.out.println("=== StampedLock ===");
        try {
            var finalDistance = stampedLocks.basicStampedLock();
            System.out.println("Final distance from origin: " + finalDistance);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
