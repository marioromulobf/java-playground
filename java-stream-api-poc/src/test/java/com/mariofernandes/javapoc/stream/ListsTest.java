package com.mariofernandes.javapoc.stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ListsTest {

    private Lists lists;

    @BeforeEach
    void setup() {
        lists = new Lists();
    }

    @Test
    @DisplayName("Test Sorted, limit by 3 and toList (Collection stream)")
    void testCollectionStreamSortedLimitToList_ReturnsExpectedValues() {
        var result = lists.collectionStreamSortedLimitToList();
        var expectedResult = List.of("Ana", "Carla", "Maria");

        // Assertions toList
        Assertions.assertInstanceOf(List.class, result, "Should return a List Instance");

        // Assertions limit 3
        Assertions.assertEquals(3, result.size(), "Should return exactly 3 items");

        // Assertions sorted
        for (int i = 0; i < result.size() - 1; i++) {
            Assertions.assertTrue(
                    result.get(i).compareTo(result.get(i + 1)) <= 0,
                    "Should be in alphabetical order"
            );
        }
        Assertions.assertEquals(expectedResult, result,
                "Should return first 3 names in alphabetical order: Ana, Carla, Maria");
    }

    @Test
    @DisplayName("Test Parallel, Sorted, Skip by 3 and toList (Collection stream)")
    void testCollectionParallelStreamSortedSkipToList_ReturnsExpectedValues() {
        var result = lists.collectionParallelStreamSortedSkipToList();
        var expectedResult = List.of("Mario", "Mario", "Pedro");

        // Assertions toList
        Assertions.assertInstanceOf(List.class, result, "Should return a List Instance");

        // Assertions skip 3 - limits the potential performance benefits of parallelism.
        Assertions.assertEquals(3, result.size(), "Should return exactly 3 items");

        // Assertions sorted (limits the potential performance benefits of parallelism) and parallel
        for (int i = 0; i < result.size() - 1; i++) {
            Assertions.assertTrue(
                    result.get(i).compareTo(result.get(i + 1)) <= 0,
                    "Should be in alphabetical order"
            );
        }
        Assertions.assertEquals(expectedResult, result,
                "Should return last 3 names in alphabetical order: Mario, Mario, Pedro");
    }
}
