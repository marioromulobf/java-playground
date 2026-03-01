package com.mariofernandes.javapoc.annotation;

public class Person {

    @NotBlank
    private String name;

    @NotBlank(message = "Country is required")
    private String country;

    @Range(min = 0, max = 99)
    private int age;

    @Range(min = 0, message = "LuckyNumber should be valid")
    @NotBlank
    private Integer luckyNumber;

    public Person(String name, String country, int age, Integer luckyNumber) {
        this.name = name;
        this.country = country;
        this.age = age;
        this.luckyNumber = luckyNumber;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public int getAge() {
        return age;
    }

    public Integer getLuckyNumber() {
        return luckyNumber;
    }

    @Override
    public String toString() {
        return "{name: " + name +
                ", country: " + country +
                ", age: " + age +
                ", luckyNumber: " + luckyNumber +
                "}";
    }
}
