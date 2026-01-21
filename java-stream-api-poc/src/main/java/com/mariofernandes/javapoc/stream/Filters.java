package com.mariofernandes.javapoc.stream;

import java.util.List;
import java.util.Optional;

public class Filters {

    public static final List<Person> PEOPLE = List.of(
            new Person("Mario", 40, "Lisbon"),
            new Person("Ana", 20, "Porto"),
            new Person("Pedro", 9, "Coimbra"),
            new Person("Mario", 40, "Porto"),
            new Person("Carla", 101, "Braga"),
            new Person("Maria", 35, "Porto")
    );

    public Filters() {
    }

    public List<Person> operationsFilterChain() {
        return PEOPLE.stream()
                .filter(person -> person.age() >= 18)
                .filter(person -> person.age() < 60)
                .filter(person -> person.name().startsWith("M"))
                .toList();
    }

    public List<Person> operationsFilterComplex() {
        return PEOPLE.stream()
                .filter(person -> (person.age() >= 18 && person.age() < 60) || person.name().startsWith("P"))
                .toList();
    }

    public Optional<Person> operationsFilterFindFirst() {
        return PEOPLE.stream()
                .filter(person -> person.city() != null)
                .filter(person -> person.city().equals("Porto"))
                .findFirst();
    }

    public Optional<Person> operationsFilterFindAny() {
        return PEOPLE.stream()
                .filter(person -> person.city() != null)
                .filter(person -> person.city().equals("Porto"))
                .findAny();
    }

    public static void run() {
        Filters filters = new Filters();

        System.out.println("People List: ");
        PEOPLE.forEach(person -> System.out.println(" - " + person));

        System.out.println("Operations: Filter Chain -> Results: ");
        System.out.println(filters.operationsFilterChain());
        System.out.println("Operations: Filter Complex -> Results: ");
        filters.operationsFilterComplex().forEach(person -> System.out.println(" - " + person));
        System.out.println("Operations: Filter Find First -> Result: " + filters.operationsFilterFindFirst());
        System.out.println("Operations: Filter Find Any -> Result: " + filters.operationsFilterFindAny());
    }
}