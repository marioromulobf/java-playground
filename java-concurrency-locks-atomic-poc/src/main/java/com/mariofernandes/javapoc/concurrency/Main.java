package com.mariofernandes.javapoc.concurrency;

import com.mariofernandes.javapoc.concurrency.atomic.AtomicIntegers;
import com.mariofernandes.javapoc.concurrency.lock.Conditions;
import com.mariofernandes.javapoc.concurrency.lock.ReadWriteLocks;
import com.mariofernandes.javapoc.concurrency.lock.ReentrantLocks;
import com.mariofernandes.javapoc.concurrency.lock.StampedLocks;

public class Main {

    public static void main(String[] args) {
        System.out.println("=== Java Concurrency - Java Locks and Atomic Variables POC ===\n");
        ReentrantLocks.run();
        ReadWriteLocks.run();
        StampedLocks.run();
        Conditions.run();
        AtomicIntegers.run();
    }
}
