package com.mariofernandes.javapoc.stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class UnaryOperatorStreamTest {
    private UnaryOperatorStream unaryOperatorStream;

    @BeforeEach
    void setup() {
        this.unaryOperatorStream = new UnaryOperatorStream();
    }

    @Test
    @DisplayName("Test Operations: Iterate - First 10 numbers in Fibonacci sequence ")
    void testOperationsIterateLimitMapToList_ReturnsExpectedValue() {
        var result = unaryOperatorStream.operationsIterateLimitMapToList();
        var expectedResult = List.of(0, 1, 1, 2, 3, 5, 8, 13, 21, 34);

        // Assertions
        Assertions.assertInstanceOf(List.class, result, "Should return a List Instance");
        Assertions.assertEquals(expectedResult.size(), result.size(), "Should return exactly 10 numbers");
        Assertions.assertEquals(expectedResult, result, "Should return correct Fibonacci sequence");
    }
}
