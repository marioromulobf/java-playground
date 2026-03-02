package com.mariofernandes.javapoc.annotation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class PersonValidatorTest {
    @Test
    @DisplayName("Test Operations of Annotations Validator: ShouldValidateSuccessfully")
    void testPersonValidator_ShouldValidateSuccessfully() {
        Person person = new Person("Mario", "Brazil", 30, 666);
        try {
            Validator.validate(person);
            Assertions.assertNotNull(person);
        } catch (Exception e) {
            Assertions.fail("The testPersonValidator_ShouldValidateSuccessfully was encountered an exception: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Test Operations of Annotations Validator: ShouldThrowsValidationExceptionWith4Violations")
    void testPersonValidator_ShouldThrowsValidationExceptionWith4Violations() {
        var expectedMessage = "Validation failed: [name must not be blank, Country is required, age value is out of range (expected: 0..99, got: -1), luckyNumber must not be blank]";
        var expectedViolations = List.of(
                "name must not be blank",
                "Country is required",
                "age value is out of range (expected: 0..99, got: -1)",
                "luckyNumber must not be blank"
        );
        Person person = new Person(null, null, -1, null);
        ValidationException exception = Assertions.assertThrowsExactly(ValidationException.class, () -> Validator.validate(person));

        Assertions.assertEquals(expectedMessage, exception.getMessage(), "Exception message should be equal to expected value");
        Assertions.assertEquals(expectedViolations.size(), exception.getViolations().size(), "Number of violations should be 4");
        Assertions.assertEquals(expectedViolations, exception.getViolations(), "Violations should be equal to expected values");
    }
}
