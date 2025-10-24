package com.mariofernandes.javapoc.functional;

import java.util.function.Predicate;

public class PredicateExamples {
    public static void basic() {
        System.out.println(" --- Basic Predicate --- ");

        Predicate<String> itsMe = s -> s.equalsIgnoreCase("Mario");
        Predicate<String> isNotEmpty = s -> !s.isEmpty();
        Predicate<String> isBlank = String::isBlank;
        Predicate<String> isLongerThan13 = s -> s.length() > 13;

        System.out.println("itsMe.test(\"mario\") = " + itsMe.test("mario"));
        System.out.println("itsMe.test(\"John\") = " + itsMe.test("John"));
        System.out.println("isNotEmpty.test(\"Hello\") = " + isNotEmpty.test("Hello"));
        System.out.println("isNotEmpty.test(\"\") = " + isNotEmpty.test(""));
        System.out.println("isBlank.test(\"   \") = " + isBlank.test("   "));
        System.out.println("isBlank.test(\" no \") = " + isBlank.test(" no "));
        System.out.println("isLongerThan13.test(\"Functional Programming in Java\") = " + isLongerThan13.test("Functional Programming in Java"));
        System.out.println("isLongerThan13.test(\"no enough\") = " + isLongerThan13.test("no enough"));
    }
}
