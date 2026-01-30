package com.mariofernandes.javapoc.stream;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;

public class BinaryOperatorStream {

    public static final List<Person> PEOPLE = List.of(
            new Person("Mario", 40, "Lisbon"),
            new Person("Ana", 20, "Porto"),
            new Person("Pedro", 9, "Coimbra"),
            new Person("Mario", 40, "Porto"),
            new Person("Carla", 101, "Braga"),
            new Person("Maria", 35, "Porto")
    );

    private final BinaryOperator<String> binaryOperatorStringMinByLength = BinaryOperator.minBy(Comparator.comparingInt(String::length));
    private final BinaryOperator<Integer> binaryOperatorIntegerSum = Integer::sum;

    public BinaryOperatorStream() {}

    public Optional<String> operationsMapReduceWithBinaryOperatorString() {
        return PEOPLE.stream()
                .map(Person::name)
                .reduce(binaryOperatorStringMinByLength);
    }

    public Integer operationsMapReduceWithBinaryOperatorInteger() {
        return PEOPLE.stream()
                .map(Person::age)
                .reduce(0, binaryOperatorIntegerSum);
    }

    public static void run() {
        BinaryOperatorStream binaryOperatorStream = new BinaryOperatorStream();
        System.out.println("People List: ");
        PEOPLE.forEach(person -> System.out.println(" - " + person));

        System.out.println("Operations: BinaryOperator in reduce by String::length -> Result: ");
        System.out.println(binaryOperatorStream.operationsMapReduceWithBinaryOperatorString());

        System.out.println("Operations: BinaryOperator in reduce by Integer::sum -> Result: ");
        System.out.println(binaryOperatorStream.operationsMapReduceWithBinaryOperatorInteger());
    }

}
