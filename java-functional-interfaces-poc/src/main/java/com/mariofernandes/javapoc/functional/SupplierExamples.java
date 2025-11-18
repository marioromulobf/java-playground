package com.mariofernandes.javapoc.functional;

import java.util.function.DoubleSupplier;
import java.util.function.Supplier;

public class SupplierExamples {
    public static void basic() {
        System.out.println(" --- Basic Supplier --- ");
        Supplier<String> stringSupplier = () -> "Hello, My Constant Supplier!";
        DoubleSupplier randomDoubleSupplier = Math::random;

        System.out.println("stringSupplier.get() = " + stringSupplier.get());

        System.out.println(" ---> DoubleSupplier ");
        System.out.println("randomDoubleSupplier.getAsDouble() = " + randomDoubleSupplier.getAsDouble());
    }

    public static void whyDoNotWe() {
        System.out.println(" --- Suggestions --- ");
    }
}
