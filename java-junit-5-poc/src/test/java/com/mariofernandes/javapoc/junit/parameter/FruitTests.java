package com.mariofernandes.javapoc.junit.parameter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedClass;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

@ParameterizedClass
@CsvSource({"apple, 23", "banana, 42"})
public class FruitTests {

    final String fruit;
    final int quantity;

    FruitTests(String fruit, int quantity) {
        this.fruit = fruit;
        this.quantity = quantity;
    }

    @Test
    void test() {
        Assertions.assertTrue(List.of("apple", "banana").contains(fruit));
        Assertions.assertTrue(List.of(23, 42).contains(quantity));
    }

    @Test
    void testAnother() {}
}
