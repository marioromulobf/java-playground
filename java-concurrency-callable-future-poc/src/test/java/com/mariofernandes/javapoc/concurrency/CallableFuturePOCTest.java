package com.mariofernandes.javapoc.concurrency;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CallableFuturePOCTest {

    private CallableFuturePOC callableFuturePOC;

    @BeforeEach
    void setup() {
        callableFuturePOC = new CallableFuturePOC();
    }

    @Test
    @DisplayName("Teste operations of CallableFuturePOC: basicCallableFuture")
    void testBasicCallableFuture_ShouldReturnExpectedResult() {
        try {
            var result = callableFuturePOC.basicCallableFuture();
            var expectedResultValue = "It was executed by thread: pool-1-thread-1";

            Assertions.assertNotNull(result, "Future result should not be null");
            Assertions.assertTrue(result.isDone(), "Future should be done.");
            Assertions.assertFalse(result.isCancelled(), "Future should not be cancelled.");
            Assertions.assertEquals(expectedResultValue, result.get(), "Future result should match expected output.");
        } catch (Exception e) {
            Assertions.fail("Exception thrown during test execution: " + e.getMessage());
        }
    }
}
