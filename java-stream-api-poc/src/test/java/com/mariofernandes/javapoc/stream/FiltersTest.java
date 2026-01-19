package com.mariofernandes.javapoc.stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class FiltersTest {
    private Filters filters;

    @BeforeEach
    void setup() {
        filters = new Filters();
    }

    @Test
    @DisplayName("Test operations: Filter Chain")
    void testOperationsFilterChain_ReturnsExpectedValues() {
        var result = filters.operationsFilterChain();
        var expectedResult = List.of(
                new Person("Mario", 40, "Lisbon"),
                new Person("Mario", 40, "Porto"),
                new Person("Maria", 35, "Porto")
        );

        // Assertions
        Assertions.assertInstanceOf(List.class, result, "Should return a List Instance");
        Assertions.assertEquals(expectedResult.size(), result.size(), "Should return exactly 3 Person objects");
        Assertions.assertEquals(expectedResult, result, "Should return Person objects matching the filter criteria");
    }

    @Test
    @DisplayName("Test operations: Filter Complex")
    void testOperationsFilterComplex_ReturnsExpectedValues() {
        var result = filters.operationsFilterComplex();
        var expectedResult = List.of(
                new Person("Mario", 40, "Lisbon"),
                new Person("Ana", 20, "Porto"),
                new Person("Pedro", 9, "Coimbra"),
                new Person("Mario", 40, "Porto"),
                new Person("Maria", 35, "Porto")
        );

        // Assertions
        Assertions.assertInstanceOf(List.class, result, "Should return a List Instance");
        Assertions.assertEquals(expectedResult.size(), result.size(), "Should return exactly 5 Person objects");
        Assertions.assertEquals(expectedResult, result, "Should return Person objects matching the complex filter criteria");
    }

    @Test
    @DisplayName("Test operations: Filter Find First")
    void testOperationsFilterFindFirst_ReturnsExpectedValue() {
        var result = filters.operationsFilterFindFirst();
        var expectedResult = new Person("Ana", 20, "Porto");

        // Assertions
        Assertions.assertTrue(result.isPresent(), "Should return a Person object");
        Assertions.assertEquals(expectedResult, result.get(), "Should return the first Person object matching the filter criteria");
    }

    @Test
    @DisplayName("Test operations: Filter Find Any")
    void testOperationsFilterFindAny_ReturnsExpectedValue() {
        var result = filters.operationsFilterFindAny();
        var expectedResult = new Person("Ana", 20, "Porto");

        // Assertions
        Assertions.assertTrue(result.isPresent(), "Should return a Person object");
        Assertions.assertEquals(expectedResult, result.get(), "Should return any Person object matching the filter");
    }
}
