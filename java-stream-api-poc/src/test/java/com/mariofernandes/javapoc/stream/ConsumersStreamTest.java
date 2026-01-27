package com.mariofernandes.javapoc.stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ConsumersStreamTest {
    private ConsumersStream consumersStream;

    @BeforeEach
    void setup() {
        this.consumersStream = new ConsumersStream();
    }

    @Test
    @DisplayName("Test Operations: MapMult")
    void testOperationsMapMult_ReturnsExpectedValue() {
        var result = consumersStream.operationsMapMult();
        var expectedResult = "Mario, Ana, Pedro, Mario, Carla, Maria";

        // Assertions
        Assertions.assertInstanceOf(String.class, result, "Should return a String Instance");
        Assertions.assertEquals(expectedResult, result, "Should return the correct names");
    }
}
