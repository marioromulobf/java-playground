package com.mariofernandes.javapoc.sep.dpk13;

import java.util.ArrayList;
import java.util.List;

public class DPK13Impl2 {

    public List<Object> fizzbuzz() {
        return fizzbuzz(100);
    }

    public List<Object> fizzbuzz(int size) {
        var result = new ArrayList<>();

        for (int i = 1; i <= size; i++) {
            result.add(convert(i));
        }

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

    public static void main(String[] args) {
        System.out.println("--> DPK 13 - Implementation 02 <--");
        DPK13Impl2 dpk13Impl2 = new DPK13Impl2();

        var result = dpk13Impl2.fizzbuzz();
        System.out.println("fizzbuzz() -> " + result);

        var result2 = dpk13Impl2.fizzbuzz(10);
        System.out.println("fizzbuzz(10) -> " + result2);
    }
}

