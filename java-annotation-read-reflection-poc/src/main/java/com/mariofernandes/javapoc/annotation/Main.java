package com.mariofernandes.javapoc.annotation;

public class Main {

    public static void main(String[] args) {
        System.out.println("=== Java Annotation - My own Annotations POC ===\n");
        try {
            Person person = new Person("Mario", "Brazil", 30, 666);
            Validator.validate(person);
            System.out.println("You are a valid person: " + person);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }

        try {
            Person person = new Person(null, null,-1, null);
            Validator.validate(person);
            System.out.println("You are a invalid person: " + person);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }

        try {
            Person person = new Person(null, null,-1, -1);
            Validator.validate(person);
            System.out.println("You are a invalid person: " + person);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
