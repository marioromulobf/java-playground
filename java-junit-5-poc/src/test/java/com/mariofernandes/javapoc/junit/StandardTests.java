package com.mariofernandes.javapoc.junit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.logging.Logger;

public class StandardTests {

    private static final Logger LOG = Logger.getLogger(StandardTests.class.getName());

    @BeforeAll
    static void initAll() {
        LOG.info("StandardTests -> @BeforeAll");
    }

    @BeforeEach
    void init() {
        LOG.info("StandardTests -> @BeforeEach");
    }

    @Test
    void succeedingTest() {}

    @Test
    void failingTest() {
        Assertions.fail("my failing test");
    }

    @Test
    @Disabled("for demonstration purposes")
    void skippedTest() {
        LOG.info("StandardTests -> skippedTest, you don't see me");
    }

    @Test
    void abortedTest() {
        Assumptions.assumeTrue("abc".contains("Z"));
        Assertions.fail("test should have been aborted");
    }

    @AfterEach
    void tearDown() {
        LOG.info("StandardTests -> @AfterEach");
    }

    @AfterAll
    static void tearDownAll() {
        LOG.info("StandardTests -> @AfterAll");
    }
}
