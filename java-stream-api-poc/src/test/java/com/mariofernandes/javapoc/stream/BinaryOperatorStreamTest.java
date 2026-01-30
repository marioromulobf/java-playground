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
    @DisplayName("Test Operations: BinaryOperator in reduce by String::length")
    void testOperationsMapReduceWithBinaryOperatorString_ReturnsExpectedValue() {
        var result = binaryOperatorStream.operationsMapReduceWithBinaryOperatorString();
        var expectedResult = "Ana";

        // Assertions
        Assertions.assertTrue(result.isPresent(), "Should return a value");
        Assertions.assertEquals(expectedResult, result.get(),
                "Should return the name with the shortest length: Ana");
    }

    @Test
    @DisplayName("Test Operations: BinaryOperator in reduce by Integer::sum")
    void testOperationsMapReduceWithBinaryOperatorInteger_ReturnsExpectedValue() {
        var result = binaryOperatorStream.operationsMapReduceWithBinaryOperatorInteger();
        var expectedResult = 245;

        // Assertions
        Assertions.assertInstanceOf(Integer.class, result, "Should return a Integer Instance");
        Assertions.assertEquals(expectedResult, result, "Should return the correct sum of age");
    }
}
