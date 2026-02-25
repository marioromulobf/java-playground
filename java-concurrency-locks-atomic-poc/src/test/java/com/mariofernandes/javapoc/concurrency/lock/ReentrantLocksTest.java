package com.mariofernandes.javapoc.concurrency.lock;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ReentrantLocksTest {
    private ReentrantLocks reentrantLocks;

    @BeforeEach
    void setup() {
        reentrantLocks = new ReentrantLocks();
    }

    @Test
    @DisplayName("Test operations of ReentrantLocks: checkRaceCondition")
    void testCheckRaceCondition_ShouldReturnExpectedCounterValue() {
        var result = reentrantLocks.checkRaceCondition();
        var expectedValue = 10666;

        Assertions.assertEquals(expectedValue, result, "Result value should match with expected counter value.");
    }

    @Test
    @DisplayName("Test operations of ReentrantLocks: checkDeadlocks")
    void testCheckDeadlocks_ShouldReturnExpectedValue() {
        var result = reentrantLocks.checkDeadlocks();
        var expectedValue = 1099;

        Assertions.assertEquals(expectedValue, result, "Result value should match with expected value.");
    }
}
