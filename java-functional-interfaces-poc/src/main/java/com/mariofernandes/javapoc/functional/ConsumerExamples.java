package com.mariofernandes.javapoc.functional;

import java.util.function.Consumer;

public class ConsumerExamples {

    public static void basic() {
        System.out.println(" --- Basic Consumer --- ");
        StringBuilder builder = new StringBuilder();
        Consumer<String> appendToBuilder = s -> builder.append(s).append(" ");
        Consumer<String> print = System.out::println;

        System.out.println("appendTobBuilder.accept(\"It's\")");
        appendToBuilder.accept("It's");
        System.out.println("appendTobBuilder.accept(\"me\")");
        appendToBuilder.accept("me");
        System.out.println("appendTobBuilder.accept(\"Mario\")");
        appendToBuilder.accept("Mario");
        System.out.println("print.accept(builder.toString())");
        print.accept(builder.toString());
        System.out.println(" --- --- - --- --- ");
    }

    public static void biConsumer() {
        System.out.println(" --- BiConsumer Example --- ");
        System.out.println(" --- --- - --- --- ");
    }

    public static void whyDoNotWe() {
        System.out.println(" --- Suggestions --- ");
        System.out.println(" --- --- - --- --- ");
    }
}
