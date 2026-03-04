package com.mariofernandes.javapoc.mockito.repository;

import com.mariofernandes.javapoc.mockito.model.Person;

import java.util.List;
import java.util.Optional;

public interface PersonRepository {

    Optional<Person> findById(Long id);

    List<Person> findAll();

    Person save(Person person);

    void deleteById(Long id);

    List<Person> findByNameContainingIgnoreCase(String name);
}
