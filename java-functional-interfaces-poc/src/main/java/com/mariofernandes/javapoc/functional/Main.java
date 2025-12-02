package com.mariofernandes.javapoc.functional;

public class Main {
    
    public static void main(String[] args) {
        System.out.println("=== Java Functional Interfaces POC ===\n");
        System.out.println("  1. Predicate<T>");
        Predicates.basic();
        Predicates.biPredicate();
        Predicates.whyDoNotWe();

        System.out.println("\n  2. Function<T, R>");
        Functions.basic();
        Functions.biFunction();
        Functions.whyDoNotWe();

        System.out.println("\n  3. Consumer<T>");
        Consumers.basic();
        Consumers.biConsumer();
        Consumers.whyDoNotWe();

        System.out.println("\n  4. Supplier<T>");
        Suppliers.basic();
        Suppliers.whyDoNotWe();

        System.out.println("\n  5. UnaryOperator<T>");
        UnaryOperators.basic();
        UnaryOperators.whyDoNotWe();

        System.out.println("\n  6. BinaryOperator<T>");
        BinaryOperators.basic();
        BinaryOperators.whyDoNotWe();

        System.out.println("\n  7. Primitive Specializations");
        System.out.println("  8. Method References");
        System.out.println("  9. Custom Functional Interfaces");
        System.out.println(" 10. Streams API Integration");
        System.out.println(" 11. Comparators");
    }
}
