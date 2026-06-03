package com.mariofernandes.javapoc.sep.dpk13;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DPK13Impl4 {

    private final static Map<Integer, List<Object>> CACHE = new HashMap<>();

    public List<Object> fizzbuzz() {
        return fizzbuzz(100);
    }

    public List<Object> fizzbuzz(int size) {
        validate(size);

        if (CACHE.containsKey(size)) {
            return CACHE.get(size);
        }

        var result = new ArrayList<>(size);

        for (int i = 1; i <= size; i++) {
            result.add(convert(i));
        }

        CACHE.put(size, result);

        return result;
    }

    private Object convert(int value) {
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

    private void validate(int value) {
        if  (value < 1) {
            throw new IllegalArgumentException();
        }
    }

    public static void main(String[] args) {
        System.out.println("--> DPK 13 - Implementation 04 <--");
        DPK13Impl4 dpk13Impl4 = new DPK13Impl4();

        var startTime = System.nanoTime();
        var result = dpk13Impl4.fizzbuzz();
        var endTime = System.nanoTime();
        System.out.println("Time taken: " + (endTime - startTime) + " ns - fizzbuzz() -> " + result);

        startTime = System.nanoTime();
        var result2 = dpk13Impl4.fizzbuzz(10);
        endTime = System.nanoTime();
        System.out.println("Time taken: " + (endTime - startTime) + " ns - fizzbuzz(10) -> " + result2);

        startTime = System.nanoTime();
        var result3 = dpk13Impl4.fizzbuzz(10);
        endTime = System.nanoTime();
        System.out.println("Time taken: " + (endTime - startTime) + " ns - fizzbuzz(10) -> " + result3);
    }
}

