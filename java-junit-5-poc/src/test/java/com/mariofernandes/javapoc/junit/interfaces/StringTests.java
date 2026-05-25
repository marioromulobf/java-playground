package com.mariofernandes.javapoc.junit.interfaces;

public class StringTests implements ComparableContract<String>, EqualsContract<String> {
    @Override
    public String createValue() {
        return "banana";
    }

    @Override
    public String createSmallerValue() {
        return "apple";
    }

    @Override
    public String createNotEqualValue() {
        return "cherry";
    }
}
