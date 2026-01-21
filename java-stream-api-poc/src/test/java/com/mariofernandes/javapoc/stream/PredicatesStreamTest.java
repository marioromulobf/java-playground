package com.mariofernandes.javapoc.stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class PredicatesStreamTest {
    private PredicatesStream predicatesStream;

    @BeforeEach
    void setup() {
        predicatesStream = new PredicatesStream();
    }

    @Test
    @DisplayName("Test Operations: Filter with Predicates isAdult negate and livesInPorto negate")
    void testOperationsFilterPredicatesIsNotAdultAndNotLivesInPorto_ReturnsExpectedValue() {
        var result = predicatesStream.operationsFilterPredicatesIsNotAdultAndNotLivesInPorto();
        var expectedResult = List.of(new Person("Pedro", 9, "Coimbra"));

        // Assertions
        Assertions.assertInstanceOf(List.class, result, "Should return a List Instance");
        Assertions.assertEquals(expectedResult.size(), result.size(), "Should return exactly 1 Person object");
        Assertions.assertEquals(expectedResult, result, "Should return Person objects matching the predicate criteria");
    }
}
