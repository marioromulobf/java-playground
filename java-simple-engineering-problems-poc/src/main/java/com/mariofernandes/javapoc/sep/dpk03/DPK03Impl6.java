package com.mariofernandes.javapoc.sep.dpk03;

import java.util.HashMap;
import java.util.Map;

public class DPK03Impl6 {

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
        return mapStringKey.get(key);
    }

    public static void main(String[] args) {
        System.out.println("--> DPK 03 - Implementation 06 <--");
        DPK03Impl6 dpk03Impl6 = new DPK03Impl6();
        dpk03Impl6.add(1, "John");
        dpk03Impl6.add("John", "john@john.john.com");
        dpk03Impl6.add("john@john.john.com", "John");
        dpk03Impl6.add(2, "Mario");
        dpk03Impl6.add("Mario", "mario@mail.com");
        dpk03Impl6.add("mario@mail.com", "Mario");
        dpk03Impl6.add(3, "Romulo");
        dpk03Impl6.add("Romulo", "romulo@mail.com");
        dpk03Impl6.add("romulo@mail.com", "Romulo");

        var result = dpk03Impl6.lookup(1);
        System.out.println("lookup(1) -> " + result);

        var resultByName = dpk03Impl6.lookup("John");
        System.out.println("lookup(\"John\") -> " + resultByName);

        var resultByMail = dpk03Impl6.lookup("john@john.john.com");
        System.out.println("lookup(\"john@john.john.com\") -> " + resultByMail);
    }
}

