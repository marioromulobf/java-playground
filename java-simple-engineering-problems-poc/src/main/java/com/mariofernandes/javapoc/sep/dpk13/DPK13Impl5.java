package com.mariofernandes.javapoc.sep.dpk13;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DPK13Impl5 {

    private final static Map<Integer, List<Object>> CACHE = new HashMap<>();

    public static List<Object> fizzbuzz() {
        return fizzbuzz(100);
    }

    public static List<Object> fizzbuzz(int size) {
        validate(size);

        var result = CACHE.get(size);
        if (null != result) {
            return new ArrayList<>(result);
        }

        result = new ArrayList<>(size);

        for (int i = 1; i <= size; i++) {
            result.add(convert(i));
        }

        CACHE.put(size, new ArrayList<>(result));

        return result;
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
        System.out.println("--> DPK 13 - Implementation 05 <--");

        var startTime = System.nanoTime();
        var result = DPK13Impl5.fizzbuzz();
        var endTime = System.nanoTime();
        System.out.println("Time taken: " + (endTime - startTime) + " ns - fizzbuzz() -> " + result);

        startTime = System.nanoTime();
        var result2 = DPK13Impl5.fizzbuzz(10);
        endTime = System.nanoTime();
        System.out.println("Time taken: " + (endTime - startTime) + " ns - fizzbuzz(10) -> " + result2);

        startTime = System.nanoTime();
        var result3 = DPK13Impl5.fizzbuzz(10);
        endTime = System.nanoTime();
        System.out.println("Time taken: " + (endTime - startTime) + " ns - fizzbuzz(10) -> " + result3);
    }
}

