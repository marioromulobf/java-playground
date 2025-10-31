package com.mariofernandes.javapoc.functional;

import java.util.function.Function;

public class FunctionExamples {

    public static void basic() {
        System.out.println(" --- Basic Function --- ");

        Function<String, Integer> stringLength = String::length;
        Function<Integer, Integer> square = value -> value * value;

        System.out.println("stringLength.apply(\"Mario\") = " + stringLength.apply("Mario"));
        System.out.println("square.apply(10) = " + square.apply(10));
        System.out.println(" --- --- - --- --- ");
    }

    public static void biFunction() {
        System.out.println(" --- BiFunction Example --- ");
        System.out.println(" --- --- - --- --- ");
    }

    public static void whyDoNotWe() {
        System.out.println(" --- Suggestions --- ");
        System.out.println(" --- --- - --- --- ");
    }
}
