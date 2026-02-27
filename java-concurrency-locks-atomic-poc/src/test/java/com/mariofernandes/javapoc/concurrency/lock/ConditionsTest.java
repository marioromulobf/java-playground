package com.mariofernandes.javapoc.concurrency.lock;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ConditionsTest {
    private Conditions conditions;

    @BeforeEach
    void setup() {
        conditions = new Conditions();
    }

    @Test
    @DisplayName("Test operations of Conditions: basicProduceConsumerCondition")
    void testBasicProduceConsumerCondition_ShouldReturnExpectedConsumedData() {
        try {
            var result = conditions.basicProduceConsumerCondition();
            var expectedResult = List.of(
                    "Data 0", "Data 1", "Data 2", "Data 3", "Data 4", "Data 5", "Data 6", "Data 7", "Data 8", "Data 9");

            Assertions.assertNotNull(result, "Result should not be null.");
            Assertions.assertEquals(expectedResult.size(), result.size(), "Result size should match with expected consumed data size.");
            Assertions.assertEquals(expectedResult, result, "Result should match with expected consumed data.");
        } catch (Exception e) {
            Assertions.fail("An error occurred during the testBasicProduceConsumerCondition execution: " + e.getMessage());
        }
    }
}
