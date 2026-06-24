package com.mariofernandes.javapoc.sep.dpk15;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class DPK15Impl10 {

    record Person(String name, int age) {}

    static class SocialNetwork {
        private final Map<Person, Set<Person>> friendships;

        public SocialNetwork() {
            this.friendships = new HashMap<>();
        }

        public void addPerson(Person... person) {
            if (person == null) {
                return;
            }

            for (Person p : person) {
                friendships.putIfAbsent(p, new HashSet<>());
            }
        }

        public Person getMostPopularPerson() {
            return friendships.keySet().stream()
                    .max(Comparator.comparingInt(p -> friendships.getOrDefault(p, Set.of()).size()))
                    .orElse(null);
        }

        public Person getLoneliestPerson() {
            return friendships.keySet().stream()
                    .min(Comparator.comparingInt(p -> friendships.getOrDefault(p, Set.of()).size()))
                    .orElse(null);
        }

        public Set<Person> getFriends(Person person) {
            validate(person);

            return Set.copyOf(friendships.getOrDefault(person, Set.of()));
        }

        public Optional<Person> getOldestFriend(Person person) {
            validate(person);

            return friendships.getOrDefault(person, Set.of()).stream()
                    .max(Comparator.comparingInt(Person::age));
        }

        public Person getPersonWithOldestFriend() {
            return friendships.keySet().stream()
                    .max(Comparator.comparingInt((Person p) -> getOldestFriend(p).map(Person::age).orElse(-1)))
                    .orElse(null);
        }

        public List<Person> getPeople() {
            return List.copyOf(friendships.keySet());
        }

        public void makeFriends(Person person, Person friend) {
            validate(person);
            validate(friend);

            if (person.equals(friend)) {
                throw new IllegalArgumentException();
            }

            friendships.computeIfAbsent(person, f -> new HashSet<>()).add(friend);
            friendships.computeIfAbsent(friend, f -> new HashSet<>()).add(person);
        }

        public void removeFriendship(Person person, Person friend) {
            validate(person);
            validate(friend);

            friendships.getOrDefault(person, new HashSet<>()).remove(friend);
            friendships.getOrDefault(friend, new HashSet<>()).remove(person);
        }

        private void validate(Person person) {
            if  (person == null || !friendships.containsKey(person)) {
                throw new IllegalArgumentException();
            }
        }

        public void printNetwork() {
            for (Person person : friendships.keySet()) {
                System.out.println(person.name() + " (" + person.age() + ") has " +
                        friendships.getOrDefault(person, Set.of()).size() + " friends: ");
                for (Person friend : friendships.getOrDefault(person, Set.of())) {
                    System.out.println("  - " + friend.name());
                }
                System.out.println(" --//-- ");
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("--> DPK 15 - Implementation 10 <--");
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

        System.out.println("Person with more friends: " + personWithMoreFriends.name());
        System.out.println("Person with less friends: " + personWithLessFriends.name());
        System.out.println("Person with oldest friend: " + personWithOldestFriend.name());
        socialNetwork.printNetwork();
    }
}
