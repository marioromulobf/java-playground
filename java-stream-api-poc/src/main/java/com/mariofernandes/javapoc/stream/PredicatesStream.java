package com.mariofernandes.javapoc.stream;

import java.util.List;
import java.util.function.Predicate;

public class PredicatesStream {

    public static final List<Person> PEOPLE = List.of(
            new Person("Mario", 40, "Lisbon"),
            new Person("Ana", 20, "Porto"),
            new Person("Pedro", 9, "Coimbra"),
            new Person("Mario", 40, "Porto"),
            new Person("Carla", 101, "Braga"),
            new Person("Maria", 35, "Porto")
    );

    private final Predicate<Person> isAdult = person -> person.age() >= 18;
    private final Predicate<Person> livesInPorto = person -> person.city().equals("Porto");
    private final Predicate<Person> nameStartsWithM = person -> person.name().startsWith("M");

    public PredicatesStream() {}

    public List<Person> operationsFilterPredicatesIsNotAdultAndNotLivesInPorto() {
        return PEOPLE.stream()
                .filter(isAdult.negate().and(livesInPorto.negate()))
                .toList();
    }

    public boolean operationsAllMatchNameStartsWithMOrIsAdult() {
        return PEOPLE.stream()
                .allMatch(nameStartsWithM.or(isAdult));
    }
}
