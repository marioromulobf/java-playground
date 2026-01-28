package com.mariofernandes.javapoc.stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ConsumersStreamTest {
    private ConsumersStream consumersStream;

    @BeforeEach
    void setup() {
        this.consumersStream = new ConsumersStream();
    }

    @Test
    @DisplayName("Test Operations: MapMult")
    void testOperationsMapMultPersonToName_ReturnsExpectedValue() {
        var result = consumersStream.operationsMapMultPersonToName();
        var expectedResult = "Mario, Ana, Pedro, Mario, Carla, Maria";

        // Assertions
        Assertions.assertInstanceOf(String.class, result, "Should return a String Instance");
        Assertions.assertEquals(expectedResult, result, "Should return the correct names");
    }

    @Test
    @DisplayName("Test Operations: MapMultiToDouble")
    void testOperationsMapMultiToDoublePersonToPercentOfAverageAge_ReturnsExpectedValues() {
        var result = consumersStream.operationsMapMultiToDoublePersonToPercentOfAverageAge();
        var expectedResult = List.of(97.96, 48.98, 22.04, 97.96, 247.35, 85.71);

        // Assertions
        Assertions.assertInstanceOf(List.class, result, "Should return a List Instance");
        Assertions.assertEquals(expectedResult.size(), result.size(), "Should return exactly 6 averages");
        Assertions.assertEquals(expectedResult, result, "Should return correct averages formated with 2 decimals");
    }

    @Test
    @DisplayName("Test Operations: MapMultiToLong")
    void testOperationsMapMultiToLongPersonToPercentOfAverageAgeAsLong_ReturnsExpectedValues() {
        var result = consumersStream.operationsMapMultiToLongPersonToPercentOfAverageAgeAsLong();
        var expectedResult = List.of(98L, 49L, 22L, 98L, 247L, 86L);

        // Assertions
        Assertions.assertInstanceOf(List.class, result, "Should return a List Instance");
        Assertions.assertEquals(expectedResult.size(), result.size(), "Should return exactly 6 averages");
        Assertions.assertEquals(expectedResult, result, "Should return correct averages values");
    }

    @Test
    @DisplayName("Test Operations: MapMultiToInt")
    void testOperationsMapMultiToIntPersonToAverageAgeDifference_ReturnsExpectedValues() {
        var result = consumersStream.operationsMapMultiToIntPersonToAverageAgeDifference();
        var expectedResult = List.of(-1, -21, -32, -1, 60, -6);

        // Assertions
        Assertions.assertInstanceOf(List.class, result, "Should return a List Instance");
        Assertions.assertEquals(expectedResult.size(), result.size(), "Should return exactly 6 differences");
        Assertions.assertEquals(expectedResult, result, "Should return correct difference values");
    }
}
