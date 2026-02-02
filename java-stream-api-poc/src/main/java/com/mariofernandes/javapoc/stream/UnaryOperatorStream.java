package com.mariofernandes.javapoc.stream;

import java.util.List;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class UnaryOperatorStream {

    public static final List<String> NAMES = List.of("Mario", "Ana", "Pedro", "Mario", "Carla", "Maria");
    private final UnaryOperator<int[]> fibonacci = v -> new int[]{v[1], v[0] + v[1]};

    public UnaryOperatorStream() {}

    public List<Integer> operationsIterateLimitMapToList() {
        return Stream.iterate(new int[]{0, 1}, fibonacci)
                .limit(10)
                .map(v -> v[0])
                .toList();
    }

    public static void run() {
        UnaryOperatorStream unaryOperatorStream = new UnaryOperatorStream();

        System.out.println("Operations: Iterate - First 10 numbers in Fibonacci sequence -> Result: ");
        System.out.println(unaryOperatorStream.operationsIterateLimitMapToList());
    }
}
