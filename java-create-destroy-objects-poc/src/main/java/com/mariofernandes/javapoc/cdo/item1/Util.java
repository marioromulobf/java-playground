package com.mariofernandes.javapoc.cdo.item1;

import java.util.stream.IntStream;

public class Util {
    public static boolean isPrime(int number) {
        return number > 1
                && IntStream.rangeClosed(2, (int) Math.sqrt(number))
                .noneMatch(n -> (number % n == 0));
    }
}
