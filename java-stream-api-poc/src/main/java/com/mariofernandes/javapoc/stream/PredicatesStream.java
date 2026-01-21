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

    public boolean operationsAnyMatchNameStartsWithMAndLivesInPorto() {
        return PEOPLE.stream()
                .anyMatch(nameStartsWithM.and(livesInPorto));
    }

    public boolean operationsNoneMatchNotIsAdultAndLivesInPortoAndNameStartsWithM() {
        return PEOPLE.stream()
                .noneMatch(isAdult.negate().and(livesInPorto).and(nameStartsWithM));
    }

    public List<Person> operationsDropWhileIsAdult() {
        return PEOPLE.stream()
                .dropWhile(isAdult)
                .toList();
    }

    public List<Person> operationsTakeWhileIsAdult() {
        return PEOPLE.stream()
                .takeWhile(isAdult)
                .toList();
    }

    public static void run() {
        PredicatesStream predicatesStream = new PredicatesStream();

        System.out.println("People List: ");
        PEOPLE.forEach(person -> System.out.println(" - " + person));

        System.out.println("Operations: Predicates in Filter (Is not Adult and not Lives In Porto) -> Results: ");
        predicatesStream.operationsFilterPredicatesIsNotAdultAndNotLivesInPorto()
                .forEach(person -> System.out.println(" - " + person));

        System.out.println("Operations: Predicates in All Match (Name starts With 'M' or Is Adult) -> Result: "
                + predicatesStream.operationsAllMatchNameStartsWithMOrIsAdult());

        System.out.println("Operations: Predicates in Any Match (Name starts With 'M' and Lives In Porto) -> Result: "
                + predicatesStream.operationsAnyMatchNameStartsWithMAndLivesInPorto());

        System.out.println("Operations: Predicates in None Match (Is not Adult and Lives In Porto and Name starts With 'M') -> Result: "
                + predicatesStream.operationsNoneMatchNotIsAdultAndLivesInPortoAndNameStartsWithM());

        System.out.println("Operations: Predicates in Drop While (Is Adult) -> Results: ");
        predicatesStream.operationsDropWhileIsAdult().forEach(person -> System.out.println(" - " + person));

        System.out.println("Operations: Predicates in Take While (Is Adult) -> Results: ");
        predicatesStream.operationsTakeWhileIsAdult().forEach(person -> System.out.println(" - " + person));
    }
}
