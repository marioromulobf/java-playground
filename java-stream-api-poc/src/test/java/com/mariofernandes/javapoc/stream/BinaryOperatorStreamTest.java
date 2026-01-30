package com.mariofernandes.javapoc.stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BinaryOperatorStreamTest {
    private BinaryOperatorStream binaryOperatorStream;

    @BeforeEach
    void setup() {
        this.binaryOperatorStream = new BinaryOperatorStream();
    }

    @Test
    @DisplayName("Test Operations: reduce")
    void testOperationsReduce_ReturnsExpectedValue() {
        var result = binaryOperatorStream.operationsReduce();
        var expectedResult = "Ana";

        // Assertions Optional
        Assertions.assertTrue(result.isPresent(), "Should return a value");

        // Assertions min by length
        Assertions.assertEquals(expectedResult, result.get(),
                "Should return the name with the shortest length: Ana");
    }
}
