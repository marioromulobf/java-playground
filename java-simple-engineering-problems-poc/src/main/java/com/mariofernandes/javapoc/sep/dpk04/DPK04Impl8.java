package com.mariofernandes.javapoc.sep.dpk04;

import java.util.List;
import java.util.stream.Stream;

public class DPK04Impl8 {
    List<Country> countries = List.of(
            new Country("Usa", "English"),
            new Country("Brazil", "Portuguese"),
            new Country("Spain", "Spanish"),
            new Country("Italy", "Italian"),
            new Country("France", "French"),
            new Country("Germany", "German")
    );

    public String patternMatcher(String country) {
        return Stream.iterate(0, i -> i < countries.size(), i -> i + 1)
                .filter(i -> countries.get(i).name().equals(country))
                .map(i -> countries.get(i).language())
                .findFirst()
                .orElse("Unknown");
    }

    public static void main(String[] args) {
        System.out.println("--> DPK 04 - Implementation 08 <--");
        DPK04Impl8 dkp04Impl8 = new DPK04Impl8();

        var result = dkp04Impl8.patternMatcher("Usa");
        System.out.println("patternMatcher(\"Usa\") -> " + result);
    }

    public record Country(String name, String language) {}
}

