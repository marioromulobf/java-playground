package com.mariofernandes.javapoc.junit;


import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.IndicativeSentencesGeneration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 *
 * Expected output:
 * A year is a leap year ✔
 * ├─ A year is a leap year, if it is divisible by 4 but not by 100 ✔
 * └─ A year is a leap year, if it is one of the following years ✔
 *    ├─ 2016 ✔
 *    ├─ 2020 ✔
 *    └─ 2048 ✔
 *
 */
@DisplayNameGenerator.IndicativeSentences.SentenceFragment("A year is a leap year")
@IndicativeSentencesGeneration
public class LeapYearTests {

    @DisplayNameGenerator.IndicativeSentences.SentenceFragment("if it is divisible by 4 but not by 100")
    @Test
    void testDivisibleBy4ButNot100() {

    }

    @DisplayNameGenerator.IndicativeSentences.SentenceFragment("if it is one of the following years")
    @ParameterizedTest(name = "{0}")
    @ValueSource(ints = {2016, 2020, 2048})
    void testValidLeapYear(int year) {

    }

}
