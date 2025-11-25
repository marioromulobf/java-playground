package com.mariofernandes.javapoc.functional;

import java.util.function.UnaryOperator;

public class UnaryOperators {

    public static void basic() {
        System.out.println(" --- Basic UnaryOperator --- ");
        UnaryOperator<String> toUpperCase = String::toUpperCase;
        UnaryOperator<String> reverseString = s -> new StringBuilder(s).reverse().toString();
        UnaryOperator<String> toLowerCase = String::toLowerCase;
        UnaryOperator<String> identity = UnaryOperator.identity();


        System.out.println("toUpperCase.apply(\"Mario\") = " + toUpperCase.apply("Mario"));
        System.out.println(" ---> UnaryOperator andThen|compose|identity ");
        System.out.println("reverseString.andThen(toUpperCase).apply(\"Mario\") = " + reverseString.andThen(toUpperCase).apply("Mario"));
        System.out.println("toLowerCase.compose(reverseString.compose(toUpperCase)).apply(\"Mario\") = " + toLowerCase.compose(reverseString.compose(toUpperCase)).apply("Mario"));
        System.out.println("identity.apply(\"Mario\") = " + identity.apply("Mario"));

        System.out.println(" --- --- - --- --- ");
    }

    public static void whyDoNotWe() {
        System.out.println(" --- Suggestions --- ");
        System.out.println(" --- --- - --- --- ");
    }
}
