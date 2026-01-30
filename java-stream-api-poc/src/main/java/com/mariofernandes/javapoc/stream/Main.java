package com.mariofernandes.javapoc.stream;

public class Main {
    
    public static void main(String[] args) {
        System.out.println("=== Java Stream POC ===\n");
        System.out.println("  1. List");
        Lists.streams();

        System.out.println("\n  2. Arrays");
        ArraysStream.run();

        System.out.println("\n  3. Map");
        MapsStream.run();

        System.out.println("\n  4. Filter");
        Filters.run();

        System.out.println("\n  5. Predicates");
        PredicatesStream.run();

        System.out.println("\n  6. Supplier");
        SuppliersStream.run();

        System.out.println("\n  7. Consumer");
        ConsumersStream.run();

        System.out.println("\n  8. BinaryOperator");
        BinaryOperatorStream.run();

        System.out.println("\n  9. UnaryOperator");
    }
}
