package com.mariofernandes.javapoc.sep.dpk03;

import java.util.HashMap;
import java.util.Map;

public class DPK03Impl1 {

    private final Map<Integer, Person> map = new HashMap<>();
    private final Map<String, Person> mapByName = new HashMap<>();
    private final Map<String, Person> mapByMail = new HashMap<>();

    public void add(Person person) {
        if (person != null) {
            map.put(person.id(), person);
            mapByName.put(person.name(), person);
            mapByMail.put(person.email(), person);
        }
    }

    public Person lookup(int id) {
        return map.get(id);
    }

    public Person lookupByName(String name) {
        return mapByName.get(name);
    }

    public Person lookupByMail(String email) {
        return mapByMail.get(email);
    }

    public static void main(String[] args) {
        System.out.println("--> DPK 03 - Implementation 01 <--");
        DPK03Impl1 dkp03Impl1 = new DPK03Impl1();
        dkp03Impl1.add(new Person(1, "John", "john@john.john.com"));
        dkp03Impl1.add(new Person(2, "Mario", "mario@mail.com"));
        dkp03Impl1.add(new Person(3, "Romulo", "romulo@mail.com"));

        var result = dkp03Impl1.lookup(1);
        var resultByName = dkp03Impl1.lookupByName("John");
        var resultByMail = dkp03Impl1.lookupByMail("john@john.john.com");

        System.out.println("lookup(1) -> " + result.name());
        System.out.println("lookup(\"John\") -> " + resultByName.email());
        System.out.println("lookup(\"john@john.john.com\") -> " + resultByMail.name());
    }

    public record Person(int id, String name, String email) {}
}

