package com.mariofernandes.javapoc.stream;

public record Person(String name, int age, String city) {
    public Person(String name, int age) {
        this(name, age, null);
    }

    @Override
    public String toString() {
        return "Person[name=" + name + ", age=" + age + (city != null ? ", city=" + city : "") + "]";
    }
}
