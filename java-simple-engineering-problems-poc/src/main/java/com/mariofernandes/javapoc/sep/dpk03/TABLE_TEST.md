# Problem
This is a table test for *DPK03*:

**Create a function that perform a lookup in a map for a given key you hould have id, name.**

```bash
lookup(1) -> "John"
```

**Refactor the code so you can lookup for email as well and get the name and vice versa.**

```bash
lookup("John") -> "john@john.jhon.com"
lookup("john@john.jhon.com") -> "John"
```

## Table Test - Implementation 1

1. Line 8: a variable `map` of type Map is instantiated.
2. Line 9: a variable `mapByName` of type Map is instantiated.
3. Line 10: a variable `mapByMail` of type Map is instantiated.
4. Line 34 (main): the DPK03Impl1 class is instantiated.
5. Line 35 (main): the `add` method is called with an instance of Person with `id=1`, `name=John` and, `email=john@john.john.com`.
6. Line 36 (main): the `add` method is called with an instance of Person with `id=2`, `name=Mario` and, `email=mario@mail.com`.
7. Line 37 (main): the `add` method is called with an instance of Person with `id=3`, `name=Romulo` and, `email=romulo@mail.com`.
8. Line 13-15 (add): if the input person is null, the flow is stopped with a return.
9. Line 16 (add): associates the input person as value with the person id as key in the variable `map` of type Map.
10. Line 17 (add): associates the input person as value with the person name as key in the variable `mapByName` of type Map.
11. Line 18 (add): associates the input person as value with the person email as key in the variable `mapByMail` of type Map.
12. Line 40 (main): the `lookup` method is called with the input `1`.
13. Line 22 (lookup): returns the value associated with the input `id`, as a key, in the variable `map` of type Map.
14. Line 41 (main): the output "lookup(1) -> John" is printed to the console.
15. Line 43 (main): the `lookupByName` method is called with the input `John`.
16. Line 26 (lookup): returns the value associated with the input `name`, as a key, in the variable `mapByName` of type Map.
17. Line 44 (main): the output "lookupByName(John) -> john@john.john.com" is printed to the console.
18. Line 46 (main): the `lookupByMail` method is called with the input `john@john.john.com`.
19. Line 30 (lookup): returns the value associated with the input `email`, as a key, in the variable `mapByMail` of type Map.
20. Line 47 (main): the output "lookupByMail(john@john.john.com) -> John" is printed to the console.
