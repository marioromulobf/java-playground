package com.mariofernandes.javapoc.stream;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ArraysStream {
    public static final String[] NAMES = {"Mario", "Ana", "Pedro", "Mario", "Carla", "Maria"};
    public static final int LIMIT_SKIP = 3;

    public ArraysStream() {}

    public String[] operationsSortedLimitToArray() {
        return Arrays.stream(NAMES)
                .sorted()
                .limit(LIMIT_SKIP)
                .toArray(String[]::new);
    }

    public String[] operationsMapSkipToArray() {
        return Arrays.stream(NAMES)
                .map(String::toLowerCase)
                .skip(LIMIT_SKIP)
                .toArray(String[]::new);
    }

    public String operationsDistinctFilterCollectJoining() {
        return Arrays.stream(NAMES)
                .distinct()
                .filter(name -> name.startsWith("Mar"))
                .collect(Collectors.joining(","));
    }

}
