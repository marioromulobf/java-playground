package com.mariofernandes.javapoc.sep.dpk04;

import java.util.List;

public class DPK04Impl7 {

    String countriesFirstCharacter = "UBSIFG";
    List<String> languages = List.of("English", "Portuguese", "Spanish", "Italian", "French", "German");

    public String patternMatcher(String country) {
        int i = countriesFirstCharacter.indexOf(country.charAt(0));
        return languages.get(i);
    }

    public static void main(String[] args) {
        System.out.println("--> DPK 04 - Implementation 07 <--");
        DPK04Impl7 dkp04Impl7 = new DPK04Impl7();

        var result = dkp04Impl7.patternMatcher("Usa");
        System.out.println("pattern_matcher(\"Usa\") -> " + result);
    }
}

