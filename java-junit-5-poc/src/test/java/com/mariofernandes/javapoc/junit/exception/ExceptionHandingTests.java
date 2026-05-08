package com.mariofernandes.javapoc.junit.exception;

import com.mariofernandes.javapoc.junit.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExceptionHandingTests {
    private final Calculator calculator = new Calculator();

    @Test
    void testFailsDueToUncaughtException() {
        // The following throws an ArithmeticException due to division by
        // zero, which causes a test failure.
        calculator.divide(1, 0);
    }

    @Test
    void testFailsDueToUncaughtAssertionError() {
        // The following incorrect assertion will cause a test failure.
        // The expected value should be 2 instead of 99
        Assertions.assertEquals(99, calculator.add(0, 2));
    }

    @Test
    void testExpectedExceptionIsThrown() {
        // The following assertion succeeds because the code under assertion
        // throws the expected IllegalArgumentException.
        // The assertion also returns the throw exception which can be used for
        // further assertions like asserting the exception message.
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> { throw new IllegalArgumentException("expected message"); });
        Assertions.assertEquals("expected message", exception.getMessage());

        // The following assertion also succeeds because the code under assertion
        // throws IllegalArgumentException which is a subclass of RuntimeException.
        Assertions.assertThrows(RuntimeException.class, () -> {
            throw new IllegalArgumentException("expected message");
        });
    }

    @Test
    void testExpectedExactlyExceptionIsThrown() {
        // The following assertion succeeds because the code under assertion throws
        // IllegalArgumentException which is exactly equal to the expected type.
        // The assertion also returns the thrown exception which can be used for
        // further assertions like asserting the exception message.
        IllegalArgumentException exception = Assertions.assertThrowsExactly(
                IllegalArgumentException.class,
                () -> { throw new IllegalArgumentException("expected message"); }
        );
        Assertions.assertEquals("expected message", exception.getMessage());

        // The following assertion fails because the assertion expects exactly
        // RuntimeException to be thrown, not subclasses of RuntimeException.
        Assertions.assertThrowsExactly(RuntimeException.class, () -> {
            throw new IllegalArgumentException("expected message");
        });
    }

    @Test
    void testExceptionIsNotThrown() {
        Assertions.assertDoesNotThrow(() -> {
            shouldNotThrowException();
        });
    }

    private void shouldNotThrowException() {
    }
}
