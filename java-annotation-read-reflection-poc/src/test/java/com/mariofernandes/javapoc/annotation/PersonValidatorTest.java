package com.mariofernandes.javapoc.annotation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}
