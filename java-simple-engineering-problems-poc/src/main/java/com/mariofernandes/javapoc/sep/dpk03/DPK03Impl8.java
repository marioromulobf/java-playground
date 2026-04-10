package com.mariofernandes.javapoc.sep.dpk03;

import java.util.HashMap;
import java.util.Map;

public class DPK03Impl8 {

    private final Map<Integer, String> mapIntegerKey = new HashMap<>();
    private final Map<String, String> mapStringKey = new HashMap<>();

    public void add(int key, String value) {
        mapIntegerKey.put(key, value);
    }

    public void add(String key, String value) {
        mapStringKey.put(key, value);
    }

    public String lookup(int key) {
        return mapIntegerKey.get(key);
    }

    public String lookup(String key) {
        var result = mapStringKey.get(key);

        if (result == null) {
            for (var entry : mapStringKey.entrySet()) {
                if (entry.getValue().equals(key)) {
                    return entry.getKey();
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println("--> DPK 03 - Implementation 08 <--");
        DPK03Impl8 dpk03Impl8 = new DPK03Impl8();
        dpk03Impl8.add(1, "John");
        dpk03Impl8.add("John", "john@john.john.com");
        dpk03Impl8.add(2, "Mario");
        dpk03Impl8.add("Mario", "mario@mail.com");
        dpk03Impl8.add(3, "Romulo");
        dpk03Impl8.add("Romulo", "romulo@mail.com");

        var result = dpk03Impl8.lookup(1);
        System.out.println("lookup(1) -> " + result);

        var resultByName = dpk03Impl8.lookup("John");
        System.out.println("lookup(\"John\") -> " + resultByName);

        var resultByMail = dpk03Impl8.lookup("john@john.john.com");
        System.out.println("lookup(\"john@john.john.com\") -> " + resultByMail);
    }
}

