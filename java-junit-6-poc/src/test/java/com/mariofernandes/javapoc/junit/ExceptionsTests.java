package com.mariofernandes.javapoc.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ExceptionsTests {

    private static Calculator calculator;

    @BeforeAll
    static void setup() {
        calculator = new Calculator();
    }

    @Test
    void testFailsDueToUncaughtException() {
        // the following throws an ArithmeticException due to division by zero,
        // which causes a test failure.
        calculator.divide(1, 0);
    }

    @Test
    void testFailsDueToUncaughtAssertionError() {
        // the following incorrect assertion will cause a test failure.
        // the expected value should be 12 instead of 666.
        Assertions.assertEquals(666, calculator.add(6, 6));
    }

    @Test
    void testExpectedExceptionIsThrown() {
        // the following assertion succed because the code under assertion throws the
        // expected IllegalArgumentException.
        // the assertion also returns the thrown exception which can be used for further
        // assertions like asserting the exception message.
        IllegalArgumentException exception = Assertions.assertThrows(
                IllegalArgumentException.class, () -> {
                    throw new IllegalArgumentException("my expected message");
                }
        );
        Assertions.assertEquals("my expected message", exception.getMessage());

        // the following assertion also succeeds because the code under assertion
        // throws IllegalArgumentException which is a subclass of RuntimeException
        Assertions.assertThrows(RuntimeException.class, () -> {
           throw new IllegalArgumentException("my expected message");
        });
    }

    @Test
    void testExpectedExceptionMustBeThrownExactly() {
        IllegalArgumentException exception = Assertions.assertThrowsExactly(
                IllegalArgumentException.class, () -> {
                    throw new IllegalArgumentException("my expected message");
                }
        );
        Assertions.assertEquals("my expected message", exception.getMessage());

        Assertions.assertThrowsExactly(RuntimeException.class, () -> {
            throw new IllegalArgumentException("my expected message");
        });
    }

    @Test
    void testExceptionIsNotThrown() {
        Assertions.assertDoesNotThrow(() -> {
            // should not throw exception
            calculator.add(1, 2);
        });
    }
}
