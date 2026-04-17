package com.mariofernandes.javapoc.sep.dpk04;

import java.util.stream.Stream;

public class DPK04Impl9 {
    Country[] countries = {
            new Country("Usa", "English"),
            new Country("Brazil", "Portuguese"),
            new Country("Spain", "Spanish"),
            new Country("Italy", "Italian"),
            new Country("France", "French"),
            new Country("Germany", "German")
    };

    public String patternMatcher(String country) {
        return Stream.of(countries)
                .filter(item -> item.country().equals(country))
                .map(Country::language)
                .findFirst()
                .orElse("Unknown");
    }

    public static void main(String[] args) {
        System.out.println("--> DPK 04 - Implementation 09 <--");
        DPK04Impl9 dkp04Impl9 = new DPK04Impl9();

        var result = dkp04Impl9.patternMatcher("Usa");
        System.out.println("pattern_matcher(\"Usa\") -> " + result);
    }

    public record Country(String country, String language) {}
}

