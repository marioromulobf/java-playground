package com.mariofernandes.javapoc.functional;

import java.util.function.IntUnaryOperator;
import java.util.function.UnaryOperator;

public class UnaryOperators {

    public static void basic() {
        System.out.println(" --- Basic UnaryOperator --- ");
        UnaryOperator<String> toUpperCase = String::toUpperCase;
        UnaryOperator<String> reverseString = s -> new StringBuilder(s).reverse().toString();
        UnaryOperator<String> toLowerCase = String::toLowerCase;
        UnaryOperator<String> identity = UnaryOperator.identity();
        IntUnaryOperator incrementOne = i -> i + 1;
        IntUnaryOperator subtractOne = i -> i - 1;
        IntUnaryOperator square = i -> i * i;
        IntUnaryOperator identityInt = IntUnaryOperator.identity();


        System.out.println("toUpperCase.apply(\"Mario\") = " + toUpperCase.apply("Mario"));
        System.out.println(" ---> UnaryOperator andThen|compose|identity ");
        System.out.println("reverseString.andThen(toUpperCase).apply(\"Mario\") = " + reverseString.andThen(toUpperCase).apply("Mario"));
        System.out.println("toLowerCase.compose(reverseString.compose(toUpperCase)).apply(\"Mario\") = " + toLowerCase.compose(reverseString.compose(toUpperCase)).apply("Mario"));
        System.out.println("identity.apply(\"Mario\") = " + identity.apply("Mario"));

        System.out.println(" ---> IntUnaryOperator ");
        System.out.println("incrementOne.applyAsInt(10) = " + incrementOne.applyAsInt(10));
        System.out.println(" ---> IntUnaryOperator andThen|compose|identity ");
        System.out.println("incrementOne.andThen(square.andThen(subtractOne)).applyAsInt(1) = " + incrementOne.andThen(square.andThen(subtractOne)).applyAsInt(1));
        System.out.println("incrementOne.compose(square.compose(subtractOne)).applyAsInt(1) = " + incrementOne.compose(square.compose(subtractOne)).applyAsInt(1));
        System.out.println("identityInt.applyAsInt(13) = " + identityInt.applyAsInt(13));

        System.out.println(" --- --- - --- --- ");
    }

    public static void whyDoNotWe() {
        System.out.println(" --- Suggestions --- ");
        System.out.println(" --- --- - --- --- ");
    }
}
