package com.mariofernandes.javapoc.concurrency.lock;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ReadWriteLocksTest {
    private ReadWriteLocks readWriteLocks;

    @BeforeEach
    void setup() {
        readWriteLocks = new ReadWriteLocks();
    }

    @Test
    @DisplayName("Test operations of ReadWriteLocks: multiplesReadAndWrite")
    void testMultiplesReadAndWrite_ShouldReturnExpectedCacheValue() {
        var expectedValue = "Java 9";
        var expectedKey = "lang";
        try {
            var result = readWriteLocks.multiplesReadAndWrite();

            Assertions.assertNotNull(result);
            Assertions.assertEquals(1, result.size());
            Assertions.assertTrue(result.containsKey(expectedKey));
            Assertions.assertEquals(expectedValue, result.get(expectedKey), "Result value should match with expected cache value.");
        } catch (Exception e) {
            Assertions.fail("An error occurred during the testMultiplesReadAndWrite execution: " + e.getMessage());
        }
    }
}
