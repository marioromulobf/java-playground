package com.mariofernandes.javapoc.concurrency.lock;

import org.junit.jupiter.api.BeforeEach;

public class StampedLocksTest {
    private StampedLocks stampedLocks;

    @BeforeEach
    void setup() {
        stampedLocks = new StampedLocks();
    }

    
}
