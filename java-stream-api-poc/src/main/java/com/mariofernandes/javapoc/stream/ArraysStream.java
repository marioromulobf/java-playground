package com.mariofernandes.javapoc.stream;

import java.util.Arrays;

public class ArraysStream {
    public static final String[] NAMES = {"Mario", "Ana", "Pedro", "Mario", "Carla", "Maria"};
    public static final int LIMIT_SKIP = 3;

    public ArraysStream() {}

    public String[] operationSortedLimitToArray() {
        return Arrays.stream(NAMES)
                .sorted()
                .limit(LIMIT_SKIP)
                .toArray(String[]::new);
    }

    public String[] operationMapSkipToArray() {
        return Arrays.stream(NAMES)
                .map(String::toLowerCase)
                .skip(LIMIT_SKIP)
                .toArray(String[]::new);
    }

}
