package com.mariofernandes.javapoc.sep.dpk15;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class DPK15Impl9 {

    static class Person {
        private final String name;
        private final int age;

        public Person(String name, int age) {
            if (name == null || name.isEmpty() || age < 0) {
                throw new IllegalArgumentException();
            }

            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        @Override
        public final boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Person person)) return false;
            return age == person.age
                    && Objects.equals(name, person.name);
        }

        @Override
        public final int hashCode() {
            // same as Objects.hash(name, age);
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + age;
            return result;
        }
    }

    static class SocialNetwork {
        private final Set<Person> people;
        private final Map<Person, Set<Person>> friendships;

        public SocialNetwork() {
            this.people = new HashSet<>();
            this.friendships = new HashMap<>();
        }

        public void addPerson(Person... person) {
            if (person == null) {
                return;
            }

            Collections.addAll(people, person);
        }

        public Person getMostPopularPerson() {
            return people.stream()
                    .max((p1, p2) -> Integer.compare(friendships.get(p1).size(), friendships.get(p2).size()))
                    .orElse(null);
        }

        public Person getLoneliestPerson() {
            return people.stream()
                    .min((p1, p2) -> Integer.compare(friendships.get(p1).size(), friendships.get(p2).size()))
                    .orElse(null);
        }

        public Set<Person> getFriends(Person person) {
            validate(person);

            return Set.copyOf(friendships.getOrDefault(person, Collections.emptySet()));
        }

        public Optional<Person> getOldestFriend(Person person) {
            validate(person);

            return friendships.getOrDefault(person, Collections.emptySet()).stream()
                    .max((f1, f2) -> Integer.compare(f1.getAge(), f2.getAge()));
        }

        public Person getPersonWithOldestFriend() {
            return people.stream()
                    .max((p1, p2) -> Integer.compare(
                            getOldestFriend(p1).map(Person::getAge).orElse(-1),
                            getOldestFriend(p2).map(Person::getAge).orElse(-1)
                    ))
                    .orElse(null);
        }

        public List<Person> getPeople() {
            return List.copyOf(people);
        }

        public void makeFriends(Person person, Person friend) {
            validate(person);
            validate(friend);

            friendships.computeIfAbsent(person, f -> new HashSet<>()).add(friend);
            friendships.computeIfAbsent(friend, f -> new HashSet<>()).add(person);
        }

        public void removeFriendship(Person person, Person friend) {
            validate(person);
            validate(friend);

            friendships.getOrDefault(person, Collections.emptySet()).remove(friend);
            friendships.getOrDefault(friend, Collections.emptySet()).remove(person);
        }

        private void validate(Person person) {
            if  (person == null || !people.contains(person)) {
                throw new IllegalArgumentException();
            }
        }

        public void printNetwork() {
            for (Person person : people) {
                System.out.println(person.getName() + " (" + person.getAge() + ") has " +
                        friendships.getOrDefault(person, Collections.emptySet()).size() + " friends: ");
                for (Person friend : friendships.getOrDefault(person, Collections.emptySet())) {
                    System.out.println("  - " + friend.getName());
                }
                System.out.println(" --//-- ");
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("--> DPK 15 - Implementation 09 <--");
        var mario = new Person("Mario", 22);
        var romulo = new Person("Romulo", 23);
        var maria = new Person("Maria", 24);
        var jurubeba = new Person("Jurubeba", 25);
        var monica = new Person("Monica", 26);
        var cebolinha = new Person("Cebolinha", 27);
        var cascao = new Person("Casao", 28);
        var magalina = new Person("Magalina", 29);
        var carlos = new Person("Carlos", 30);
        var creusa = new Person("Creusa", 31);
        var luffy = new Person("Luffy", 32);
        var nami = new Person("Nami", 33);
        var zoro = new Person("Zoro", 34);
        var sanji = new Person("Sanji", 35);
        var usopp = new Person("Usopp", 36);
        var franky = new Person("Franky", 37);
        var brook = new Person("Brook", 38);

        var socialNetwork = new SocialNetwork();
        socialNetwork.addPerson(mario, romulo, maria, jurubeba, monica, cebolinha, cascao,
                magalina, carlos, creusa, luffy, nami, zoro, sanji, usopp, franky, brook);

        socialNetwork.makeFriends(mario, romulo);
        socialNetwork.makeFriends(mario, maria);
        socialNetwork.makeFriends(mario, jurubeba);
        socialNetwork.makeFriends(romulo, monica);
        socialNetwork.makeFriends(jurubeba, monica);
        socialNetwork.makeFriends(jurubeba, cebolinha);
        socialNetwork.makeFriends(monica, cascao);
        socialNetwork.makeFriends(cascao, magalina);
        socialNetwork.makeFriends(carlos, creusa);
        socialNetwork.makeFriends(luffy, nami);
        socialNetwork.makeFriends(luffy, zoro);
        socialNetwork.makeFriends(luffy, sanji);
        socialNetwork.makeFriends(usopp, franky);
        socialNetwork.makeFriends(brook, mario);

        var personWithMoreFriends = socialNetwork.getMostPopularPerson();
        var personWithLessFriends = socialNetwork.getLoneliestPerson();
        var personWithOldestFriend = socialNetwork.getPersonWithOldestFriend();

        System.out.println("Person with more friends: " + personWithMoreFriends.getName());
        System.out.println("Person with less friends: " + personWithLessFriends.getName());
        System.out.println("Person with oldest friend: " + personWithOldestFriend.getName());
        socialNetwork.printNetwork();
    }
}
