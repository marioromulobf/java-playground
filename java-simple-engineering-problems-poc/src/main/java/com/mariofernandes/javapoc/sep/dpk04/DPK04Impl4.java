package com.mariofernandes.javapoc.sep.dpk04;

import java.util.List;
import java.util.stream.Stream;

public class DPK04Impl4 {
    String[] countries = {"Usa", "Brazil", "Spain", "Italy", "France", "Germany"};
    List<String> languages = List.of("English", "Portuguese", "Spanish", "Italian", "French", "German");

    public String patternMatcher(String country) {
        return Stream.iterate(0, i -> i + 1)
                .limit(countries.length)
                .filter(i -> countries[i].equals(country))
                .map(i -> languages.get(i))
                .findFirst()
                .orElse("Unknown");
    }

    public static void main(String[] args) {
        System.out.println("--> DPK 04 - Implementation 04 <--");
        DPK04Impl4 dkp04Impl4 = new DPK04Impl4();

        var result = dkp04Impl4.patternMatcher("Usa");
        System.out.println("patternMatcher(\"Usa\") -> " + result);
    }
}

