package com.mariofernandes.javapoc.sep.dpk04;

import java.util.List;
import java.util.stream.Stream;

public class DPK04Impl2 {
    List<String> countries = List.of("Usa", "Brazil", "Spain", "Italy", "France", "Germany");
    String[] languages = {"English", "Portuguese", "Spanish", "Italian", "French", "German"};

    public String patternMatcher(String country) {
        return Stream.iterate(0, i -> i + 1)
                .limit(countries.size())
                .filter(i -> countries.get(i).equals(country))
                .map(i -> languages[i])
                .findFirst()
                .orElse("Unknown");
    }

    public static void main(String[] args) {
        System.out.println("--> DPK 04 - Implementation 02 <--");
        DPK04Impl2 dkp04Impl2 = new DPK04Impl2();

        var result = dkp04Impl2.patternMatcher("Usa");
        System.out.println("patternMatcher(\"Usa\") -> " + result);
    }
}

