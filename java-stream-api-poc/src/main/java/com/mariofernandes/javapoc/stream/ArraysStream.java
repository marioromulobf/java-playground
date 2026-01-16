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

    public static void run() {
        var instance = new ArraysStream();

        System.out.println("Array of names: ");
        Arrays.stream(NAMES).forEach(name -> System.out.println(" - " + name));

        System.out.println("Operations: Sorted, Limit, and toArray -> Result:");
        for (String name : instance.operationsSortedLimitToArray()) {
            System.out.println(" - " + name);
        }

        System.out.println("Operations: Map, Skip, and toArray -> Result:");
        for (String name : instance.operationsMapSkipToArray()) {
            System.out.println(" - " + name);
        }

        System.out.println("Operations: Distinct, Filter, and Collect Joining -> Result:");
        System.out.println(" - " + instance.operationsDistinctFilterCollectJoining());

        System.out.println("Aggregation: Count -> Result: " + instance.aggregationCount());

        System.out.println("Aggregation: Max by Alphabetical -> Result: " + instance.aggregationMaxByAlphabetical());

        System.out.println("Aggregation: Min by Length -> Result: " + instance.aggregationMinByLength());
    }
}
