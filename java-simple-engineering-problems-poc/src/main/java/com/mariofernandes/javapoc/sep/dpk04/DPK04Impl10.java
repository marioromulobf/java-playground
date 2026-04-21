package com.mariofernandes.javapoc.sep.dpk04;

import java.util.List;

public class DPK04Impl10 {
    List<Country> countries = List.of(
            new Country("Usa", "English"),
            new Country("Brazil", "Portuguese"),
            new Country("Spain", "Spanish"),
            new Country("Italy", "Italian"),
            new Country("France", "French"),
            new Country("Germany", "German")
    );

    public String patternMatcher(String country) {
        return countries.stream()
                .filter(item -> item.name().equals(country))
                .map(Country::language)
                .findFirst()
                .orElse("Unknown");
    }

    public static void main(String[] args) {
        System.out.println("--> DPK 04 - Implementation 10 <--");
        DPK04Impl10 dkp04Impl10 = new DPK04Impl10();

        var result = dkp04Impl10.patternMatcher("Usa");
        System.out.println("patternMatcher(\"Usa\") -> " + result);
    }

    public record Country(String name, String language) {}
}

