package com.mariofernandes.javapoc.functional;

import java.util.function.BinaryOperator;
import java.util.function.Function;

public class BinaryOperators {
    public static void basic() {
        System.out.println(" --- Basic BinaryOperator --- ");
        BinaryOperator<Integer> sum = Integer::sum;
        BinaryOperator<Integer> integerMinBy = BinaryOperator.minBy(Integer::compare);
        BinaryOperator<Integer> integerMaxBy = BinaryOperator.maxBy(Integer::compare);

        System.out.println("sum.apply(13, 51) = " + sum.apply(13, 51));
        System.out.println(" ---> BinaryOperator minBy|maxBy ");
        System.out.println("integerMinBy.apply(13, 51) = " + integerMinBy.apply(13, 51));
        System.out.println("integerMaxBy.apply(13, 51) = " + integerMaxBy.apply(13, 51));


        System.out.println(" --- --- - --- --- ");
    }

    public static void whyDoNotWe() {
        System.out.println(" --- Suggestions --- ");
        System.out.println(" --- --- - --- --- ");
    }
}
