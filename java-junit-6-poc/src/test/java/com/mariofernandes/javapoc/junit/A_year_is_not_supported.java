package com.mariofernandes.javapoc.junit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class A_year_is_not_supported {
    @Test
    void test_if_it_is_zero() {

    }

    @DisplayName("A negative value for year is not supported by the leap year computation.")
    @ParameterizedTest(name = "For example, year {0} is not supported.")
    @ValueSource(ints = {-1, -4})
    void test_if_it_is_negative(int year) {
        // @DisplayName annotation always take precedence over @DisplayNameGeneration annotation
    }
}
