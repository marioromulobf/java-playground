package com.mariofernandes.javapoc.stream;

import java.util.List;
import java.util.stream.Stream;

public class Lists {
    public static void streams() {
        List<String> names = List.of("Mario", "Ana", "Pedro", "Carla", "Maria");
        names.stream()
             .filter(name -> name.startsWith("M"))
             .map(String::toUpperCase)
             .forEach(System.out::println);

        names.stream()
             .sorted()
             .forEach(System.out::println);

        Stream.of(names).forEach(System.out::println);
        Stream.of(names).sorted().forEach(System.out::println);
    }
}
