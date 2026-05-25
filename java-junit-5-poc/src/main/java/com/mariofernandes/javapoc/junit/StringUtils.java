package com.mariofernandes.javapoc.junit;

public class StringUtils {
    public static boolean isPalindrome(String input) {
        var reverted = new StringBuilder(input).reverse().toString();
        return input.equals(reverted);
    }
}
