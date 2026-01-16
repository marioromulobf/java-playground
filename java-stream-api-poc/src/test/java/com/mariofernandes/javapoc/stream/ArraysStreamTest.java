package com.mariofernandes.javapoc.stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ArraysStreamTest {

    private ArraysStream arraysStream;

    @BeforeEach
    void setup() {
        arraysStream = new ArraysStream();
    }

    @Test
    @DisplayName("Test Operations: Sorted, Limit, and toArray")
    void testOperationsSortedLimitToArray_ReturnsExpectedValues() {
        var result = arraysStream.operationsSortedLimitToArray();
        var expectedResult = new String[]{"Ana", "Carla", "Maria"};

        // Assertions toArray
        Assertions.assertInstanceOf(String[].class, result, "Should return a String Array Instance");

        // Assertions limit ArraysStream.LIMIT_SKIP = 3
        Assertions.assertEquals(ArraysStream.LIMIT_SKIP, result.length, "Should return exactly 3 items");

        // Assertions sorted
        for (int i = 0; i < result.length - 1; i++) {
            Assertions.assertTrue(
                    result[i].compareTo(result[i + 1]) <= 0,
                    "Should be in alphabetical order"
            );
        }
        Assertions.assertArrayEquals(expectedResult, result,
                "Should return first 3 names in alphabetical order: Ana, Carla, Maria");
    }

    @Test
    @DisplayName("Test Operations: Map, Skip, and toArray")
    void testOperationsMapSkipToArray_ReturnsExpectedValues() {
        var result = arraysStream.operationsMapSkipToArray();
        var expectedResult = new String[]{"mario", "carla", "maria"};

        // Assertions toArray
        Assertions.assertInstanceOf(String[].class, result, "Should return a String Array Instance");

        // Assertions skip (ArraysStream.NAMES.length - ArraysStream.LIMIT_SKIP) = 3
        Assertions.assertEquals(ArraysStream.NAMES.length - ArraysStream.LIMIT_SKIP, result.length,
                "Should return exactly 3 items");

        // Assertions mapped to lowercase
        for (int i = 0; i < result.length; i++) {
            Assertions.assertEquals(
                    ArraysStream.NAMES[ArraysStream.LIMIT_SKIP + i].toLowerCase(),
                    result[i],
                    "Should be mapped to lowercase"
            );
        }
        Assertions.assertArrayEquals(expectedResult, result,
                "Should return last 3 names in lowercase: mario, carla, maria");
    }

    @Test
    @DisplayName("Test Operations: Distinct, Filter, and Collect Joining")
    void testOperationsDistinctFilterCollectJoining_ReturnsExpectedValues() {
        var result = arraysStream.operationsDistinctFilterCollectJoining();
        var duplicateName = "Mario";
        var expectedResult = "Mario,Maria";

        // Assertions String type
        Assertions.assertInstanceOf(String.class, result, "Should return a String Instance");

        // Assertions distinct
        Assertions.assertEquals(0, result.indexOf(duplicateName), "Should exit 'Mario'");
        Assertions.assertEquals(result.indexOf(duplicateName), result.lastIndexOf(duplicateName),
                "Should contain 'Mario' only once");

        // Assertions filter starts with "Mar"
        String[] filteredNames = result.split(",");
        for (String name : filteredNames) {
            Assertions.assertTrue(name.startsWith("Mar"), "Should start with 'Mar'");
        }

        // Assertions collectors joining
        Assertions.assertEquals(expectedResult, result, "Should return joined names: 'Mario,Maria'");
    }

    @Test
    @DisplayName("Test Aggregation: Count")
    void testAggregationCount_ReturnsExpectedValue() {
        var result = arraysStream.aggregationCount();
        var expectedResult = 6L;

        // Assertions Long type
        Assertions.assertInstanceOf(Long.class, result, "Should return a Long Instance");

        // Assertions count
        Assertions.assertEquals(expectedResult, result, "Should return the correct count of names.");
    }
}
