package com.mariofernandes.javapoc.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    public Long aggregationCount() {
        return Stream.of(NAMES).count();
    }

    public String aggregationMaxByAlphabetical() {
        return Stream.of(NAMES)
                .max(String::compareTo)
                .orElse(null);
    }

    public String aggregationMinByLength() {
        return Stream.of(NAMES)
                .min(Comparator.comparingInt(String::length))
                .orElse(null);
    }
}
