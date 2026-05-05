package com.mariofernandes.javapoc.junit.assumption;

import com.mariofernandes.javapoc.junit.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

public class AssumptionsTests {
    private final Calculator calculator = new Calculator();

    @Test
    void testOnlyOnCiServer() {
        // System.getenv("ENV") == null
        Assumptions.assumeTrue("CI".equals(System.getenv("ENV")));
        // remainder of test
    }

    @Test
    void testOnlyOnDeveloperWorkstation() {
        // System.getenv("ENV") == null
        Assumptions.assumeTrue("DEV".equals(System.getenv("ENV")),
                () -> "Aborting test: not on developer workstation");
        // remainder of test
    }

    @Test
    void testInAllEnvironments() {
        // System.getenv("ENV") == null
        Assumptions.assumingThat("CI".equals(System.getenv("ENV")),
                () -> {
                    // perform these assertions only on the CI server
                    Assertions.assertEquals(2, calculator.divide(4, 2));
                });

        // perform these assertions in all environments
        Assertions.assertEquals(42, calculator.multiply(6, 7));
    }
}
