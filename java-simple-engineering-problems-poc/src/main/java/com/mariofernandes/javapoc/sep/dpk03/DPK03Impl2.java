package com.mariofernandes.javapoc.sep.dpk03;

import java.util.HashMap;
import java.util.Map;

public class DPK03Impl2 {

    private final Map<Integer, Person> mapIntegerKey = new HashMap<>();
    private final Map<String, Person> mapStringKey = new HashMap<>();

    public void add(Person person) {
        if (person == null) {
            return;
        }
        mapIntegerKey.put(person.id(), person);
        mapStringKey.put(person.name(), person);
        mapStringKey.put(person.email(), person);
    }

    public Person lookup(int key) {
        return mapIntegerKey.get(key);
    }

    public Person lookup(String key) {
        return mapStringKey.get(key);
    }

    public static void main(String[] args) {
        System.out.println("--> DPK 03 - Implementation 02 <--");
        DPK03Impl2 dkp03Impl2 = new DPK03Impl2();
        dkp03Impl2.add(new Person(1, "John", "john@john.john.com"));
        dkp03Impl2.add(new Person(2, "Mario", "mario@mail.com"));
        dkp03Impl2.add(new Person(3, "Romulo", "romulo@mail.com"));

        var result = dkp03Impl2.lookup(1);
        System.out.println("lookup(1) -> " + result.toString());

        var resultByName = dkp03Impl2.lookup("John");
        System.out.println("lookup(\"John\") -> " + resultByName.toString());

        var resultByMail = dkp03Impl2.lookup("john@john.john.com");
        System.out.println("lookup(\"john@john.john.com\") -> " + resultByMail.toString());
    }

    public record Person(int id, String name, String email) {}
}

