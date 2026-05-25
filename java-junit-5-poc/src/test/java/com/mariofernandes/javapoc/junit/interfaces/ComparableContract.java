package com.mariofernandes.javapoc.junit.interfaces;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public interface ComparableContract<T extends Comparable<T>> extends Testable<T> {
    T createSmallerValue();

    @Test
    default void testReturnsZeroWhenComparedToItself() {
        T value = createValue();
        Assertions.assertEquals(0, value.compareTo(value));
    }

    @Test
    default void testReturnsPositiveNumberWhenComparedToSmallerValue() {
        T value = createValue();
        T smallerValue = createSmallerValue();
        Assertions.assertTrue(value.compareTo(smallerValue) > 0);
    }

    @Test
    default void testReturnsNegativeNumberWhenComparedToLargerValue() {
        T value = createValue();
        T smallerValue = createSmallerValue();
        Assertions.assertTrue(smallerValue.compareTo(value) < 0);
    }
}
