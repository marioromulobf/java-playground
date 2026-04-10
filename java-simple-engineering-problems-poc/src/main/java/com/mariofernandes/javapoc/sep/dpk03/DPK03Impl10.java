package com.mariofernandes.javapoc.sep.dpk03;

import java.util.HashMap;
import java.util.Map;

public class DPK03Impl10 {

    private final Map<Integer, Person> map = new HashMap<>();

    public void add(Person person) {
        if (person == null) {
            return;
        }
        map.put(person.id(), person);
    }

    public Person lookup(int key) {
        return map.get(key);
    }

    public Person lookupByName(String name) {
        for (var entry : map.entrySet()) {
            if (entry.getValue().name().equals(name)) {
                return entry.getValue();
            }
        }
        return null;
    }

    public Person lookupByMail(String mail) {
        for (var entry : map.entrySet()) {
            if (entry.getValue().email().equals(mail)) {
                return entry.getValue();
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println("--> DPK 03 - Implementation 10 <--");
        DPK03Impl10 dpk03Impl10 = new DPK03Impl10();
        dpk03Impl10.add(new Person(1, "John", "john@john.john.com"));
        dpk03Impl10.add(new Person(2, "Mario", "mario@mail.com"));
        dpk03Impl10.add(new Person(3, "Romulo", "romulo@mail.com"));

        var result = dpk03Impl10.lookup(1);
        System.out.println("lookup(1) -> " + result.toString());

        var resultByName = dpk03Impl10.lookupByName("John");
        System.out.println("lookup(\"John\") -> " + resultByName.toString());

        var resultByMail = dpk03Impl10.lookupByMail("john@john.john.com");
        System.out.println("lookup(\"john@john.john.com\") -> " + resultByMail.toString());
    }

    public record Person(int id, String name, String email) {}
}

