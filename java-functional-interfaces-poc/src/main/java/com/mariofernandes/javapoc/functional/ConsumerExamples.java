package com.mariofernandes.javapoc.functional;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;

public class ConsumerExamples {

    public static void basic() {
        System.out.println(" --- Basic Consumer --- ");
        StringBuilder builder = new StringBuilder();

        Consumer<Integer> printInteger = i -> System.out.println("Number: " + i);
        Consumer<String> print = System.out::println;
        Consumer<String> appendToBuilder = s -> builder.append(s).append(" ");
        Consumer<List<Integer>> printOriginal = l -> System.out.println(" * Original: " + l);
        Consumer<List<Integer>> sort = Collections::sort;
        Consumer<List<Integer>> printSorted = l -> System.out.println(" * Sorted: " + l);
        Consumer<List<Integer>> reverse = Collections::reverse;
        Consumer<List<Integer>> printReversed = l -> System.out.println(" * Reversed: " + l);

        IntConsumer printIntAsDouble = i -> System.out.printf("Int as Double: %.2f\n", Double.valueOf(i));
        IntConsumer printIfIntIsPositiveOrNegative = i -> {
          if (i > 0) System.out.println(i + " is Positive");
          else if (i < 0) System.out.println(i + " is Negative");
        };

        LongConsumer printLongAsDouble = l -> System.out.printf("Long as Double: %.2f\n", Double.valueOf(l));
        LongConsumer printIfLongIsPositiveOrNegative = l -> {
            if (l > 0) System.out.println(l + " is Positive");
            else if (l < 0) System.out.println(l + " is Negative");
        };

        DoubleConsumer printDouble = d -> System.out.println("Double value: " + d);
        DoubleConsumer printIfDoubleIsPositiveOrNegative = d -> {
            if (d > 0) System.out.println(d + " is Positive");
            else if (d < 0) System.out.println(d + " is Negative");
        };

        System.out.print("printInteger.accept(13) -> ");
        printInteger.accept(13);

        System.out.println("appendTobBuilder.accept(\"It's\")");
        appendToBuilder.accept("It's");
        System.out.println("appendTobBuilder.accept(\"me\")");
        appendToBuilder.accept("me");
        System.out.println("appendTobBuilder.accept(\"Mario\")");
        appendToBuilder.accept("Mario");
        System.out.print("print.accept(builder.toString()) -> ");
        print.accept(builder.toString());

        System.out.println(" ---> Consumer Combining andThen ");
        System.out.println("printOriginal.andThen(sort).andThen(printSorted).andThen(reverse).andThen(printReversed).accept(Arrays.asList(5, 2, 8, 1, 9)):");
        printOriginal.andThen(sort).andThen(printSorted).andThen(reverse).andThen(printReversed).accept(Arrays.asList(5, 2, 8, 1, 9));

        System.out.println(" ---> IntConsumer ");
        System.out.print("printIntAsDouble.accept(10) -> ");
        printIntAsDouble.accept(10);
        System.out.println(" ---> IntConsumer Combining andThen ");
        System.out.println("printIntAsDouble.andThen(printIfIntIsPositiveOrNegative).accept(-10) -> ");
        printIntAsDouble.andThen(printIfIntIsPositiveOrNegative).accept(-10);

        System.out.println(" ---> LongConsumer ");
        System.out.print("printLongAsDouble.accept(666L) -> ");
        printLongAsDouble.accept(666L);
        System.out.println(" ---> LongConsumer Combining andThen ");
        System.out.println("printLongAsDouble.andThen(printIfLongIsPositiveOrNegative).accept(1000L) -> ");
        printLongAsDouble.andThen(printIfLongIsPositiveOrNegative).accept(1000L);

        System.out.println(" ---> DoubleConsumer ");
        System.out.println("printDouble.accept(Math.PI) -> ");
        printDouble.accept(Math.PI);
        System.out.println(" ---> DoubleConsumer Combining andThen ");
        System.out.println("printDouble.andThen(printIfDoubleIsPositiveOrNegative).accept(-Math.PI) -> ");
        printDouble.andThen(printIfDoubleIsPositiveOrNegative).accept(-Math.PI);
        System.out.println(" --- --- - --- --- ");
    }

    public static void biConsumer() {
        System.out.println(" --- BiConsumer Example --- ");
        BiConsumer<String, Integer> printNameAndAge = (name, age) -> System.out.println("Name: " + name + ", Age: " + age);
        printNameAndAge.accept("Mario", 30);
        System.out.println(" --- --- - --- --- ");
    }

    public static void whyDoNotWe() {
        System.out.println(" --- Suggestions --- ");
        System.out.println(" --- --- - --- --- ");
    }
}
