package com.mariofernandes.javapoc.junit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class StandardTestsTest {
    @BeforeAll
    static void initAll() {
        System.out.println("Ran before all tests");
    }

    @BeforeEach
    void init() {
        System.out.println("Ran before each test");
    }

    @Test
    void succeedingTest() {
        System.out.println("My succeeding test");
        assertTrue(true);
    }

    @Test
    void failingTest() {
        System.out.println("My failing test");
        fail("A failing test");
    }

    @Test
    @Disabled("Only for demonstration purposes")
    void skippedTest() {
        System.out.println("My skipped test");
    }

    @Test
    void abortedTest() {
        System.out.println("My aborted test");
        assumeTrue("abc".contains("Z"));
        fail("test should have been aborted");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Ran after each test");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("Ran after all tests");
    }
}
