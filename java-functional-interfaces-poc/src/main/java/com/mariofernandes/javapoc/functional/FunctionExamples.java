package com.mariofernandes.javapoc.functional;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiFunction;
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
import java.util.function.ToDoubleBiFunction;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntBiFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongBiFunction;
import java.util.function.ToLongFunction;

public class FunctionExamples {

    public static void basic() {
        System.out.println(" --- Basic Function --- ");

        Function<String, Integer> stringLength = String::length;
        Function<Integer, Integer> square = value -> value * value;
        Function<String, String> identity = Function.identity();

        IntFunction<String> fromIntToString = value -> "Integer value: " + value;
        IntToLongFunction fromIntToLong = Long::valueOf;
        IntToDoubleFunction fromIntToDouble = Double::valueOf;
        ToIntFunction<String> parseInt = Integer::parseInt;

        LongFunction<String> fromLongToString = value -> "Long value: " + value;
        LongToIntFunction halfLongToIntOrThrow = value -> Math.toIntExact(value / 2);
        LongToDoubleFunction fromLongToDouble = Double::valueOf;
        ToLongFunction<String> parseLong = Long::parseLong;

        DoubleFunction<String> fromDoubleToString = value -> "Double value: " + value;
        DoubleToIntFunction halfDoubleToIntOrThrow = value -> Math.toIntExact(Math.round(value / 2));
        DoubleToLongFunction halfDoubleToLong = value -> Math.round(value / 2);
        ToDoubleFunction<String> parseDouble = Double::parseDouble;

        System.out.println("stringLength.apply(\"Mario\") = " + stringLength.apply("Mario"));
        System.out.println("square.apply(10) = " + square.apply(10));
        System.out.println(" ---> Function andThen|compose|identify ");
        System.out.println("stringLength.andThen(square).apply(\"andThen\") = " + stringLength.andThen(square).apply("andThen"));
        System.out.println("square.compose(stringLength).apply(\"compose\") = " + square.compose(stringLength).apply("compose"));
        System.out.println("identity.apply(\"Mario\") = " + identity.apply("Mario"));

        System.out.println(" ---> IntFunction ");
        System.out.println("fromIntToString.apply(10) = " + fromIntToString.apply(10));

        System.out.println(" ---> IntToLongFunction ");
        System.out.println("fromIntToLong.applyAsLong(10) = " + fromIntToLong.applyAsLong(10));

        System.out.println(" ---> IntToDoubleFunction ");
        System.out.println("fromIntToDouble.applyAsDouble(10) = " + fromIntToDouble.applyAsDouble(10));

        System.out.println(" ---> ToIntFunction ");
        System.out.println("parseInt.applyAsInt(\"10\") = " + parseInt.applyAsInt("10"));

        System.out.println(" ---> LongFunction ");
        System.out.println("fromLongToString.apply(10L) = " + fromLongToString.apply(10L));

        System.out.println(" ---> LongToIntFunction ");
        System.out.println("halfLongToIntOrThrow.applyAsInt(10L) = " + halfLongToIntOrThrow.applyAsInt(10L));

        System.out.println(" ---> LongToDoubleFunction ");
        System.out.println("fromLongToDouble.applyAsDouble(10L) = " + fromLongToDouble.applyAsDouble(10L));

        System.out.println(" ---> ToLongFunction ");
        System.out.println("parseLong.applyAsLong(\"+10\") = " + parseLong.applyAsLong("+10"));

        System.out.println(" ---> DoubleFunction ");
        System.out.println("fromDoubleToString.apply(10.0) = " + fromDoubleToString.apply(10.0));

        System.out.println(" ---> DoubleToIntFunction ");
        System.out.println("halfDoubleToIntOrThrow.applyAsInt(10.0) = " + halfDoubleToIntOrThrow.applyAsInt(10.0));

        System.out.println(" ---> DoubleToLongFunction ");
        System.out.println("halfDoubleToLong.applyAsLong(10.0) = " + halfDoubleToLong.applyAsLong(10.0));

        System.out.println(" ---> ToDoubleFunction ");
        System.out.println("parseDouble.applyAsDouble(\"10.0\") = " + parseDouble.applyAsDouble("10.0"));
        System.out.println(" --- --- - --- --- ");
    }

    public static void biFunction() {
        System.out.println(" --- BiFunction Example --- ");
        Function<Integer, String> compareWith10 = i -> {
            if (i > 10) return i + " is grater than 10";
            if (i < 10) return i + " is smaller than 10";
            return i + " is equal to 10";
        };

        BiFunction<Integer, Integer, Integer> sum = Integer::sum;
        BiFunction<Integer, Integer, String> compareInteger = (a, b) -> {
            if (a > b) return a + " is greater";
            if (b > a) return b + " is greater";
            return a + " and " + b + " are equal";
        };

        ToIntBiFunction<String, String> sumLength = (a, b) -> a.length() + b.length();

        ToLongBiFunction<String, String> multiplyLengthAndDecrement = (a, b) -> Math.decrementExact(a.length() * b.length());

        ToDoubleBiFunction<String, String> multiplyLengthAndCos = (a, b) -> Math.cos(a.length() * b.length());

        System.out.println("sum.apply(3, 5) = " + sum.apply(3, 5));
        System.out.println("compareInteger.apply(7, 7) = " + compareInteger.apply(7, 7));

        System.out.println(" ---> BiFunction andThen( Function ) ");
        System.out.println("sum.andThen(compareWith10).apply(3, 5) = " + sum.andThen(compareWith10).apply(3, 5));

        System.out.println(" ---> ToIntBiFunction ");
        System.out.println("sumLength.applyAsInt(\"Mario\", \"Romulo\") = " + sumLength.applyAsInt("Mario", "Romulo"));

        System.out.println(" ---> ToLongBiFunction ");
        System.out.println("multiplayLengthAndDecrement.applyAsLong(\"Mario\", \"Romulo\") = " + multiplyLengthAndDecrement.applyAsLong("Mario", "Romulo"));

        System.out.println(" ---> ToDoubleBiFunction ");
        System.out.println("multiplyLengthAndCos.applyAsDouble(\"Mario\", \"Romulo\") = " + multiplyLengthAndCos.applyAsDouble("Mario", "Romulo"));
        System.out.println(" --- --- - --- --- ");
    }

    public static void whyDoNotWe() {
        System.out.println(" --- Suggestions --- ");
        BiFunction<String, Integer, Function<String, Person>> createFactory = (country, age) -> name -> new Person(name, age, country);

        System.out.println("createFactory.apply(\"Brazil\", 40).apply(\"Mario\")) = " + createFactory.apply("Brazil", 40).apply("Mario"));
        System.out.println(" --- --- - --- --- ");
    }
}
