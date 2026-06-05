package com.mariofernandes.javapoc.sep.dpk13;

import java.util.ArrayList;
import java.util.List;

public class DPK13Impl9 {

    private DPK13Impl9() {}

    private final static List<Object> CACHE = new ArrayList<>();
    private final static int DEFAULT_SIZE = 100;
    private static final String FIZZ = "Fizz";
    private static final String BUZZ = "Buzz";

    public static List<Object> fizzbuzz() {
        return fizzbuzz(DEFAULT_SIZE);
    }

    interface Converter<I, R> {
        R apply(I input);
    }

    public static List<Object> fizzbuzz(int size) {
        validate(size);

        updateCache(size, DPK13Impl9::convert);

        return new ArrayList<>(CACHE.subList(0, size));
    }

    private static void updateCache(int size, Converter<Integer, Object> converter) {
        while (CACHE.size() < size) {
            int value = CACHE.size() + 1;
            CACHE.add(converter.apply(value));
        }
    }

    private static Object convert(int value) {
        boolean isFizz = value % 3 == 0;
        boolean isBuzz = value  % 5 == 0;
        StringBuilder result = new StringBuilder();

        if (isFizz) {
            result.append(FIZZ);
        }
        if (isBuzz) {
            result.append(BUZZ);
        }

        return result.length() > 0 ? result.toString() : value;
    }

    private static void validate(int value) {
        if  (value < 1) {
            throw new IllegalArgumentException();
        }
    }

    public static void main(String[] args) {
        System.out.println("--> DPK 13 - Implementation 09 <--");

        var startTime = System.nanoTime();
        var result = DPK13Impl9.fizzbuzz(5);
        var endTime = System.nanoTime();
        System.out.println("Time taken: " + (endTime - startTime) + " ns - fizzbuzz(5) -> " + result);

        startTime = System.nanoTime();
        var result2 = DPK13Impl9.fizzbuzz(10);
        endTime = System.nanoTime();
        System.out.println("Time taken: " + (endTime - startTime) + " ns - fizzbuzz(10) -> " + result2);

        startTime = System.nanoTime();
        var result3 = DPK13Impl9.fizzbuzz(10);
        endTime = System.nanoTime();
        System.out.println("Time taken: " + (endTime - startTime) + " ns - fizzbuzz(10) -> " + result3);

        startTime = System.nanoTime();
        var result4 = DPK13Impl9.fizzbuzz();
        endTime = System.nanoTime();
        System.out.println("Time taken: " + (endTime - startTime) + " ns - fizzbuzz() -> " + result4);
    }
}
