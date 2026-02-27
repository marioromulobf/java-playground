package com.mariofernandes.javapoc.concurrency.atomic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AtomicIntegersTest {
    private AtomicIntegers atomics;

    @BeforeEach
    void setup() {
        atomics = new AtomicIntegers();
    }

    @Test
    @DisplayName("Test operations of AtomicIntegers: basicAtomicIntegerIncrement")
    void testBasicAtomicIntegerIncrement_ShouldReturnExpectedCounterValue() {
        var expectedValue = 10000L;
        try {
            var result = atomics.basicAtomicIntegerIncrement();

            Assertions.assertEquals(expectedValue, result, "Result counter value should be equal to expected counter value.");
        } catch (Exception e) {
            Assertions.fail("An error occurred during the testBasicAtomicIntegerIncrement execution: " + e.getMessage());
        }
    }
}
