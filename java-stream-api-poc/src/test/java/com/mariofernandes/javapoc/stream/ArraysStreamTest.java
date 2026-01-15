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
        Assertions.assertEquals(expectedResult, result,
                "Should return first 3 names in alphabetical order: Ana, Carla, Maria");
    }

}
