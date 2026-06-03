package com.mariofernandes.javapoc.sep.dpk13;

import java.util.ArrayList;
import java.util.List;

public class DPK13Impl6 {

    private DPK13Impl6() {}

    private final static List<Object> CACHE = new ArrayList<>();

    public static List<Object> fizzbuzz() {
        return fizzbuzz(100);
    }

    public static List<Object> fizzbuzz(int size) {
        validate(size);

        while (CACHE.size() < size) {
            int value = CACHE.size() + 1;
            CACHE.add(convert(value));
        }

        return new ArrayList<>(CACHE.subList(0, size));
    }

    private static Object convert(int value) {
        boolean isFizz = value % 3 == 0;
        boolean isBuzz = value  % 5 == 0;

        if (isFizz && isBuzz) {
            return "FizzBuzz";
        }
        if (isFizz) {
            return "Fizz";
        }
        if (isBuzz) {
            return "Buzz";
        }

        return value;
    }

    private static void validate(int value) {
        if  (value < 1) {
            throw new IllegalArgumentException();
        }
    }

    public static void main(String[] args) {
        System.out.println("--> DPK 13 - Implementation 06 <--");

        var startTime = System.nanoTime();
        var result = DPK13Impl6.fizzbuzz(5);
        var endTime = System.nanoTime();
        System.out.println("Time taken: " + (endTime - startTime) + " ns - fizzbuzz(5) -> " + result);

        startTime = System.nanoTime();
        var result2 = DPK13Impl6.fizzbuzz(10);
        endTime = System.nanoTime();
        System.out.println("Time taken: " + (endTime - startTime) + " ns - fizzbuzz(10) -> " + result2);

        startTime = System.nanoTime();
        var result3 = DPK13Impl6.fizzbuzz(10);
        endTime = System.nanoTime();
        System.out.println("Time taken: " + (endTime - startTime) + " ns - fizzbuzz(10) -> " + result3);

        startTime = System.nanoTime();
        var result4 = DPK13Impl6.fizzbuzz();
        endTime = System.nanoTime();
        System.out.println("Time taken: " + (endTime - startTime) + " ns - fizzbuzz() -> " + result4);
    }
}

