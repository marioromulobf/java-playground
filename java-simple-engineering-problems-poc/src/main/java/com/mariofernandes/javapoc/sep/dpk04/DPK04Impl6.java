package com.mariofernandes.javapoc.sep.dpk04;

public class DPK04Impl6 {

    String countryLanguage = "UsaEnglish,BrazilPortuguese,SpainSpanish,ItalyItalian,FranceFrench,GermanyGerman";

    public String patternMatcher(String country) {
        int index = countryLanguage.indexOf(country);
        return countryLanguage.substring(
                index + country.length(),
                countryLanguage.indexOf(",", index) != -1
                        ? countryLanguage.indexOf(",", index)
                        : countryLanguage.length()
        );
    }

    public static void main(String[] args) {
        System.out.println("--> DPK 04 - Implementation 06 <--");
        DPK04Impl6 dkp04Impl6 = new DPK04Impl6();

        var result = dkp04Impl6.patternMatcher("Usa");
        System.out.println("pattern_matcher(\"Usa\") -> " + result);
    }
}

