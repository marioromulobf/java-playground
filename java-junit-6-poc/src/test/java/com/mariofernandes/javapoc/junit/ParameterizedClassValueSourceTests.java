package com.mariofernandes.javapoc.junit;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.Parameter;
import org.junit.jupiter.params.ParameterizedClass;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@ParameterizedClass
@ValueSource(strings = {"racecar", "radar", "able was I ere I saw elba"})

public class ParameterizedClassValueSourceTests {

    @Parameter
    String candidate;

    @Test
    void testPalindrome() {
        Assertions.assertTrue(StringUtils.isPalindrome(candidate));
    }

    @Test
    void testReversePalindrome() {
        String reverseCandidate = new StringBuilder(candidate).reverse().toString();
        Assertions.assertTrue(StringUtils.isPalindrome(reverseCandidate));
    }

    @ParameterizedTest
    @ValueSource(strings = {"reviver", "rotator", "step on no pets"})
    void testMethodPalindromes(String myCandidate) {
        // when the test is not related to class parameters, the test will run more times
        Assertions.assertTrue(StringUtils.isPalindrome(myCandidate));
    }
}
