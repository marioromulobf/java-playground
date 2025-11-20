package com.mariofernandes.javapoc.functional;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;
import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;
import java.util.function.IntSupplier;
import java.util.function.LongSupplier;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class SupplierExamples {
    public static void basic() {
        System.out.println(" --- Basic Supplier --- ");
        Supplier<String> stringSupplier = () -> "Hello, My Constant Supplier!";
        IntSupplier dayOfMonthIntSupplier = () -> LocalDate.now().getDayOfMonth();
        LongSupplier timeInMillisLongSupplier = Calendar.getInstance()::getTimeInMillis;
        DoubleSupplier randomDoubleSupplier = Math::random;
        BooleanSupplier todayIsWeekendBooleanSupplier = () -> {
            int dayOfWeek = LocalDate.now().getDayOfWeek().getValue();
            return dayOfWeek == 6 || dayOfWeek == 7;
        };

        System.out.println("stringSupplier.get() = " + stringSupplier.get());

        System.out.println(" ---> IntSupplier ");
        System.out.println("dayOfMonthIntSupplier.getAsInt() = " + dayOfMonthIntSupplier.getAsInt());

        System.out.println(" ---> LongSupplier ");
        System.out.println("timeInMillisLongSupplier.getAsLong() = " + timeInMillisLongSupplier.getAsLong());

        System.out.println(" ---> DoubleSupplier ");
        System.out.println("randomDoubleSupplier.getAsDouble() = " + randomDoubleSupplier.getAsDouble());

        System.out.println(" ---> BooleanSupplier ");
        System.out.println("todayIsWeekendBooleanSupplier.getAsBoolean() = " + todayIsWeekendBooleanSupplier.getAsBoolean());
    }

    public static void whyDoNotWe() {
        System.out.println(" --- Suggestions --- ");
        Supplier<Person> personSingleton = new PersonSingletonSupplier<>(new PersonFactorySupplier());

        System.out.println("People:");
        List<Person> people = Stream.generate(personSingleton)
                        .parallel()
                        .limit(10)
                        .toList();
        people.forEach(System.out::println);

        Person firstPerson = people.getFirst();
        System.out.println("Are all person instances the same? " + people.stream().allMatch(firstPerson::equals));
        System.out.println(" --- --- - --- --- ");
    }

    static class PersonFactorySupplier implements Supplier<Person> {
        private final String name;
        private final int age;
        private final String country;

        public PersonFactorySupplier() {
            this.name = "Mario";
            this.age = 30;
            this.country = "Japan";
        }

        @Override
        public Person get() {
            return new Person(name, age, country);
        }
    }

    static class PersonSingletonSupplier<T> implements Supplier<T> {
        private final Supplier<T> factory;
        private T instance;
        private static int counter = 0;

        public PersonSingletonSupplier(Supplier<T> factory) {
            this.factory = factory;
        }

        @Override
        public synchronized T get() {
            if (instance == null) {
                System.out.println("Creating the instance");
                instance = factory.get();
            }
            counter++;
            System.out.println("Instance requested " + counter + " times");

            return instance;
        }
    }
}
