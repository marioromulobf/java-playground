package com.mariofernandes.javapoc.stream;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class SuppliersStream {

    private final Supplier<Person> personFactorySupplier = new PersonFactorySupplier();

    public SuppliersStream() {}

    public List<Person> operationsGenerate3People() {
        return Stream.generate(personFactorySupplier)
                .limit(3)
                .toList();
    }

    public static void run() {
        SuppliersStream suppliersStream = new SuppliersStream();

        System.out.println("Operations: Supplier in generate to create 3 People -> Results: ");
        suppliersStream.operationsGenerate3People().forEach(person -> System.out.println(" - " + person));

    }
}
