package com.mariofernandes.javapoc.junit.nested;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.Parameter;
import org.junit.jupiter.params.ParameterizedClass;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.Duration;
import java.util.List;

/**
 * Expected result:
 * FruitTests ✔
 * ├─ [1] fruit=apple ✔
 * │  └─ QuantityTests ✔
 * │     ├─ [1] quantity=23 ✔
 * │     │  └─ testParameters(Duration) ✔
 * │     │     ├─ [1] PT1H ✔
 * │     │     └─ [2] PT2H ✔
 * │     └─ [2] quantity=42 ✔
 * │        └─ testParameters(Duration) ✔
 * │           ├─ [1] PT1H ✔
 * │           └─ [2] PT2H ✔
 * └─ [2] fruit=banana ✔
 *    └─ QuantityTests ✔
 *       ├─ [1] quantity=23 ✔
 *       │  └─ testParameters(Duration) ✔
 *       │     ├─ [1] PT1H ✔
 *       │     └─ [2] PT2H ✔
 *       └─ [2] quantity=42 ✔
 *          └─ testParameters(Duration) ✔
 *             ├─ [1] PT1H ✔
 *             └─ [2] PT2H ✔
 */

@Execution(ExecutionMode.SAME_THREAD)
@ParameterizedClass
@ValueSource(strings = { "apple", "banana" })
public class FruitTests {
    @Parameter
    private String fruit;

    @Nested
    @ParameterizedClass
    @ValueSource(ints = { 23, 42 })
    class QuantityTests {
        @Parameter
        private int quantity;

        @ParameterizedTest
        @ValueSource(strings = { "PT1H", "PT2H" })
        void testParameters(Duration duration) {
            Assertions.assertTrue(List.of("apple", "banana").contains(fruit));
            Assertions.assertTrue(List.of(23, 42).contains(quantity));
            Assertions.assertFalse(duration.isNegative());
        }
    }
}
