package com.mariofernandes.javapoc.stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SuppliersStreamTest {
    private SuppliersStream suppliersStream;

    @BeforeEach
    void setup() {
        suppliersStream = new SuppliersStream();
    }

    @Test
    @DisplayName("Test Operations: Generate 3 People")
    void testOperationsGenerate3People_ReturnsExpectedValue() {
        var result = suppliersStream.operationsGenerate3People();
        var expectedNames = PersonFactorySupplier.NAMES;
        var expectedCities = PersonFactorySupplier.CITIES;

        // Assertions
        Assertions.assertInstanceOf(List.class, result, "Should return a List Instance");
        Assertions.assertEquals(3, result.size(), "Should return exactly 3 Person objects");
        result.forEach(person -> {
            Assertions.assertInstanceOf(Person.class, person, "Each item in the list should be a Person object");
            Assertions.assertTrue(List.of(expectedNames).contains(person.name()),
                    "Person name should be one of the expected names");
            Assertions.assertTrue(List.of(expectedCities).contains(person.city()),
                    "Person city should be one of the expected cities");
            Assertions.assertTrue(111 > person.age() && 0 < person.age(),
                    "Person age should be less than or equal to 111 and greater than or equal to 0");
        });
    }

    @Test
    @DisplayName("Test Operations: Supplier and BiConsumer in collect")
    void testOperationsParallelCollect_ReturnsExpectedValues() {
        var result = suppliersStream.operationsParallelCollect();
        var expectedResult = List.of(
                new Person("Mario", 40, "Lisbon"),
                new Person("Ana", 20, "Porto"),
                new Person("Maria", 35, "Porto")
        );

        // Assertions
        Assertions.assertInstanceOf(List.class, result, "Should return a List Instance");
        Assertions.assertEquals(expectedResult.size(), result.size(), "Should return exactly 3 Person objects");
        Assertions.assertEquals(expectedResult, result, "Should return Person objects after matching the accumulator and combiner criteria");
    }
}
