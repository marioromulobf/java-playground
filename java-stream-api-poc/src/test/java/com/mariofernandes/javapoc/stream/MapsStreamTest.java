package com.mariofernandes.javapoc.stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MapsStreamTest {
    private MapsStream mapsStream;

    @BeforeEach
    void setup() {
        mapsStream = new MapsStream();
    }

    @Test
    @DisplayName("Test Operations: Map Chain")
    void testOperationsMapChain_ReturnsExpectedValues() {
        var result = mapsStream.operationsMapChain();
        var expectedResult = List.of(
                "[ Name: MARIO ]",
                "[ Name: ANA ]",
                "[ Name: PEDRO ]",
                "[ Name: MARIO ]",
                "[ Name: CARLA ]",
                "[ Name: MARIA ]"
        );

        // Assertions
        Assertions.assertInstanceOf(List.class, result, "Should return a List Instance");
        Assertions.assertEquals(expectedResult.size(), result.size(), "Should return exactly 6 names");
        Assertions.assertEquals(expectedResult, result, "Should return names formatted and in uppercase");
    }

    @Test
    @DisplayName("Test Operations: Map to Object Person")
    void testOperationsMapToObjectPerson_ReturnsExpectedValues() {
        var result = mapsStream.operationsMapToObjectPerson();
        var expectedResult = List.of(
                new Person("Mario", 40),
                new Person("Ana", 20),
                new Person("Pedro", 9),
                new Person("Mario", 40),
                new Person("Carla", 101),
                new Person("Maria", 35)
        );

        // Assertions
        Assertions.assertInstanceOf(List.class, result, "Should return a List Instance");
        Assertions.assertEquals(expectedResult.size(), result.size(), "Should return exactly 6 Person objects");
        Assertions.assertEquals(expectedResult, result, "Should return Person objects with correct name and age");
    }

    @Test
    @DisplayName("Test Operations: Map to Double Average")
    void testOperationsMapToDoubleAverage_ReturnsExpectedValue() {
        var result = mapsStream.operationsMapToDoubleAverage();
        var expectedResult = 40.833333333333336;

        // Assertions
        Assertions.assertInstanceOf(Double.class, result, "Should return a Double Instance");
        Assertions.assertEquals(expectedResult, result, "Should return the correct average age");
    }

    @Test
    @DisplayName("Test Operations: Map to Int Sum")
    void testOperationsMapToIntSum_ReturnsExpectedValue() {
        var result = mapsStream.operationsMapToIntSum();
        var expectedResult = 28;

        // Assertions
        Assertions.assertInstanceOf(Integer.class, result, "Should return an Integer Instance");
        Assertions.assertEquals(expectedResult, result, "Should return the correct sum of name lengths");
    }

    @Test
    @DisplayName("Test Operations: Map to Long Sum")
    void testOperationsMapToLongSum_ReturnsExpectedValue() {
        var result = mapsStream.operationsMapToLongSum();
        var expectedResult = 245L;

        // Assertions
        Assertions.assertInstanceOf(Long.class, result, "Should return a Long Instance");
        Assertions.assertEquals(expectedResult, result, "Should return the correct sum of ages");
    }

    @Test
    @DisplayName("Test Operations: Map Multi")
    void testOperationsMapMulti_ReturnsExpectedValues() {
        var result = mapsStream.operationsMapMulti();
        var expectedResult = List.of(
                "Age: 40",
                "Double Age: 80.0",
                "Age: 20",
                "Double Age: 40.0",
                "Age: 9",
                "Double Age: 18.0",
                "Age: 40",
                "Double Age: 80.0",
                "Age: 101",
                "Double Age: 202.0",
                "Age: 35",
                "Double Age: 70.0"
        );

        // Assertions
        Assertions.assertInstanceOf(List.class, result, "Should return a List Instance");
        Assertions.assertEquals(expectedResult.size(), result.size(), "Should return exactly 12 items");
        Assertions.assertEquals(expectedResult, result, "Should return correct age and double age strings");
    }

    @Test
    @DisplayName("Test Operations: Map Multi to Int")
    void testOperationsMapMultiToInt_ReturnsExpectedValues() {
        var result = mapsStream.operationsMapMultiToInt();
        var expectedResult = List.of(40, 400, 20, 200, 9, 90, 40, 400, 101, 1010, 35, 350);

        // Assertions
        Assertions.assertInstanceOf(List.class, result, "Should return a List Instance");
        Assertions.assertEquals(expectedResult.size(), result.size(), "Should return exactly 12 items");
        Assertions.assertEquals(expectedResult, result, "Should return correct ages and ages multiplied by 10");
    }

    @Test
    @DisplayName("Test Operations: Flat Map")
    void testOperationsFlatMap_ReturnsExpectedValues() {
        var result = mapsStream.operationsFlatMap();
        var expectedResult = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);

        // Assertions
        Assertions.assertInstanceOf(List.class, result, "Should return a List Instance");
        Assertions.assertEquals(expectedResult.size(), result.size(), "Should return exactly 9 items");
        Assertions.assertEquals(expectedResult, result, "Should return flattened list of integers from nested lists");
    }
}
