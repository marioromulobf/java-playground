package com.mariofernandes.javapoc.functional;

import java.util.List;
import java.util.function.DoubleUnaryOperator;
import java.util.function.IntUnaryOperator;
import java.util.function.LongUnaryOperator;
import java.util.function.UnaryOperator;

public class UnaryOperators {

    public static void basic() {
        System.out.println(" --- Basic UnaryOperator --- ");
        UnaryOperator<String> toUpperCase = String::toUpperCase;
        UnaryOperator<String> reverseString = s -> new StringBuilder(s).reverse().toString();
        UnaryOperator<String> toLowerCase = String::toLowerCase;
        UnaryOperator<String> identity = UnaryOperator.identity();

        IntUnaryOperator incrementOne = i -> i + 1;
        IntUnaryOperator subtractOne = i -> i - 1;
        IntUnaryOperator square = i -> i * i;
        IntUnaryOperator identityInt = IntUnaryOperator.identity();

        LongUnaryOperator multiplyByTwo = l -> l * 2L;
        LongUnaryOperator subtractTwo = l -> l - 2L;
        LongUnaryOperator divideByTwo = l -> l / 2L;
        LongUnaryOperator identityLong = LongUnaryOperator.identity();

        DoubleUnaryOperator multiplyByHalf = d -> d * 0.5;
        DoubleUnaryOperator sqrt = Math::sqrt;
        DoubleUnaryOperator negate = d -> -d;
        DoubleUnaryOperator identityDouble = DoubleUnaryOperator.identity();

        System.out.println("toUpperCase.apply(\"Mario\") = " + toUpperCase.apply("Mario"));
        System.out.println(" ---> UnaryOperator andThen|compose|identity ");
        System.out.println("reverseString.andThen(toUpperCase).apply(\"Mario\") = " + reverseString.andThen(toUpperCase).apply("Mario"));
        System.out.println("toLowerCase.compose(reverseString.compose(toUpperCase)).apply(\"Mario\") = " + toLowerCase.compose(reverseString.compose(toUpperCase)).apply("Mario"));
        System.out.println("identity.apply(\"Mario\") = " + identity.apply("Mario"));

        System.out.println(" ---> IntUnaryOperator ");
        System.out.println("incrementOne.applyAsInt(10) = " + incrementOne.applyAsInt(10));
        System.out.println(" ---> IntUnaryOperator andThen|compose|identity ");
        System.out.println("incrementOne.andThen(square.andThen(subtractOne)).applyAsInt(1) = " + incrementOne.andThen(square.andThen(subtractOne)).applyAsInt(1));
        System.out.println("incrementOne.compose(square.compose(subtractOne)).applyAsInt(1) = " + incrementOne.compose(square.compose(subtractOne)).applyAsInt(1));
        System.out.println("identityInt.applyAsInt(13) = " + identityInt.applyAsInt(13));

        System.out.println(" ---> LongUnaryOperator ");
        System.out.println("multiplayByTwo.applyAsLong(5L) = " + multiplyByTwo.applyAsLong(5L));
        System.out.println(" ---> LongUnaryOperator andThen|compose|identity ");
        System.out.println("multiplyByTwo.andThen(subtractTwo.andThen(divideByTwo)).applyAsLong(2L) = " + multiplyByTwo.andThen(subtractTwo.andThen(divideByTwo)).applyAsLong(2L));
        System.out.println("multiplyByTwo.compose(subtractTwo.compose(divideByTwo)).applyAsLong(2L) = " + multiplyByTwo.compose(subtractTwo.compose(divideByTwo)).applyAsLong(2L));
        System.out.println("identityLong.applyAsLong(20L) = " + identityLong.applyAsLong(20L));

        System.out.println(" ---> DoubleUnaryOperator ");
        System.out.println("multiplyByHalf.applyAsDouble(5.0) = " + multiplyByHalf.applyAsDouble(5.0));
        System.out.println(" ---> DoubleUnaryOperator andThen|compose|identity ");
        System.out.println("multiplyByHalf.andThen(sqrt.andThen(negate)).applyAsDouble(25.0) = " + multiplyByHalf.andThen(sqrt.andThen(negate)).applyAsDouble(25.0));
        System.out.println("multiplyByHalf.compose(sqrt.compose(negate)).applyAsDouble(-25.0) = " + multiplyByHalf.compose(sqrt.compose(negate)).applyAsDouble(-25.0));
        System.out.println("identityDouble.applyAsDouble(13.5) = " + identityDouble.applyAsDouble(13.5));
        System.out.println(" --- --- - --- --- ");
    }

    public static void whyDoNotWe() {
        System.out.println(" --- Suggestions --- ");
        UnaryOperator<Person> incrementAge = person -> {
            person.setAge(person.getAge() + 1);
            return person;
        };
        List<Person> people = List.of(
                new Person("Mario", 30, "Brazil"),
                new Person("Anne", 25, "USA"),
                new Person("Joao", 15, "Brazil"),
                new Person("Maria", 70, "Portugal"),
                new Person("Maui", 1000, "Hawaii")
        );
        System.out.println("People:");
        people.forEach(System.out::println);
        System.out.println("\nIncrement Age:");
        people.stream()
                .map(incrementAge)
                .forEach(person -> System.out.println("After Birthday: " + person));
        System.out.println(" --- --- - --- --- ");
    }
}
