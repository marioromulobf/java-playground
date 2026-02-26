package com.mariofernandes.javapoc.concurrency.lock;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StampedLocksTest {
    private StampedLocks stampedLocks;

    @BeforeEach
    void setup() {
        stampedLocks = new StampedLocks();
    }

    @Test
    @DisplayName("Test operations of StampedLocks: basicStampedLock")
    void testBasicStampedLock_ShouldReturnExpectedDistance() {
        var expectedDistance = 1414.213562373095;
        try {
            var result = stampedLocks.basicStampedLock();

            Assertions.assertEquals(expectedDistance, result, 0.0001, "Result distance should be approximately equal to expected distance.");
        } catch (Exception e) {
            Assertions.fail("An error occurred during the testBasicStampedLock execution: " + e.getMessage());
        }
    }
}
