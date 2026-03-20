package com.mariofernandes.javapoc.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

@DisplayName("Dependency Injection Tests")
public class DependencyInjectionTests {
    @BeforeAll
    static void beforeAll(TestInfo testInfo) {
        Assertions.assertEquals("Dependency Injection Tests", testInfo.getDisplayName());
    }

    DependencyInjectionTests(TestInfo testInfo) {
        // Constructor is executed first than @BeforeEach and after than @BeforeAll
        String displayName = testInfo.getDisplayName();
        Assertions.assertTrue(displayName.equals("First Test") || displayName.equals("test2()"));
    }

    @BeforeEach
    void beforeEach(TestInfo testInfo) {
        String displayName = testInfo.getDisplayName();
        Assertions.assertTrue(displayName.equals("First Test") || displayName.equals("test2()"));
    }

    @Test
    @DisplayName("First Test")
    @Tag("my-tag")
    void test1(TestInfo testInfo) {
        Assertions.assertEquals("First Test", testInfo.getDisplayName());
        Assertions.assertTrue(testInfo.getTags().contains("my-tag"));
    }

    @Test
    void test2() {

    }
}
