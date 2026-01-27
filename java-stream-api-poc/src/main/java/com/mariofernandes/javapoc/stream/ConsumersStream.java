package com.mariofernandes.javapoc.stream;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.stream.Collectors;

public class ConsumersStream {

    public static final List<Person> PEOPLE = List.of(
            new Person("Mario", 40, "Lisbon"),
            new Person("Ana", 20, "Porto"),
            new Person("Pedro", 9, "Coimbra"),
            new Person("Mario", 40, "Porto"),
            new Person("Carla", 101),
            new Person("Maria", 35, "Porto")
    );
    private final BiConsumer<Person, Consumer<String>> biConsumerString = (person, stringConsumer) -> stringConsumer.accept(person.name());

    public final Double averageAge = PEOPLE.stream()
            .mapToDouble(person -> Double.parseDouble(person.age()+"")).average().orElse(0.0);
    private final BiConsumer<Person, DoubleConsumer> biConsumerPercentOfAverageAge =
            (person, doubleConsumer) -> doubleConsumer.accept( Math.round(10000.0 * person.age() / averageAge) / 100.0);

    public ConsumersStream() {}


    public String operationsMapMultPersonToName() {
        return PEOPLE.stream().mapMulti(biConsumerString).collect(Collectors.joining(", "));
    }

    public List<Double> operationsMapMultiToDoublePersonToPercentOfAverageAge() {
        return PEOPLE.stream().mapMultiToDouble(biConsumerPercentOfAverageAge).boxed().toList();
    }

    public static void run() {
        ConsumersStream consumersStream = new ConsumersStream();

        System.out.println("People List: ");
        PEOPLE.forEach(person -> System.out.println(" - " + person));
        System.out.println("Average of Age: " + consumersStream.averageAge);

        System.out.println("Operations: BiConsumer in mapMult to list name as String -> Results: ");
        System.out.println(consumersStream.operationsMapMultPersonToName());

        System.out.println("Operations: BiConsumer in MapMultiToDouble - Percentage of Average Age -> Results: ");
        System.out.println(consumersStream.operationsMapMultiToDoublePersonToPercentOfAverageAge());
    }
}
