package com.mariofernandes.javapoc.functional;

import java.util.function.UnaryOperator;

public class UnaryOperators {

    public static void basic() {
        System.out.println(" --- Basic UnaryOperator --- ");
        UnaryOperator<String> toUpperCase = String::toUpperCase;
        UnaryOperator<String> reverseString = s -> new StringBuilder(s).reverse().toString();


        System.out.println("toUpperCase.apply(\"Mario\") = " + toUpperCase.apply("Mario"));
        System.out.println("reverseString.andThen(toUpperCase).apply(\"Mario\") = " + reverseString.andThen(toUpperCase).apply("Mario"));

        System.out.println(" --- --- - --- --- ");
    }

    public static void whyDoNotWe() {
        System.out.println(" --- Suggestions --- ");
        System.out.println(" --- --- - --- --- ");
    }
}
