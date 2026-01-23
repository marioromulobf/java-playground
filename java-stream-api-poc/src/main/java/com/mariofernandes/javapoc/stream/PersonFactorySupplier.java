package com.mariofernandes.javapoc.stream;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;

public class PersonFactorySupplier implements Supplier<Person> {
    public static final String[] NAMES = {"Mario", "Ana", "Pedro", "Carla", "Maria"};
    public static final String[] CITIES = {"Lisbon", "Porto", "Coimbra", "Braga", "Faro"};

    public PersonFactorySupplier() {
    }

    @Override
    public Person get() {
        return new Person(
                NAMES[ThreadLocalRandom.current().nextInt(0, NAMES.length)],
                ThreadLocalRandom.current().nextInt(1, 111),
                CITIES[ThreadLocalRandom.current().nextInt(0, CITIES.length)]
        );
    }
}
