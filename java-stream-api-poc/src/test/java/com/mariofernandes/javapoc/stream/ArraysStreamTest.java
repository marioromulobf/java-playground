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
    void testOperationSortedLimitToArray_ReturnsExpectedValues() {
        var result = arraysStream.operationSortedLimitToArray();
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
    void testOperationMapSkipToArray_ReturnsExpectedValues() {
        var result = arraysStream.operationMapSkipToArray();
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
}
