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
 * ├─ A year is a leap year -> if it is divisible by 4 but not by 100 ✔
 * └─ A year is a leap year -> if it is one of the following years ✔
 *    ├─ Year 2016 is a leap year. ✔
 *    ├─ Year 2020 is a leap year. ✔
 *    └─ Year 2048 is a leap year. ✔
 *
 */

// can customize separator and generator.
@IndicativeSentencesGeneration(separator = " -> ", generator = DisplayNameGenerator.ReplaceUnderscores.class)
public class A_year_is_a_leap_year {

    @Test
    void if_it_is_divisible_by_4_but_not_by_100() {}

    @ParameterizedTest(name = "Year {0} is a leap year.")
    @ValueSource(ints = {2016, 2020, 2048})
    void if_it_is_one_of_the_following_years(int year) {}
}
