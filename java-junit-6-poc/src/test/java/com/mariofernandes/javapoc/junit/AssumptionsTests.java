package com.mariofernandes.javapoc.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class AssumptionsTests {

    private static Calculator calculator;

    @BeforeAll
    static void setup() {
        calculator = new Calculator();
    }

    @Test
    void testOnlyCiServer() {
        Assumptions.assumeTrue("CI".equals(System.getenv("ENV")));
        // remainder of test, it'll always be skipped while assumption is false.
        Assertions.assertEquals(6, calculator.add(3, 3));
    }

    @Test
    void testOnlyOnDeveloperWorkstation() {
        Assumptions.assumeTrue("DEV".equals(System.getenv("ENV")),
                () -> "Aborting test: not on developer workstation.");
        // remainder of test
        Assertions.assertEquals(3, calculator.subtract(5, 2));
    }

    @Test
    void testInAllEnvironments() {
        Assumptions.assumingThat("CI".equals(System.getenv("ENV")),
                () -> {
                    // perform these assertions only on the CI server
                    Assertions.assertEquals(2, calculator.divide(4, 2));
        });
        // perform these assertions in all environments
        Assertions.assertEquals(42, calculator.multiply(6, 7));
    }
}
