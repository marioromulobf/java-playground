package com.mariofernandes.javapoc.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class SuppliersStream {

    private final Supplier<Person> personFactorySupplier = new PersonFactorySupplier();
    public static final List<Person> PEOPLE = List.of(
            new Person("Mario", 40, "Lisbon"),
            new Person("Ana", 20, "Porto"),
            new Person("Pedro", 9, "Coimbra"),
            new Person("Mario", 40, "Porto"),
            new Person("Carla", 101),
            new Person("Maria", 35, "Porto")
    );
    private final Supplier<List<Person>> initialSupplier = () -> new ArrayList<>();

    private final BiConsumer<List<Person>, Person> accumulatorBiConsumer =
            (list, person) -> {
                if (Objects.isNull(person.city())) {
                    return;
                }
                if (person.age() < 18) {
                    return;
                }
                if (list.stream().noneMatch(item -> item.name().equals(person.name()))) {
                    list.add(person);
                }
            };
    private final BiConsumer<List<Person>, List<Person>> combinerBiConsumer = (list1, list2) -> {
        List<String> names = list1.stream().map(Person::name).toList();
        list1.addAll(list2.stream().filter(person -> !names.contains(person.name())).toList());
    };

    public SuppliersStream() {}

    public List<Person> operationsGenerate3People() {
        return Stream.generate(personFactorySupplier)
                .limit(3)
                .toList();
    }

    public List<Person> operationsParallelCollect() {
        return PEOPLE.stream().parallel().collect(initialSupplier, accumulatorBiConsumer, combinerBiConsumer);
    }

    public static void run() {
        SuppliersStream suppliersStream = new SuppliersStream();

        System.out.println("Operations: Supplier in generate to create 3 People -> Results: ");
        suppliersStream.operationsGenerate3People().forEach(person -> System.out.println(" - " + person));

        System.out.println("Operations: Supplier and BiConsumer in collect -> Results: ");
        suppliersStream.operationsParallelCollect().forEach(person -> System.out.println(" - " + person));
    }
}
