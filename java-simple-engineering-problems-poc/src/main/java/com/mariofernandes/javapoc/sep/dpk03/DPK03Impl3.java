package com.mariofernandes.javapoc.sep.dpk03;

import java.util.HashMap;
import java.util.Map;

public class DPK03Impl3 {

    private final Map<Object, Person> map = new HashMap<>();

    public void add(Person person) {
        if (person == null) {
            return;
        }
        map.put(person.id(), person);
        map.put(person.name(), person);
        map.put(person.email(), person);
    }

    public Person lookup(int key) {
        return map.get(key);
    }

    public Person lookup(String key) {
        return map.get(key);
    }

    public static void main(String[] args) {
        System.out.println("--> DPK 03 - Implementation 03 <--");
        DPK03Impl3 dkp03Impl3 = new DPK03Impl3();
        dkp03Impl3.add(new Person(1, "John", "john@john.john.com"));
        dkp03Impl3.add(new Person(2, "Mario", "mario@mail.com"));
        dkp03Impl3.add(new Person(3, "Romulo", "romulo@mail.com"));

        var result = dkp03Impl3.lookup(1);
        System.out.println("lookup(1) -> " + result.toString());

        var resultByName = dkp03Impl3.lookup("John");
        System.out.println("lookup(\"John\") -> " + resultByName.toString());

        var resultByMail = dkp03Impl3.lookup("john@john.john.com");
        System.out.println("lookup(\"john@john.john.com\") -> " + resultByMail.toString());
    }

    public record Person(int id, String name, String email) {}
}

