package com.mariofernandes.javapoc.junit.parameter;

import com.mariofernandes.javapoc.junit.StringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.Parameter;
import org.junit.jupiter.params.ParameterizedClass;
import org.junit.jupiter.params.provider.ValueSource;

@ParameterizedClass
@ValueSource(strings = {"racecar","radar", "able was I ere I saw elba"})
public class PalindromeTests {
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
}
