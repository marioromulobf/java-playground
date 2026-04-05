package com.mariofernandes.javapoc.skiplists.v2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.StructuredTaskScope;

public class SkipListsConcurrencyTest {
    private SkipLists skipLists;

    @BeforeEach
    void setup() {
        skipLists = new SkipLists(16);
    }

    @Test
    void testShouldHandleConcurrentInsertions() throws InterruptedException {
        var total = 100_000;

        try (var scope = StructuredTaskScope.open()) {
            for (int i = 0; i < total; i++) {
                final int value = i;
                scope.fork(() -> skipLists.insert(value, value));
            }
            scope.join();
        }

        for (int i = 0; i < total; i++) {
            Assertions.assertTrue(skipLists.search(i).isPresent());
        }

    }

    @Test
    void testShouldHandleMixedOperations() throws InterruptedException {
        try (var scope = StructuredTaskScope.open()) {
            for (int i = 0; i < 5_000; i++) {
                final int value = i;
                scope.fork(() -> skipLists.insert(value, value));
                scope.fork(() -> skipLists.search(value));
                scope.fork(() -> skipLists.delete(value));
            }
            scope.join();
        }
        System.out.println(skipLists.toString());
    }
}
