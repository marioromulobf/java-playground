package com.mariofernandes.javapoc.functional;

public class Main {
    
    public static void main(String[] args) {
        System.out.println("=== Java Functional Interfaces POC ===\n");
        System.out.println("  1. Predicate<T>");
        PredicateExamples.basic();
        PredicateExamples.biPredicate();
        PredicateExamples.whyDoNotWe();

        System.out.println("\n  2. Function<T, R>");
        FunctionExamples.basic();
        FunctionExamples.biFunction();
        FunctionExamples.whyDoNotWe();

        System.out.println("\n  3. Consumer<T>");
        System.out.println("  4. Supplier<T>");
        System.out.println("  5. BiFunction<T, U, R>");
        System.out.println("  6. UnaryOperator<T>");
        System.out.println("  7. BinaryOperator<T>");
        System.out.println("  8. Primitive Specializations");
        System.out.println("  9. Method References");
        System.out.println(" 10. Custom Functional Interfaces");
        System.out.println(" 11. Streams API Integration");
        System.out.println(" 12. Comparators");
    }
}
