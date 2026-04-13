package com.mariofernandes.javapoc.sep.dpk04;

import java.util.Optional;
import java.util.stream.Stream;

public class DPK04Impl1 {

    String[] countries = {"Usa", "Brazil", "Spain", "Italy", "France", "Germany"};
    String[] languages = {"English", "Portuguese", "Spanish", "Italian", "French", "German"};

    public String patternMatcher(String country) {
        return Stream.iterate(0, i -> i + 1)
                .limit(countries.length)
                .filter(i -> countries[i].equals(country))
                .map(i -> languages[i])
                .findFirst()
                .orElse("Unknown");
    }

    public static void main(String[] args) {
        System.out.println("--> DPK 04 - Implementation 01 <--");
        DPK04Impl1 dkp04Impl1 = new DPK04Impl1();

        var result = dkp04Impl1.patternMatcher("Usa");
        System.out.println("pattern_matcher(\"Usa\") -> " + result);
    }
}

