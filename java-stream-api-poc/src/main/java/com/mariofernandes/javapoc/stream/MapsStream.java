package com.mariofernandes.javapoc.stream;

import java.util.List;
import java.util.stream.Stream;

public class MapsStream {

    public static final String[] NAMES = new String[]{"Mario", "Ana", "Pedro", "Mario", "Carla", "Maria"};
    public static final List<Integer> AGES = List.of(40, 20, 9, 40, 101, 35);

    public MapsStream() {}

    public List<String> operationsMapChain() {
        return Stream.of(NAMES)
                .map(String::toUpperCase)
                .map(name -> "Name: " + name)
                .map(name -> "[ " + name + " ]")
                .toList();
    }

    public List<Person> operationsMapToObjectPerson() {
        return Stream.iterate(0, i -> i < NAMES.length,i -> i + 1)
                .map(i -> new Person(NAMES[i], AGES.get(i)))
                .toList();
    }

    public Double operationsMapToDoubleAverage() {
        return AGES.stream()
                .mapToDouble(Integer::doubleValue)
                .average()
                .orElse(0.0);
    }

    public Integer operationsMapToIntSum() {
        return Stream.of(NAMES)
                .mapToInt(String::length)
                .sum();
    }

    public Long operationsMapToLongSum() {
        return AGES.stream()
                .mapToLong(Integer::longValue)
                .sum();
    }

    public List<String> operationsMapMulti() {
        return AGES.stream()
                .mapMulti((age, consumer) -> {
                    consumer.accept("Age: " + age);
                    consumer.accept("Double Age: " + (age * 2.0));
                })
                .map(Object::toString)
                .toList();
    }

    public List<Integer> operationsMapMultiToInt() {
        return AGES.stream()
                .mapMultiToInt((age, intConsumer) -> {
                    intConsumer.accept(age);
                    intConsumer.accept(age * 10);
                })
                .boxed()
                .toList();
    }

    public List<Integer> operationsFlatMap() {
        var nestedList = List.of(
                List.of(1, 2, 3),
                List.of(4, 5),
                List.of(6, 7, 8, 9)
        );
        return nestedList.stream()
                .flatMap(List::stream)
                .toList();
    }

    public static void run() {
        var instance = new MapsStream();

        System.out.println("NAMES and AGES: ");
        for (int i = 0; i < NAMES.length; i++) {
            System.out.println(" - Name: " + NAMES[i] + ", Age: " + AGES.get(i));
        }

        System.out.println("Operations: Map Chain -> Result: ");
        instance.operationsMapChain().forEach(item -> System.out.println(" - " + item));

        System.out.println("Operations: Map to Object Person -> Result: ");
        instance.operationsMapToObjectPerson().forEach(person -> System.out.println(" - " + person));

        System.out.println("Operations: Map to Double Average -> Result: " + instance.operationsMapToDoubleAverage());

        System.out.println("Operations: Map to Int Sum -> Result: " + instance.operationsMapToIntSum());

        System.out.println("Operations: Map to Long Sum -> Result: " + instance.operationsMapToLongSum());

        System.out.println("Operations: Map Multi -> Result: ");
        instance.operationsMapMulti().forEach(item -> System.out.println(" - " + item));

        System.out.println("Operations: Map Multi to Int -> Result: " + instance.operationsMapMultiToInt());

        System.out.println("Operations: Flat Map -> Result: " + instance.operationsFlatMap());
    }
}
