package com.mariofernandes.javapoc.skiplists.v2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.random.RandomGenerator;

public class SkipListsFunctionalTests {

    private SkipLists skipLists;
    private static final int MAX_LEVEL = 5;

    @BeforeEach
    void setup() {
        skipLists = new SkipLists(MAX_LEVEL);
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

    @Test
    void testShouldMaintainSortedOrderInAllLevels() {
        for (int i = 0; i < 100; i++) {
            skipLists.insert(i, i);
        }

        for (int level = 0; level <= MAX_LEVEL; level++) {
            var node = skipLists.getHeader().nextInLevel(level);

            int lastKey = Integer.MIN_VALUE;

            while (node != null) {
                Assertions.assertTrue(node.key() > lastKey);
                lastKey = node.key();
                node = node.nextInLevel(level);
            }
        }
    }

    @Test
    void testShouldDeleteMiddleElement() {
        skipLists.insert(30, 1L);
        skipLists.insert(10, 2L);
        skipLists.insert(20, 3L);

        skipLists.delete(20);

        Assertions.assertTrue(skipLists.search(20).isEmpty());
        Assertions.assertTrue(skipLists.search(10).isPresent());
        Assertions.assertTrue(skipLists.search(30).isPresent());
        Assertions.assertTrue(skipLists.toString().contains("Level 0: { key=10, value=2 } -> { key=30, value=1 } -> null"));
    }

    @Test
    void testShouldMaintainGlobalOrdering() {
        for (int i = 100; i >= 0; i--) {
            skipLists.insert(i, i);
        }

        var node = skipLists.getHeader().nextInLevel(0);
        int lastKey = Integer.MIN_VALUE;

        while (node != null) {
            Assertions.assertTrue(node.key() > lastKey);
            lastKey = node.key();
            node = node.nextInLevel(0);
        }
    }

    @Test
    void testShouldNotHaveBrokenLinks() {
        for (int i = 100; i >= 0; i--) {
            skipLists.insert(i, i);
        }

        for (int level = MAX_LEVEL; level >= 0; level--) {
            var node = skipLists.getHeader();

            while (node != null) {
                var next = node.nextInLevel(level);
                if (next != null) {
                    Assertions.assertTrue(next.key() > node.key());
                }
                node = next;
            }
        }
    }

    @Test
    void testShouldHandleRandomInsertions() {
        skipLists = new SkipLists(16);
        var random = RandomGenerator.getDefault();

        for (int i = 0; i < 10_000; i++) {
            int key = random.nextInt(100_000);
            skipLists.insert(key, i);
        }

        var node = skipLists.getHeader();
        while (node != null) {
            var next = node.nextInLevel(0);
            if (next != null) {
                Assertions.assertTrue(next.key() > node.key());
            }
            node = next;
        }
    }

    @Test
    void testShouldHandleInsertDeleteCycles() {
        for (int i = 0; i < 1_000; i++) {
            skipLists.insert(i, i);
            skipLists.delete(i);
            Assertions.assertTrue(skipLists.search(i).isEmpty());
        }
    }
}
