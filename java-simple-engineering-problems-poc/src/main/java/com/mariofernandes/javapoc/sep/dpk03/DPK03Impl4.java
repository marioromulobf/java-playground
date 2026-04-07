package com.mariofernandes.javapoc.sep.dpk03;

import java.util.HashMap;
import java.util.Map;

public class DPK03Impl4 {

    private final Map<Integer, Person> mapIntegerKey = new HashMap<>();
    private final Map<String, Integer> mapStringKey = new HashMap<>();

    public void add(Person person) {
        if (person == null) {
            return;
        }
        mapIntegerKey.put(person.id(), person);
        mapStringKey.put(person.name(), person.id());
        mapStringKey.put(person.email(), person.id());
    }

    public Person lookup(int key) {
        return mapIntegerKey.get(key);
    }

    public Person lookup(String key) {
        var id = mapStringKey.get(key);
        return mapIntegerKey.get(id);
    }

    public static void main(String[] args) {
        System.out.println("--> DPK 03 - Implementation 04 <--");
        DPK03Impl4 dpk03Impl4 = new DPK03Impl4();
        dpk03Impl4.add(new Person(1, "John", "john@john.john.com"));
        dpk03Impl4.add(new Person(2, "Mario", "mario@mail.com"));
        dpk03Impl4.add(new Person(3, "Romulo", "romulo@mail.com"));

        var result = dpk03Impl4.lookup(1);
        System.out.println("lookup(1) -> " + result.toString());

        var resultByName = dpk03Impl4.lookup("John");
        System.out.println("lookup(\"John\") -> " + resultByName.toString());

        var resultByMail = dpk03Impl4.lookup("john@john.john.com");
        System.out.println("lookup(\"john@john.john.com\") -> " + resultByMail.toString());
    }

    public record Person(int id, String name, String email) {}
}

