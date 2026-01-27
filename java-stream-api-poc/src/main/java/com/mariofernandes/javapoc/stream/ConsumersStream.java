package com.mariofernandes.javapoc.stream;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
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
    private final BiConsumer<Person, Consumer<String>> biConsumer = (person, stringConsumer) -> stringConsumer.accept(person.name());

    public ConsumersStream() {}


    public String operationsMapMult() {
        return PEOPLE.stream().mapMulti(biConsumer).collect(Collectors.joining(", "));
    }

    public static void run() {
        ConsumersStream consumersStream = new ConsumersStream();

        System.out.println("People List: ");
        PEOPLE.forEach(person -> System.out.println(" - " + person));

        System.out.println("Operations: BiConsumer in mapMult to list name as String -> Results: ");
        System.out.println(consumersStream.operationsMapMult());
    }
}
