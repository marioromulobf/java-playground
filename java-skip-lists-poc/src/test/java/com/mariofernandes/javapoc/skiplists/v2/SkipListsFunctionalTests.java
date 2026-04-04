package com.mariofernandes.javapoc.skiplists.v2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SkipListsFunctionalTests {

    private SkipLists skipLists;

    @BeforeEach
    void setup() {
        skipLists = new SkipLists(5);
    }

    @Test
    void testShouldInsertAndSearch() {
        skipLists.insert(666, 13L);

        var result = skipLists.search(666);

        Assertions.assertTrue(result.isPresent());
        Assertions.assertEquals(13L, result.getAsLong());
        Assertions.assertTrue(skipLists.toString().contains("Level 0: { key=666, value=13 } -> null"));
    }

    @Test
    void testShouldReturnEmptyWhenNotFound() {
        var result = skipLists.search(1);

        Assertions.assertTrue(result.isEmpty());
        Assertions.assertTrue(skipLists.toString().contains("Level 0: null"));

        skipLists.insert(1, 42L);

        result = skipLists.search(2);

        Assertions.assertTrue(result.isEmpty());
        Assertions.assertTrue(skipLists.toString().contains("Level 0: { key=1, value=42 } -> null"));
    }

    @Test
    void testShouldInsertSearchDeleteAndReturnEmptyAfterDelete() {
        skipLists.insert(42, 666L);

        var result = skipLists.search(42);

        Assertions.assertTrue(result.isPresent());
        Assertions.assertEquals(666L, result.getAsLong());
        Assertions.assertTrue(skipLists.toString().contains("Level 0: { key=42, value=666 } -> null"));

        skipLists.delete(42);

        result = skipLists.search(42);

        Assertions.assertTrue(result.isEmpty());
        Assertions.assertTrue(skipLists.toString().contains("Level 0: null"));
    }

    @Test
    void testShouldRespectKeyOrder() {
        skipLists.insert(30, 1L);
        skipLists.insert(10, 2L);
        skipLists.insert(20, 3L);

        Assertions.assertEquals(2L, skipLists.search(10).orElseThrow());
        Assertions.assertEquals(3L, skipLists.search(20).orElseThrow());
        Assertions.assertEquals(1L, skipLists.search(30).orElseThrow());
        Assertions.assertTrue(skipLists.toString().contains("Level 0: { key=10, value=2 } -> { key=20, value=3 } -> { key=30, value=1 } -> null"));
    }
}
