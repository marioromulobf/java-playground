package com.mariofernandes.javapoc.sep.dpk04;

import java.util.List;
import java.util.stream.Stream;

public class DPK04Impl5 {
    List<String> countries = List.of("Usa", "Brazil", "Spain", "Italy", "France", "Germany");
    List<String> languages = List.of("English", "Portuguese", "Spanish", "Italian", "French", "German");

    public String patternMatcher(String country) {
        return Stream.iterate(0, i -> i < countries.size(), i -> i + 1)
                .filter(i -> countries.get(i).equals(country))
                .map(i -> languages.get(i))
                .findFirst()
                .orElse("Unknown");
    }

    public static void main(String[] args) {
        System.out.println("--> DPK 04 - Implementation 05 <--");
        DPK04Impl5 dkp04Impl5 = new DPK04Impl5();

        var result = dkp04Impl5.patternMatcher("Usa");
        System.out.println("patternMatcher(\"Usa\") -> " + result);
    }
}

