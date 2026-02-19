package com.mariofernandes.javapoc.concurrency;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Future;

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
            var expectedBeginValue = "It was executed by thread: pool-";
            var expectedEndValue = "-thread-1";

            Assertions.assertNotNull(result, "Future result should not be null");
            Assertions.assertTrue(result.isDone(), "Future should be done.");
            Assertions.assertFalse(result.isCancelled(), "Future should not be cancelled.");
            Assertions.assertTrue(result.get().startsWith(expectedBeginValue), "Future result should match expected output.");
            Assertions.assertTrue(result.get().endsWith(expectedEndValue), "Future result should match expected output.");
        } catch (Exception e) {
            Assertions.fail("Exception thrown during test execution: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Test operations of CallableFuturePOC: basicTimeoutAndCancellation")
    void testBasicTimeoutAndCancellation_ShouldReturnExpectedResults() {
        try {
            var results = callableFuturePOC.basicTimeoutAndCancellation();

            Assertions.assertNotNull(results, "Results list should not be null");
            Assertions.assertEquals(2, results.size(), "Results list should contain 2 futures");

            for (int i = 0; i < results.size(); i++) {
                var future = results.get(i);

                Assertions.assertNotNull(future, "Future at index " + i + " should not be null");
                Assertions.assertTrue(future.isDone(), "Future at index " + i + " should be done.");
                Assertions.assertTrue(future.isCancelled(), "Future at index " + i + " should be cancelled.");
                Assertions.assertThrowsExactly(CancellationException.class, future::get,
                        "Future at index " + i + " should throw CancellationException when get() is called.");
            }
        } catch (Exception e) {
            Assertions.fail("Exception thrown during test execution: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Test operations of CallableFuturePOC: basicInvokeAllWithTimeout")
    void testBasicInvokeAllWithTimeout_ShouldReturnExpectedResults() {
        try {
            var results = callableFuturePOC.basicInvokeAllWithTimeout();

            Assertions.assertNotNull(results, "Results list should not be null");
            Assertions.assertEquals(3, results.size(), "Results list should contain 3 futures");

            var expectedStates = List.of(Future.State.SUCCESS, Future.State.CANCELLED, Future.State.CANCELLED);

            for (int i = 0; i < results.size(); i++) {
                var future = results.get(i);

                Assertions.assertNotNull(future, "Future at index " + i + " should not be null");
                Assertions.assertTrue(future.isDone(), "Future at index " + i + " should be done.");

                if (i == 0) {
                    Assertions.assertFalse(future.isCancelled(), "Future at index " + i + " should not be cancelled.");
                    Assertions.assertEquals(expectedStates.get(i), future.state(),
                            "Future at index " + i + " should have state SUCCESS.");
                    Assertions.assertEquals("Completed task 1", future.get(),
                            "Future at index " + i + " should return expected result.");
                } else {
                    Assertions.assertTrue(future.isCancelled(), "Future at index " + i + " should be cancelled.");
                    Assertions.assertEquals(expectedStates.get(i), future.state(),
                            "Future at index " + i + " should have state CANCELLED.");
                    Assertions.assertThrowsExactly(CancellationException.class, future::get,
                            "Future at index " + i + " should throw CancellationException when get() is called.");
                }
            }
        } catch (Exception e) {
            Assertions.fail("Exception thrown during test execution: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Test operations of CallableFuturePOC: basicInvokeAnyWithTimeout")
    void testBasicInvokeAnyWithTimeout_ShouldReturnExpectedResults() {
        try {
            var results = callableFuturePOC.basicInvokeAnyWithTimeout();
            var expectedResults = List.of("Fast task completed");

            Assertions.assertNotNull(results, "Results list should not be null");
            Assertions.assertEquals(expectedResults.size(), results.size(), "Results list should contain 1 result");
            Assertions.assertEquals(expectedResults, results, "Results should match expected output");
        } catch (Exception e) {
            Assertions.fail("Exception thrown during test execution: " + e.getMessage());
        }
    }
}
