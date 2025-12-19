package com.mariofernandes.javapoc.stream;

import java.util.List;
import java.util.stream.Stream;

public class Lists {
    public static void streams() {
        List<String> names = List.of("Mario", "Ana", "Pedro", "Mario", "Carla", "Maria");
        System.out.println("List of names: ");
        names.forEach(name -> System.out.println(" - " + name));

        System.out.println("Sorted, limit by 3 and forEach of names (Collection stream): ");
        names.stream()
                .sorted()
                .limit(3)
                .forEach(name -> System.out.println(" - " + name));

        System.out.println("Sorted, skip by 3 and forEach of names (Collection stream): ");
        names.stream()
                .sorted()
                .skip(3)
                .forEach(name -> System.out.println(" - " + name));

        System.out.println("Distinct and forEach of names (Collection stream): ");
        names.stream()
                .distinct()
                .forEach(name -> System.out.println(" - " + name));

        System.out.print("max(String::compareTo) of names (Collection stream): ");
        names.stream()
                .max(String::compareTo)
                .ifPresent(System.out::println);

        System.out.print("min(String::compareTo) of names (Collection stream): ");
        names.stream()
                .min(String::compareTo)
                .ifPresent(System.out::println);

        System.out.println("Using Stream.of(List) and foreach: ");
        Stream.of(names).forEach(name -> System.out.println(" - " + name));

        System.out.println("Using Stream.of(List.toArray) and foreach: ");
        Stream.of(names.toArray()).forEach(name -> System.out.println(" - " + name));

        System.out.println("Using Stream.of(List.toArray), sorted and foreach: ");
        Stream.of(names.toArray()).sorted().forEach(name -> System.out.println(" - " + name));
    }
}
