package com.mariofernandes.javapoc.junit.interfaces;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.stream.Stream;

import static com.mariofernandes.javapoc.junit.StringUtils.isPalindrome;

interface DynamicTests {
    @TestFactory
    default Stream<DynamicTest> dynamicTestsForPalindromes() {
        return Stream.of("racecar", "radar", "mom", "dad")
                .map(text -> DynamicTest.dynamicTest(
                        text,
                        () -> Assertions.assertTrue(isPalindrome(text))));
    }
}
