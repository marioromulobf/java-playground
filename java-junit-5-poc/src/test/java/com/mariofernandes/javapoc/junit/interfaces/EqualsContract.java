package com.mariofernandes.javapoc.junit.interfaces;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public interface EqualsContract<T> extends Testable<T> {
    T createNotEqualValue();

    @Test
    default void testValueEqualsItself() {
        T value = createValue();
        Assertions.assertEquals(value, value);
    }

    @Test
    default void testValueDoesNotEqualNull() {
        T value = createValue();
        Assertions.assertNotEquals(null, value);
    }

    @Test
    default void testValueDoesNotEqualDifferentValue() {
        T value = createValue();
        T differentValue = createNotEqualValue();
        Assertions.assertNotEquals(value, differentValue);
        Assertions.assertNotEquals(differentValue, value);
    }
}
