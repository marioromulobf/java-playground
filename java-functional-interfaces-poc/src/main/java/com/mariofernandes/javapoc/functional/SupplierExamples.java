package com.mariofernandes.javapoc.functional;

import java.util.function.Supplier;

public class SupplierExamples {
    public static void basic() {
        System.out.println(" --- Basic Supplier --- ");
        Supplier<String> stringSupplier = () -> "Hello, My Constant Supplier!";

        System.out.println("stringSupplier.get() = " + stringSupplier.get());
    }

    public static void whyDoNotWe() {
        System.out.println(" --- Suggestions --- ");
    }
}
