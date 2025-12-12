package com.mariofernandes.javapoc.functional;

import java.io.PrintStream;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.DoubleBinaryOperator;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.LongBinaryOperator;

public class BinaryOperators {
    public static void basic() {
        System.out.println(" --- Basic BinaryOperator --- ");
        BinaryOperator<Integer> sum = Integer::sum;
        BinaryOperator<Integer> integerMinBy = BinaryOperator.minBy(Integer::compare);
        BinaryOperator<Integer> integerMaxBy = BinaryOperator.maxBy(Integer::compare);
        Function<Integer, Integer> squareFunction = i -> i * i;

        IntBinaryOperator divide = (a, b) -> a / b;

        LongBinaryOperator maxLong = Long::max;

        DoubleBinaryOperator powDouble = Math::pow;

        System.out.println("sum.apply(13, 51) = " + sum.apply(13, 51));
        System.out.println(" ---> BinaryOperator minBy|maxBy|andThen ");
        System.out.println("integerMinBy.apply(13, 51) = " + integerMinBy.apply(13, 51));
        System.out.println("integerMaxBy.apply(13, 51) = " + integerMaxBy.apply(13, 51));
        System.out.println("sum.andThen(squareFunction).apply(2, 3) = " + sum.andThen(squareFunction).apply(2, 3));

        System.out.println(" ---> IntBinaryOperator ");
        System.out.println("divide.applyAsInt(5, 2) = " + divide.applyAsInt(5, 2));

        System.out.println(" ---> LongBinaryOperator ");
        System.out.println("maxLong.applyAsLong(400L, 666L) = " + maxLong.applyAsLong(400L, 666L));

        System.out.println(" ---> DoubleBinaryOperator ");
        System.out.println("powDouble.applyAsDouble(2.0, 3.0) = " + powDouble.applyAsDouble(2.0, 3.0));
        System.out.println(" --- --- - --- --- ");
    }

    public static void whyDoNotWe() {
        System.out.println(" --- Suggestions --- ");
        Map<String, Double> shoppingList = Map.of(
                "Laptop", 1200.00,
                "Smartphone", 800.00,
                "Tablet", 400.00,
                "Monitor", 300.00
        );
        BinaryOperator<Double> applyDiscount = (price, discount) -> price - (price * discount / 100);
        BinaryOperator<Double> sumPrices = Double::sum;

        System.out.println("Shopping List:");
        shoppingList.forEach((s, aDouble) -> System.out.println(" - Product " + s + ": $" + String.format("%.2f", aDouble)));
        Double totalPrice = shoppingList.values().stream().reduce(sumPrices).orElse(0.0);
        System.out.printf("Total Price before discount: $%.2f\n", totalPrice);
        Double totalAfterDiscount = applyDiscount.apply(totalPrice, 5.5);
        System.out.println("Total Price after 5.5% discount: " + String.format("$%.2f", totalAfterDiscount));

        System.out.println(" --- --- - --- --- ");
    }
}
