package com.mariofernandes.javapoc.junit.injection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

@DisplayName("TestInfo Injection Tests")
public class TestInfoTests {
    @BeforeAll
    static void beforeAll(TestInfo testInfo) {
        System.out.println("Before All TestInfo Tests");
        Assertions.assertEquals("TestInfo Injection Tests", testInfo.getDisplayName());
    }

    TestInfoTests(TestInfo testInfo) {
        System.out.println("Constructing TestInfo Tests");
        String displayName = testInfo.getDisplayName();
        Assertions.assertTrue(displayName.equals("TEST 1") || displayName.equals("testTwo()"));
    }

    @BeforeEach
    void init(TestInfo testInfo) {
        System.out.println("Before Each TestInfo Tests");
        String displayName = testInfo.getDisplayName();
        Assertions.assertTrue(displayName.equals("TEST 1") || displayName.equals("testTwo()"));
    }

    @Test
    @DisplayName("TEST 1")
    @Tag("my-tag")
    void testOne(TestInfo testInfo) {
        Assertions.assertEquals("TEST 1", testInfo.getDisplayName());
        Assertions.assertTrue(testInfo.getTags().contains("my-tag"));
    }

    @Test
    void testTwo() {}
}
