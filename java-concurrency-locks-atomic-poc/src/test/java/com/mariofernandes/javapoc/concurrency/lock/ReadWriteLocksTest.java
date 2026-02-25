package com.mariofernandes.javapoc.concurrency.lock;

import org.junit.jupiter.api.BeforeEach;

public class ReadWriteLocksTest {
    private ReadWriteLocks readWriteLocks;

    @BeforeEach
    void setup() {
        readWriteLocks = new ReadWriteLocks();
    }


}
