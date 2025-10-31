package com.mariofernandes.javapoc.functional;

import java.util.function.DoubleFunction;
import java.util.function.DoubleToIntFunction;
import java.util.function.DoubleToLongFunction;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.IntToDoubleFunction;
import java.util.function.IntToLongFunction;
import java.util.function.LongFunction;
import java.util.function.LongToDoubleFunction;
import java.util.function.LongToIntFunction;

public class FunctionExamples {

    public static void basic() {
        System.out.println(" --- Basic Function --- ");

        Function<String, Integer> stringLength = String::length;
        Function<Integer, Integer> square = value -> value * value;

        IntFunction<String> fromIntToString = value -> "Integer value: " + value;
        IntToLongFunction fromIntToLong = Long::valueOf;
        IntToDoubleFunction fromIntToDouble = Double::valueOf;

        LongFunction<String> fromLongToString = value -> "Long value: " + value;
        LongToIntFunction halfLongToIntOrThrow = value -> Math.toIntExact(value / 2);
        LongToDoubleFunction fromLongToDouble = Double::valueOf;

        DoubleFunction<String> fromDoubleToString = value -> "Double value: " + value;
        DoubleToIntFunction halfDoubleToIntOrThrow = value -> Math.toIntExact(Math.round(value / 2));
        DoubleToLongFunction halfDoubleToLong = value -> Math.round(value / 2);

        System.out.println("stringLength.apply(\"Mario\") = " + stringLength.apply("Mario"));
        System.out.println("square.apply(10) = " + square.apply(10));

        System.out.println(" ---> IntFunction ");
        System.out.println("fromIntToString.apply(10) = " + fromIntToString.apply(10));

        System.out.println(" ---> IntToLongFunction ");
        System.out.println("fromIntToLong.applyAsLong(10) = " + fromIntToLong.applyAsLong(10));

        System.out.println(" ---> IntToDoubleFunction ");
        System.out.println("fromIntToDouble.applyAsDouble(10) = " + fromIntToDouble.applyAsDouble(10));

        System.out.println(" ---> LongFunction ");
        System.out.println("fromLongToString.apply(10L) = " + fromLongToString.apply(10L));

        System.out.println(" ---> LongToIntFunction ");
        System.out.println("halfLongToIntOrThrow.applyAsInt(10L) = " + halfLongToIntOrThrow.applyAsInt(10L));

        System.out.println(" ---> LongToDoubleFunction ");
        System.out.println("fromLongToDouble.applyAsDouble(10L) = " + fromLongToDouble.applyAsDouble(10L));

        System.out.println(" ---> DoubleFunction ");
        System.out.println("fromDoubleToString.apply(10.0) = " + fromDoubleToString.apply(10.0));

        System.out.println(" ---> DoubleToIntFunction ");
        System.out.println("halfDoubleToIntOrThrow.applyAsInt(10.0) = " + halfDoubleToIntOrThrow.applyAsInt(10.0));

        System.out.println(" ---> DoubleToLongFunction ");
        System.out.println("halfDoubleToLong.applyAsLong(10.0) = " + halfDoubleToLong.applyAsLong(10.0));
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
