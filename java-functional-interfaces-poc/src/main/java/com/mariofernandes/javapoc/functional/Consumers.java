package com.mariofernandes.javapoc.functional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;
import java.util.function.ObjDoubleConsumer;
import java.util.function.ObjIntConsumer;
import java.util.function.ObjLongConsumer;

public class Consumers {

    public static void basic() {
        System.out.println(" --- Basic Consumer --- ");
        StringBuilder builder = new StringBuilder();

        Consumer<Integer> printInteger = i -> System.out.println("Number: " + i);
        Consumer<String> print = System.out::println;
        Consumer<String> appendToBuilder = s -> builder.append(s).append(" ");
        Consumer<List<Integer>> printOriginal = l -> System.out.println(" * Original: " + l);
        Consumer<List<Integer>> sort = Collections::sort;
        Consumer<List<Integer>> printSorted = l -> System.out.println(" * Sorted: " + l);
        Consumer<List<Integer>> reverse = Collections::reverse;
        Consumer<List<Integer>> printReversed = l -> System.out.println(" * Reversed: " + l);

        IntConsumer printIntAsDouble = i -> System.out.printf("Int as Double: %.2f\n", Double.valueOf(i));
        IntConsumer printIfIntIsPositiveOrNegative = i -> {
          if (i > 0) System.out.println(i + " is Positive");
          else if (i < 0) System.out.println(i + " is Negative");
        };

        LongConsumer printLongAsDouble = l -> System.out.printf("Long as Double: %.2f\n", Double.valueOf(l));
        LongConsumer printIfLongIsPositiveOrNegative = l -> {
            if (l > 0) System.out.println(l + " is Positive");
            else if (l < 0) System.out.println(l + " is Negative");
        };

        DoubleConsumer printDouble = d -> System.out.println("Double value: " + d);
        DoubleConsumer printIfDoubleIsPositiveOrNegative = d -> {
            if (d > 0) System.out.println(d + " is Positive");
            else if (d < 0) System.out.println(d + " is Negative");
        };

        System.out.print("printInteger.accept(13) -> ");
        printInteger.accept(13);

        System.out.println("appendTobBuilder.accept(\"It's\")");
        appendToBuilder.accept("It's");
        System.out.println("appendTobBuilder.accept(\"me\")");
        appendToBuilder.accept("me");
        System.out.println("appendTobBuilder.accept(\"Mario\")");
        appendToBuilder.accept("Mario");
        System.out.print("print.accept(builder.toString()) -> ");
        print.accept(builder.toString());

        System.out.println(" ---> Consumer Combining andThen ");
        System.out.println("printOriginal.andThen(sort).andThen(printSorted).andThen(reverse).andThen(printReversed).accept(Arrays.asList(5, 2, 8, 1, 9)):");
        printOriginal.andThen(sort).andThen(printSorted).andThen(reverse).andThen(printReversed).accept(Arrays.asList(5, 2, 8, 1, 9));

        System.out.println(" ---> IntConsumer ");
        System.out.print("printIntAsDouble.accept(10) -> ");
        printIntAsDouble.accept(10);
        System.out.println(" ---> IntConsumer Combining andThen ");
        System.out.println("printIntAsDouble.andThen(printIfIntIsPositiveOrNegative).accept(-10) -> ");
        printIntAsDouble.andThen(printIfIntIsPositiveOrNegative).accept(-10);

        System.out.println(" ---> LongConsumer ");
        System.out.print("printLongAsDouble.accept(666L) -> ");
        printLongAsDouble.accept(666L);
        System.out.println(" ---> LongConsumer Combining andThen ");
        System.out.println("printLongAsDouble.andThen(printIfLongIsPositiveOrNegative).accept(1000L) -> ");
        printLongAsDouble.andThen(printIfLongIsPositiveOrNegative).accept(1000L);

        System.out.println(" ---> DoubleConsumer ");
        System.out.println("printDouble.accept(Math.PI) -> ");
        printDouble.accept(Math.PI);
        System.out.println(" ---> DoubleConsumer Combining andThen ");
        System.out.println("printDouble.andThen(printIfDoubleIsPositiveOrNegative).accept(-Math.PI) -> ");
        printDouble.andThen(printIfDoubleIsPositiveOrNegative).accept(-Math.PI);
        System.out.println(" --- --- - --- --- ");
    }

    public static void biConsumer() {
        System.out.println(" --- BiConsumer Example --- ");
        BiConsumer<String, Integer> printNameAndAge = (name, age) -> System.out.println("Name: " + name + ", Age: " + age);
        BiConsumer<String, Integer> printIsAdult = (name, age) -> {
            if (age >= 18) {
                System.out.println(name + " is an Adult.");
            } else {
                System.out.println(name + " is a Minor.");
            }
        };
        ObjIntConsumer<String> printNameAndYearsOfExperience = (name, years) -> System.out.println("Name: " + name + ", Years of Experience: " + years);
        ObjLongConsumer<String> printNameAndId = (name, id) -> System.out.println("Name: " + name + ", ID: " + id);
        ObjDoubleConsumer<String> printNameAndSalary = (name, salary) -> System.out.println("Name: " + name + ", Salary: " + salary);

        System.out.print("printNameAndAge.accept(\"Mario\", 30) -> ");
        printNameAndAge.accept("Mario", 30);

        System.out.println(" ---> BiConsumer Combining andThen ");
        System.out.println("printNameAndAge.andThen(printIsAdult).accept(\"Maria\", 17) -> ");
        printNameAndAge.andThen(printIsAdult).accept("Maria", 17);
        System.out.println("printNameAndAge.andThen(printIsAdult).accept(\"Anna\", 22) -> ");
        printNameAndAge.andThen(printIsAdult).accept("Anna", 22);

        System.out.println(" ---> ObjIntConsumer ");
        System.out.print("printNameAndYearsOfExperience.accept(\"Luigi\", 5) -> ");
        printNameAndYearsOfExperience.accept("Luigi", 5);

        System.out.println(" ---> ObjLongConsumer ");
        System.out.print("printNameAndId.accept(\"Romulo\", 123456789L) -> ");
        printNameAndId.accept("Romulo", 123456789L);

        System.out.println(" ---> ObjDoubleConsumer ");
        System.out.print("printNameAndSalary.accept(\"Luigi\", 55000.50) -> ");
        printNameAndSalary.accept("Luigi", 55000.50);

        System.out.println(" --- --- - --- --- ");
    }

    public static void whyDoNotWe() {
        System.out.println(" --- Suggestions --- ");
        Map<String, List<Person>> validations = new HashMap<>();
        BiConsumer<Person, String> errorLogger = (p, m) -> System.out.printf("[ERROR] %s: %s\n", m, p);
        Consumer<Person> validatePerson = person -> {
            if (person.getName() == null || person.getName().isBlank()) {
                validations.computeIfAbsent("Invalid Name", k -> new ArrayList<>()).add(person);
                errorLogger.accept(person, "Invalid Name");
            }
            if (person.getAge() < 0 || person.getAge() > 130) {
                validations.computeIfAbsent("Invalid Age", k -> new ArrayList<>()).add(person);
                errorLogger.accept(person, "Invalid Age");
            }
            if (person.getCountry() == null || person.getCountry().isBlank()) {
                validations.computeIfAbsent("Invalid Country", k -> new ArrayList<>()).add(person);
                errorLogger.accept(person, "Invalid Country");
            }
        };
        BiConsumer<List<Person>, Map<String, List<Person>>> generateReport = (peopleList, validationPeople) -> {
            System.out.println("\n === Report === ");
            System.out.println("Total People Processed: " + peopleList.size());
            validationPeople.forEach((issue, persons) -> {
                System.out.printf(" - Total %s People: %s\n", issue, persons.size());
            });
            double avgAge = peopleList.stream()
                    .mapToInt(Person::getAge)
                    .average()
                    .orElse(0.0);
            System.out.printf("\nAverage Age of People: %.2f\n", avgAge);
            System.out.println(" === End of Report === ");
        };
        List<Person> people = List.of(
                new Person("Mario", 30, "Brazil"),
                new Person("Anne", 25, "USA"),
                new Person("Joao", 15, "Brazil"),
                new Person("Maria", 70, "Portugal"),
                new Person("", "South Korea"),
                new Person("Luigi", -33, null),
                new Person("Maui", 1000, "Hawaii")
        );
        System.out.println("People:");
        people.forEach(System.out::println);
        System.out.println("\nLog validation People:");
        people.forEach(validatePerson);
        generateReport.accept(people, validations);

        System.out.println(" --- --- - --- --- ");
    }
}
