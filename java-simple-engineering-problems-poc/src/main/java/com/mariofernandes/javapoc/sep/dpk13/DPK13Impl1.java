package com.mariofernandes.javapoc.sep.dpk13;

import java.util.ArrayList;
import java.util.List;

public class DPK13Impl1 {

    public List<Object> fizzbuzz() {
        return fizzbuzz(100);
    }

    public List<Object> fizzbuzz(int size) {
        var result = new ArrayList<>();

        for (int i = 1; i <= size; i++) {
            boolean isFizz = i % 3 == 0;
            boolean isBuzz = i  % 5 == 0;
            if (isFizz && isBuzz) {
                result.add("FizzBuzz");
            } else if (isFizz) {
                result.add("Fizz");
            } else if (isBuzz) {
                result.add("Buzz");
            } else {
                result.add(i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println("--> DPK 13 - Implementation 01 <--");
        DPK13Impl1 dpk13Impl1 = new DPK13Impl1();

        var result = dpk13Impl1.fizzbuzz();
        System.out.println("fizzbuzz() -> " + result);

        var result2 = dpk13Impl1.fizzbuzz(10);
        System.out.println("fizzbuzz(10) -> " + result2);
    }
}

