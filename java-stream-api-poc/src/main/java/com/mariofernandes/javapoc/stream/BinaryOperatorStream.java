package com.mariofernandes.javapoc.stream;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;

public class BinaryOperatorStream {

    public static final List<String> NAMES = List.of("Mario", "Ana", "Pedro", "Mario", "Carla", "Maria");
    private final BinaryOperator<String> binaryOperatorStringMinByLength = BinaryOperator.minBy(Comparator.comparingInt(String::length));

    public BinaryOperatorStream() {}

    public Optional<String> operationsReduce() {
        return NAMES.stream()
                .reduce(binaryOperatorStringMinByLength);
    }

    public static void run() {
        BinaryOperatorStream binaryOperatorStream = new BinaryOperatorStream();
        System.out.println("Name List: ");
        NAMES.forEach(name -> System.out.println(" - " + name));

        System.out.println("Operations: BinaryOperator in reduce by String::length -> Result: ");
        System.out.println(binaryOperatorStream.operationsReduce());
    }

}
