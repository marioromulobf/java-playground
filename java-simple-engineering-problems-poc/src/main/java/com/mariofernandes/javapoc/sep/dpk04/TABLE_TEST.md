# Problem
This is a table test for *DPK04*:

**Given the following countries and languages:**
```
Usa -> English
Brazil -> Portuguese
Spain -> Spanish
Italy -> Italian
France -> French
Germany -> German
```
**Create a function that can return the language for a given country. You cannot use a hashmap or dictionary.**
```bash
pattern_matcher("Usa") -> "English"
```
**Refactor the code, can you do that without using IF statements?**
```bash
pattern_matcher("Usa") -> "English"
```

## Table Test - Implementation 1

1. Line 7: a variable `countries` of type Array of String is initialized with ["Usa", "Brazil", "Spain", "Italy", "France", "Germany"].
2. Line 8: a variable `languages` of type Array of String is initialized with ["English", "Portuguese", "Spanish", "Italian", "French", "German"].
3. Line 21 (main): the DPK04Impl1 class is instantiated.
4. Line 23 (main): the `patternMatcher` method is called with the input `Usa`.
5. Line 11 (patternMatcher): an infinite sequential order is started from 0 and incremented by 1.
6. Line 12 (patternMatcher): the limit of the sequential order is set to the length of the `countries` array.
7. Line 13 (patternMatcher): the current index of the sequential order is filtered to check if the country at that index matches the input `country`.
8. Line 14 (patternMatcher): if a match is found, the language at the same index is mapped.
9. Line 15 (patternMatcher): the first match is returned as the output.
10. Line 16 (patternMatcher): if no match is found, `Unknown` is returned.
11. Line 24 (main): the output "patternMatcher("Usa") -> English" is printed to the console.

## Table Test - Implementation 2

1. Line 7: a variable `countries` of type List of String is initialized with ["Usa", "Brazil", "Spain", "Italy", "France", "Germany"].
2. Line 8: a variable `languages` of type Array of String is initialized with ["English", "Portuguese", "Spanish", "Italian", "French", "German"].
3. Line 21 (main): the DPK04Impl2 class is instantiated.
4. Line 23 (main): the `patternMatcher` method is called with the input `Usa`.
5. Line 11 (patternMatcher): an infinite sequential order is started from 0 and a function or operation is applied to increment the index by 1.
6. Line 12 (patternMatcher): the limit of the sequential order is set to the length of the `countries` array.
7. Line 13 (patternMatcher): the current index in the sequence is filtered using a predicate that checks whether the country at that position in the `countries` list matches the input `country`.
8. Line 14 (patternMatcher): if a match is found, the language at the same index is mapped.
9. Line 15 (patternMatcher): the first match is returned as the output.
10. Line 16 (patternMatcher): if no match is found, `Unknown` is returned.
11. Line 24 (main): the output "patternMatcher("Usa") -> English" is printed to the console.

## Table Test - Implementation 3

1. Line 7: a variable `countries` of type List of String is initialized with ["Usa", "Brazil", "Spain", "Italy", "France", "Germany"].
2. Line 8: a variable `languages` of type List of String is initialized with ["English", "Portuguese", "Spanish", "Italian", "French", "German"].
3. Line 21 (main): the DPK04Impl3 class is instantiated.
4. Line 23 (main): the `patternMatcher` method is called with the input `Usa`.
5. Line 11 (patternMatcher): an infinite sequential order is started from 0 and a function or operation is applied to increment the index by 1.
6. Line 12 (patternMatcher): the limit of the sequential order is set to the size of the `countries` list.
7. Line 13 (patternMatcher): the current index in the sequence is filtered using a predicate that checks whether the country at that position in the `countries` list matches the input `country`.
8. Line 14 (patternMatcher): if a match is found, the language at the same position is mapped.
9. Line 15 (patternMatcher): the first match is returned as the output.
10. Line 16 (patternMatcher): if no match is found, `Unknown` is returned.
11. Line 24 (main): the output "patternMatcher("Usa") -> English" is printed to the console.

## Table Test - Implementation 4

1. Line 7: a variable `countries` of type Array of String is initialized with ["Usa", "Brazil", "Spain", "Italy", "France", "Germany"].
2. Line 8: a variable `languages` of type List of String is initialized with ["English", "Portuguese", "Spanish", "Italian", "French", "German"].
3. Line 21 (main): the DPK04Impl4 class is instantiated.
4. Line 23 (main): the `patternMatcher` method is called with the input `Usa`.
5. Line 11 (patternMatcher): an infinite sequential order is started from 0 and a function or operation is applied to increment the index by 1.
6. Line 12 (patternMatcher): the limit of the sequential order is set to the length of the `countries` Array.
7. Line 13 (patternMatcher): the current index in the sequence is filtered using a predicate that checks whether the country at that index in the `countries` array matches the input `country`.
8. Line 14 (patternMatcher): if a match is found, the language at the same position is mapped.
9. Line 15 (patternMatcher): the first match is returned as the output.
10. Line 16 (patternMatcher): if no match is found, `Unknown` is returned.
11. Line 24 (main): the output "patternMatcher("Usa") -> English" is printed to the console.

## Table Test - Implementation 5

1. Line 7: a variable `countries` of type List of String is initialized with ["Usa", "Brazil", "Spain", "Italy", "France", "Germany"].
2. Line 8: a variable `languages` of type List of String is initialized with ["English", "Portuguese", "Spanish", "Italian", "French", "German"].
3. Line 20 (main): the DPK04Impl5 class is instantiated.
4. Line 22 (main): the `patternMatcher` method is called with the input `Usa`.
5. Line 11 (patternMatcher): `Stream.iterate` produces a sequence starting at 0, uses a predicate to ensure the index remains less than the size of the `countries` list, and applies a function that increments the index by 1. 
6. Line 12 (patternMatcher): the current index in the sequence is filtered using a predicate that checks whether the country at that position in the `countries` list matches the input `country`.
7. Line 13 (patternMatcher): if a match is found, the language at the same position is mapped.
8. Line 14 (patternMatcher): the first match is returned as the output.
9. Line 15 (patternMatcher): if no match is found, `Unknown` is returned.
10. Line 23 (main): the output "patternMatcher("Usa") -> English" is printed to the console.

## Table Test - Implementation 6

1. Line 4: a variable `countryLanguage` of type String is initialized with "UsaEnglish,BrazilPortuguese,SpainSpanish,ItalyItalian,FranceFrench,GermanyGerman".
2. Line 18 (main): the DPK04Impl6 class is instantiated.
3. Line 20 (main): the `patternMatcher` method is called with the input `Usa`.
4. Line 7 (patternMatcher): a variable `index` of type int is initialized with the index of the first occurrence of the input `country` in the `countryLanguage` string.
5. Line 8 (patternMatcher): return the substring of `countryLanguage` starting from beginIndex (inclusive) to endIndex (exclusive). 
6. Line 9 (patternMatcher): the beginIndex is calculated as the index of the input `country` plus the length of the input `country`.
7. Line 10 (patternMatcher): check if the index of "," after the variable `index` is different from -1.
8. Line 11 (patternMatcher): if true, the endIndex is set to the index of "," after the variable `index`.
9. Line 12 (patternMatcher): if false, the endIndex is set to the length of the `countryLanguage` string.
10. Line 21 (main): the output "patternMatcher("Usa") -> English" is printed to the console.

## Table Test - Implementation 7

1. Line 6: a variable `countriesFirstCharacter` of type String is initialized with the first character of each country concatenated together, resulting in "UBSIFG".
2. Line 7: a variable `languages` of type List of String is initialized with ["English", "Portuguese", "Spanish", "Italian", "French", "German"].
3. Line 16 (main): the DPK04Impl7 class is instantiated.
4. Line 18 (main): the `patternMatcher` method is called with the input `Usa`.
5. Line 10 (patternMatcher): a variable `index` of type int is initialized with the index of the first occurrence of the first character of the input `country` in the `countriesFirstCharacter` string.
6. Line 11 (patternMatcher): return the language at the same index as the variable `index` in the `languages` list.
7. Line 19 (main): the output "patternMatcher("Usa") -> English" is printed to the console.

## Table Test - Implementation 8

1. Line 7: a variable `countries` of type List of Country is initialized with six Country objects, each containing a country name and its corresponding language.
2. Line 8: the first Country object is created with the name "Usa" and language "English".
3. Line 9: the second Country object is created with the name "Brazil" and language "Portuguese".
4. Line 10: the third Country object is created with the name "Spain" and language "Spanish".
5. Line 11: the fourth Country object is created with the name "Italy" and language "Italian".
6. Line 12: the fifth Country object is created with the name "France" and language "French".
7. Line 13: the sixth Country object is created with the name "Germany" and language "German".
8. Line 26 (main): the DPK04Impl8 class is instantiated.
9. Line 28 (main): the `patternMatcher` method is called with the input `Usa`.
10. Line 17 (patternMatcher): `Stream.iterate` produces a sequence starting at 0, uses a predicate to ensure the index remains less than the size of the `countries` list, and applies a function that increments the index by 1.
11. Line 18 (patternMatcher): the current index in the sequence is filtered using a predicate that checks whether the name of the Country object at that index in the `countries` list matches the input `country`.
12. Line 19 (patternMatcher): if a match is found, the language of the Country object at the same index is mapped.
13. Line 20 (patternMatcher): the first match is returned as the output.
14. Line 21 (patternMatcher): if no match is found, `Unknown` is returned.
15. Line 29 (main): the output "patternMatcher("Usa") -> English" is printed to the console.
