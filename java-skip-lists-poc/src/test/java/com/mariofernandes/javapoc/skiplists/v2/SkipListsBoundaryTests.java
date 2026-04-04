package com.mariofernandes.javapoc.skiplists.v2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SkipListsBoundaryTests {

    private SkipLists skipLists;

    @BeforeEach
    void setup() {
        skipLists = new SkipLists(7);
    }

    @Test
    void testShouldNotOverrideExistingKey() {
        skipLists.insert(3, 333L);
        skipLists.insert(3, 666L);

        var result = skipLists.search(3);

        Assertions.assertEquals(333L, result.getAsLong());
        Assertions.assertTrue(skipLists.toString().contains("Level 0: { key=3, value=333 } -> null"));
    }

    @Test
    void testShouldHandleDeleteNonExistent() {
        skipLists.delete(666);
    }

    @Test
    void testShouldHandleExtremeKeys() {
        skipLists.insert(Integer.MIN_VALUE, Long.MAX_VALUE);
        skipLists.insert(Integer.MAX_VALUE, Long.MIN_VALUE);

        var resultMin = skipLists.search(Integer.MIN_VALUE);
        var resultMax = skipLists.search(Integer.MAX_VALUE);

        Assertions.assertTrue(resultMin.isPresent());
        Assertions.assertEquals(Long.MAX_VALUE, resultMin.getAsLong());
        Assertions.assertTrue(resultMax.isPresent());
        Assertions.assertEquals(Long.MIN_VALUE, resultMax.getAsLong());
        Assertions.assertTrue(skipLists.toString().contains("Level 0: { key=-2147483648, value=9223372036854775807 } -> { key=2147483647, value=-9223372036854775808 } -> null"));
    }
}
