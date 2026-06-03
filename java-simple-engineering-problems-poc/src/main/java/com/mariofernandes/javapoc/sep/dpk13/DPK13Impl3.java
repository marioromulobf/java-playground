package com.mariofernandes.javapoc.sep.dpk13;

import java.util.ArrayList;
import java.util.List;

public class DPK13Impl3 {

    public List<Object> fizzbuzz() {
        return fizzbuzz(100);
    }

    public List<Object> fizzbuzz(int size) {
        validate(size);

        var result = new ArrayList<>(size);

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

    private void validate(int value) {
        if  (value < 1) {
            throw new IllegalArgumentException();
        }
    }

    public static void main(String[] args) {
        System.out.println("--> DPK 13 - Implementation 03 <--");
        DPK13Impl3 dpk13Impl3 = new DPK13Impl3();

        var result = dpk13Impl3.fizzbuzz();
        System.out.println("fizzbuzz() -> " + result);

        var result2 = dpk13Impl3.fizzbuzz(10);
        System.out.println("fizzbuzz(10) -> " + result2);
    }
}

