package com.mariofernandes.javapoc.reflection;

public class Person {

    //PUBLIC field
    public String publicField = "I am a public field";

    //PRIVATE fields
    private String name;
    private int age;

    //STATIC field
    private static int personCount = 0;

    //FINAL field
    private final String id;

    //Default constructor
    public Person() {
        this.id = "DEFAULT-" + System.currentTimeMillis();
        this.name = "John Doe";
        this.age = 30;
        personCount++;
    }

    //Parameterized constructor
    public Person(String name, int age) {
        this.id = "PERSON-" + System.currentTimeMillis();
        this.name = name;
        this.age = age;
        personCount++;
    }

    //Private constructor
    private Person(String name, int age, String email) {
        this.id = "PRIVATE-" + System.currentTimeMillis();
        this.name = "Private Person-" + name + ", Email: " + email;
        this.age = age;
        personCount++;
    }

    //Public methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        } else {
            System.out.println("Age cannot be negative.");
        }
    }

    public String getId() {
        return id;
    }

    //Private method
    private void getSecretInfo() {
        System.out.println("Secret: " + name + " is " + age + " years old.");
    }

    //Static method
    public static int getPersonCount() {
        return personCount;
    }
}