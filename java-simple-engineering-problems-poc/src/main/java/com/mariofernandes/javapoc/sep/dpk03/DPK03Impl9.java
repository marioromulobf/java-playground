package com.mariofernandes.javapoc.sep.dpk03;

import java.util.HashMap;
import java.util.Map;

public class DPK03Impl9 {

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
            for (var entryKey : mapStringKey.keySet()) {
                if (mapStringKey.get(entryKey).equals(key)) {
                    return entryKey;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println("--> DPK 03 - Implementation 09 <--");
        DPK03Impl9 dpk03Impl9 = new DPK03Impl9();
        dpk03Impl9.add(1, "John");
        dpk03Impl9.add("John", "john@john.john.com");
        dpk03Impl9.add(2, "Mario");
        dpk03Impl9.add("Mario", "mario@mail.com");
        dpk03Impl9.add(3, "Romulo");
        dpk03Impl9.add("Romulo", "romulo@mail.com");

        var result = dpk03Impl9.lookup(1);
        System.out.println("lookup(1) -> " + result);

        var resultByName = dpk03Impl9.lookup("John");
        System.out.println("lookup(\"John\") -> " + resultByName);

        var resultByMail = dpk03Impl9.lookup("john@john.john.com");
        System.out.println("lookup(\"john@john.john.com\") -> " + resultByMail);
    }
}

