package com.mariofernandes.javapoc.stream;

import java.util.List;
import java.util.stream.Stream;

public class Lists {

    public static final List<String> NAMES = List.of("Mario", "Ana", "Pedro", "Mario", "Carla", "Maria");

    public Lists() {}

    public List<String> collectionStreamSortedLimitToList() {
        return NAMES.stream()
                .sorted()
                .limit(3)
                .toList();
    }

    public List<String> collectionParallelStreamSortedSkipToList() {
        // This implementation is not recommended, just for demonstration purposes.
        // The use of sorted() and skip() introduces stateful operations that can
        // incur significant overhead in a parallel stream.
        return NAMES.parallelStream()
                .sorted()
                .skip(3)
                .toList();
    }

    public static void streams() {

        System.out.println("List of names: ");
        NAMES.forEach(name -> System.out.println(" - " + name));

        System.out.println("Sorted, limit by 3 and forEach of names (Collection stream): ");
        NAMES.stream()
                .sorted()
                .limit(3)
                .forEach(name -> System.out.println(" - " + name));

        System.out.println("Sorted, skip by 3, parallel and forEach of names (Collection stream): ");
        NAMES.stream()
                .sorted()
                .skip(3)
                .parallel()
                .forEach(name -> System.out.println(" - " + name));

        System.out.println("Distinct and forEach of names (Collection stream): ");
        NAMES.stream()
                .distinct()
                .forEach(name -> System.out.println(" - " + name));

        System.out.print("max(String::compareTo) of names (Collection stream): ");
        NAMES.stream()
                .max(String::compareTo)
                .ifPresent(System.out::println);

        System.out.print("min(String::compareTo) of names (Collection stream): ");
        NAMES.stream()
                .min(String::compareTo)
                .ifPresent(System.out::println);

        System.out.println("Using Stream.of(List) and foreach: ");
        Stream.of(NAMES).forEach(name -> System.out.println(" - " + name));

        System.out.println("Using Stream.of(List.toArray) and foreach: ");
        Stream.of(NAMES.toArray()).forEach(name -> System.out.println(" - " + name));

        System.out.println("Using Stream.of(List.toArray), sorted and foreach: ");
        Stream.of(NAMES.toArray()).sorted().forEach(name -> System.out.println(" - " + name));
    }
}
