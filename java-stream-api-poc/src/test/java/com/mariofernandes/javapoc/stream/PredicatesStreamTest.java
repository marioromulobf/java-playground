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

    @Test
    @DisplayName("Test Operations: All Match nameStartsWithM or isAdult")
    void testOperationsAllMatchNameStartsWithMOrIsAdult_ReturnsExpectedValue() {
        var result = predicatesStream.operationsAllMatchNameStartsWithMOrIsAdult();

        // Assertions
        Assertions.assertInstanceOf(Boolean.class, result, "Should return a Boolean Instance");
        Assertions.assertFalse(result, "Should return false as not all persons match the predicate criteria");
    }

    @Test
    @DisplayName("Test Operations: Any Match nameStartsWithM and livesInPorto")
    void testOperationsAnyMatchNameStartsWithMAndLivesInPorto_ReturnsExpectedValue() {
        var result = predicatesStream.operationsAnyMatchNameStartsWithMAndLivesInPorto();

        // Assertions
        Assertions.assertInstanceOf(Boolean.class, result, "Should return a Boolean Instance");
        Assertions.assertTrue(result, "Should return true as at least one person matches the predicate criteria");
    }
}
