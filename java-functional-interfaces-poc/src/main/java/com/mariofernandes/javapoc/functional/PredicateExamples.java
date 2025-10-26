package com.mariofernandes.javapoc.functional;

import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;
import java.util.function.Predicate;

public class PredicateExamples {

    public static void basic() {
        System.out.println(" --- Basic Predicate --- ");

        Predicate<String> isNotEmpty = s -> !s.isEmpty();
        Predicate<String> isLongerThan13 = s -> s.length() > 13;
        Predicate<String> itsMe = s -> s.equalsIgnoreCase("Mario");
        Predicate<String> isBlank = String::isBlank;

        System.out.println(" ---> String ");
        System.out.println("itsMe.test(\"mario\") = " + itsMe.test("mario"));
        System.out.println("itsMe.test(\"John\") = " + itsMe.test("John"));
        System.out.println("isNotEmpty.test(\"Hello\") = " + isNotEmpty.test("Hello"));
        System.out.println("isNotEmpty.test(\"\") = " + isNotEmpty.test(""));
        System.out.println("isBlank.test(\"   \") = " + isBlank.test("   "));
        System.out.println("isBlank.test(\" no \") = " + isBlank.test(" no "));
        System.out.println("isLongerThan13.test(\"Functional Programming in Java\") = " + isLongerThan13.test("Functional Programming in Java"));
        System.out.println("isLongerThan13.test(\"no enough\") = " + isLongerThan13.test("no enough"));
        System.out.println(" ---> String Combining And/Or/Negate ");
        Predicate<String> complexPredicate = isBlank.negate().and(itsMe).or(isBlank.negate().and(isLongerThan13));
        System.out.println("complexPredicate.test(\"John\") = " + complexPredicate.test("John"));
        System.out.println("complexPredicate.test(\"mario\") = " + complexPredicate.test("mario"));
        System.out.println("complexPredicate.test(\"               \") = " + complexPredicate.test("               "));
        System.out.println("complexPredicate.test(\"Functional Programming in Java\") = " + complexPredicate.test("Functional Programming in Java"));

        System.out.println(" ---> Integer ");
        Predicate<Integer> isPositive = n -> n > 0;
        Predicate<Integer> isNegative = n -> n < 0;
        Predicate<Integer> isZero = n -> n == 0;
        System.out.println("isPositive.test(13) = " + isPositive.test(13));
        System.out.println("isPositive.test(0) = " + isPositive.test(0));
        System.out.println("isZero.test(0) = " + isZero.test(0));
        System.out.println("isNegative.test(0) = " + isNegative.test(0));
        System.out.println("isNegative.test(-13) = " + isNegative.test(-13));
        System.out.println(" ---> Integer Combining And/Or/Negate ");
        Predicate<Integer> complexIntegerPredicate = isZero.and(isPositive.negate().or(isNegative.negate()));
        System.out.println("complexIntegerPredicate.test(1) = " + complexIntegerPredicate.test(1));
        System.out.println("complexIntegerPredicate.test(0) = " + complexIntegerPredicate.test(0));
        System.out.println("complexIntegerPredicate.test(-1) = " + complexIntegerPredicate.test(-1));

        System.out.println(" ---> IntPredicate ");
        IntPredicate isPositiveInt = i -> i > 0;
        IntPredicate isNegativeInt = i -> i < 0;
        IntPredicate isZeroInt = i -> i == 0;
        System.out.println("isPositiveInt.test(13) = " + isPositiveInt.test(13));
        System.out.println("isPositiveInt.test(0) = " + isPositiveInt.test(0));
        System.out.println(" ---> IntPredicate Combining And/Or/Negate ");
        IntPredicate complexIntPredicate = isZeroInt.and(isPositiveInt.negate().or(isNegativeInt.negate()));
        System.out.println("complexIntPredicate.test(1) = " + complexIntPredicate.test(1));
        System.out.println("complexIntPredicate.test(0) = " + complexIntPredicate.test(0));
        System.out.println("complexIntPredicate.test(-1) = " + complexIntPredicate.test(-1));

        System.out.println(" ---> LongPredicate ");
        LongPredicate isPositiveLong = l -> l > 0L;
        LongPredicate isNegativeLong = l -> l < 0L;
        LongPredicate isZeroLong = l -> l == 0L;
        System.out.println("isPositiveLong.test(13L) = " + isPositiveLong.test(13L));
        System.out.println("isPositiveLong.test(0L) = " + isPositiveLong.test(0L));
        System.out.println(" ---> LongPredicate Combining And/Or/Negate ");
        LongPredicate complexLongPredicate = isZeroLong.and(isPositiveLong.negate().or(isNegativeLong.negate()));
        System.out.println("complexLongPredicate.test(1L) = " + complexLongPredicate.test(1L));
        System.out.println("complexLongPredicate.test(0L) = " + complexLongPredicate.test(0L));
        System.out.println("complexLongPredicate.test(-1L) = " + complexLongPredicate.test(-1L));

        System.out.println(" ---> DoublePredicate ");
        DoublePredicate isPositiveDouble = d -> d > 0.0;
        DoublePredicate isNegativeDouble = d -> d < 0.0;
        DoublePredicate isZeroDouble = d -> d == 0.0;
        System.out.println("isPositiveDouble.test(13.13) = " + isPositiveDouble.test(13.13));
        System.out.println("isPositiveDouble.test(0.0) = " + isPositiveDouble.test(0.0));
        System.out.println(" ---> DoublePredicate Combining And/Or/Negate ");
        DoublePredicate complexDoublePredicate = isZeroDouble.and(isPositiveDouble.negate().or(isNegativeDouble.negate()));
        System.out.println("complexDoublePredicate.test(1.0) = " + complexDoublePredicate.test(1.0));
        System.out.println("complexDoublePredicate.test(0.0) = " + complexDoublePredicate.test(0.0));
        System.out.println("complexDoublePredicate.test(-1.0) = " + complexDoublePredicate.test(-1.0));
        System.out.println(" --- --- - --- --- ");
    }

    public static void biPredicate() {
        System.out.println(" --- BiPredicate Example --- ");

        System.out.println(" --- --- - --- --- ");
    }

    public static void whyDoNotWe() {
        System.out.println(" --- Suggestions --- ");

        System.out.println(" --- --- - --- --- ");
    }
}
