package com.mariofernandes.javapoc.concurrency;

import java.util.concurrent.locks.ReentrantLock;

public class LocksPOC {

    private int counter = 0;

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public LocksPOC(){}

    public void basicReentrantLockFairLock() {
        final var fairLock = new ReentrantLock(true);


        for(int i = 0; i < 10; i++) {
            new Thread(() -> {

            }).start();
        }
    }

    public static void run() {
        LocksPOC poc = new LocksPOC();
    }
}
