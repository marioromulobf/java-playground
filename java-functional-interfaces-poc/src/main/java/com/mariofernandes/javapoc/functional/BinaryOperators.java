package com.mariofernandes.javapoc.functional;

import java.util.function.BinaryOperator;

public class BinaryOperators {
    public static void basic() {
        System.out.println(" --- Basic BinaryOperator --- ");
        BinaryOperator<Integer> sum = Integer::sum;

        System.out.println("sum.apply(13, 51) = " + sum.apply(13, 51));


        System.out.println(" --- --- - --- --- ");
    }

    public static void whyDoNotWe() {
        System.out.println(" --- Suggestions --- ");
        System.out.println(" --- --- - --- --- ");
    }
}
