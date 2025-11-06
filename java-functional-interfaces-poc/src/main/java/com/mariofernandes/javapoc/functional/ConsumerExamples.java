package com.mariofernandes.javapoc.functional;

import java.util.function.Consumer;

public class ConsumerExamples {

    public static void basic() {
        System.out.println(" --- Basic Consumer --- ");
        StringBuilder builder = new StringBuilder();
        Consumer<String> appendToBuilder = s -> builder.append(s).append(" ");
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
