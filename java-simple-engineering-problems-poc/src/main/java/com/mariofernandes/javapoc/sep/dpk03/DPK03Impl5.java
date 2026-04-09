package com.mariofernandes.javapoc.sep.dpk03;

import java.util.HashMap;
import java.util.Map;

public class DPK03Impl5 {

    private final Map<Integer, String> mapIntegerKey = new HashMap<>();
    private final Map<String, String> mapStringKey = new HashMap<>();

    public void add(int id, String name) {
        mapIntegerKey.put(id, name);
    }

    public void add(String name, String mail) {
        mapStringKey.put(name, mail);
        mapStringKey.put(mail, name);
    }

    public String lookup(int key) {
        return mapIntegerKey.get(key);
    }

    public String lookup(String key) {
        return mapStringKey.get(key);
    }

    public static void main(String[] args) {
        System.out.println("--> DPK 03 - Implementation 04 <--");
        DPK03Impl5 dpk03Impl5 = new DPK03Impl5();
        dpk03Impl5.add(1, "John");
        dpk03Impl5.add("John", "john@john.john.com");
        dpk03Impl5.add(2, "Mario");
        dpk03Impl5.add("Mario", "mario@mail.com");
        dpk03Impl5.add(3, "Romulo");
        dpk03Impl5.add("Romulo", "romulo@mail.com");

        var result = dpk03Impl5.lookup(1);
        System.out.println("lookup(1) -> " + result);

        var resultByName = dpk03Impl5.lookup("John");
        System.out.println("lookup(\"John\") -> " + resultByName);

        var resultByMail = dpk03Impl5.lookup("john@john.john.com");
        System.out.println("lookup(\"john@john.john.com\") -> " + resultByMail);
    }
}

