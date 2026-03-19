package com.mariofernandes.javapoc.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.concurrent.CountDownLatch;

public class AssertionsTests {
    private static Calculator calculator;

    private static Person person;

    @BeforeAll
    static void setup() {
        calculator = new Calculator();
        person = new Person("Mario", "Romulo");
    }

    @Test
    void testStandardAssertion() {
        Assertions.assertEquals(2, calculator.add(1, 1));
        Assertions.assertEquals(4, calculator.multiply(2, 2),
                "The last parameter is now the optional failure message");

        Assertions.assertTrue('a' < 'b', () -> generateFailureMessage('a', 'b'));
    }

    @Test
    void testGroupedAssertions() {
        Assertions.assertAll("person",
                () -> Assertions.assertEquals("Mario", person.getFirstName()),
                () -> Assertions.assertEquals("Romulo", person.getLastName()));
    }

    @Test
    void testDependentAssertions() {
        Assertions.assertAll("properties",
                // Within a code block, if an assertion fails the subsequent code
                // in the same block will be skipped.
                () -> {
                    String firstName = person.getFirstName();
                    Assertions.assertNotNull(firstName);
                    // Executed only if the previous assertion is valid.
                    Assertions.assertAll("first name",
                        () -> Assertions.assertTrue(firstName.startsWith("M")),
                        () -> Assertions.assertTrue(firstName.endsWith("o"))
                    );
                },
                () -> {
                    // grouped assertion, so processed independently of results
                    // of first name assertions
                    String lastName = person.getLastName();
                    Assertions.assertNotNull(lastName);
                    // Executed only if the previous assertion is valid.
                    Assertions.assertAll("last name",
                        () -> Assertions.assertTrue(lastName.startsWith("R")),
                        () -> Assertions.assertTrue(lastName.endsWith("o"))
                    );
                });
    }

    @Test
    void testExceptionTesting() {
        Exception exception = Assertions.assertThrows(ArithmeticException.class,
                () -> calculator.divide(1, 0));

        Assertions.assertEquals("/ by zero", exception.getMessage());
    }

    @Test
    void testTimeoutNotExceeded() {
        // The following assertion succeeds.
        Assertions.assertTimeout(Duration.ofSeconds(3), () -> {
            // code that should execute within 3 seconds
            Thread.sleep(1000);
        });
    }

    @Test
    void testTimeoutNotExceededWithResult() {
        String result = Assertions.assertTimeout(Duration.ofSeconds(3), () -> {
           return "this is my result";
        });

        Assertions.assertEquals("this is my result", result);
    }

    @Test
    void testTimeoutNotExceededWithMethod() {
        String result = Assertions.assertTimeout(Duration.ofSeconds(5), AssertionsTests::myMethod);

        Assertions.assertEquals("It's nice to see you", result);
    }

    @Test
    void testTimeoutExceeded() {
        // The following assertion fails with an error message similar
        // execution exceeded timeout of 10 ms by 90 ms
        Assertions.assertTimeout(Duration.ofMillis(10), () -> Thread.sleep(100));
    }

    @Test
    void testTimeoutExceededWithPreemptiveTermination() {
        // The following assertion fails with an error message similar
        // execution timed out after 10 ms
        Assertions.assertTimeoutPreemptively(Duration.ofMillis(10), () -> {
           new CountDownLatch(1).await();
        });
    }

    private static String myMethod() {
        return "It's nice to see you";
    }

    private static String generateFailureMessage(char a, char b) {
        return "Assertion messages can be lazily evaluated -- "
                + "to avoid constructing complex messages unnecessarily." + (a < b);
    }
}
