package com.mariofernandes.javapoc.sep.dpk15;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class DPK15Impl4 {

    static class Person {
        private final String name;
        private final int age;

        private final Friendships friendships;

        public Person(String name, int age) {
            if (name == null || name.isEmpty() || age < 0) {
                throw new IllegalArgumentException();
            }

            this.name = name;
            this.age = age;
            this.friendships = new Friendships();
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public void addFriend(Person friend) {
            if (!this.equals(friend)) {
                friendships.addFriend(friend);
            }
        }

        public Optional<Person> getMyOldestFriend() {
            return friendships.getOldestFriend();
        }

        public int getMyFriendCount() {
            return friendships.getFriendCount();
        }
    }

    static class Friendships {

        private final Set<Person> friends;

        public Friendships() {
            this.friends = new HashSet<>();
        }

        public void addFriend(Person friend) {
            friends.add(friend);
        }

        public boolean removeFriend(Person friend) {
            return friends.remove(friend);
        }

        public Optional<Person> getOldestFriend() {
            return friends.stream()
                    .max((f1, f2) -> Integer.compare(f1.getAge(), f2.getAge()));
        }

        public int getFriendCount() {
            return friends.size();
        }
    }

    static class SocialNetwork {
        public Person getPersonWithMoreFriends(List<Person> people) {
            Person personWithMoreFriends = null;
            int maxFriends = -1;

            if (people == null) {
                return personWithMoreFriends;
            }

            for (Person person : people) {
                int friendCount = person.getMyFriendCount();
                if (friendCount > maxFriends) {
                    maxFriends = friendCount;
                    personWithMoreFriends = person;
                }
            }

            return personWithMoreFriends;
        }

        public Person getPersonWithLessFriends(List<Person> people) {
            Person personWithLessFriends = null;
            int minFriends = Integer.MAX_VALUE;

            if (people == null) {
                return personWithLessFriends;
            }

            for (Person person : people) {
                int friendCount = person.getMyFriendCount();
                if (friendCount < minFriends) {
                    minFriends = friendCount;
                    personWithLessFriends = person;
                }
            }

            return personWithLessFriends;
        }

        public Person getPersonWithOldestFriend(List<Person> people) {
            Person personWithOldestFriend = null;
            int maxAge = -1;

            if (people == null) {
                return personWithOldestFriend;
            }

            for (Person person : people) {
                Optional<Person> optionalOldestFriend = person.getMyOldestFriend();
                if (optionalOldestFriend.isPresent() && optionalOldestFriend.get().getAge() > maxAge) {
                    maxAge = optionalOldestFriend.get().getAge();
                    personWithOldestFriend = person;
                }
            }

            return personWithOldestFriend;
        }
    }

    public static void main(String[] args) {
        System.out.println("--> DPK 15 - Implementation 04 <--");
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

        var people = List.of(mario, romulo, maria, jurubeba, monica, cebolinha, cascao, magalina, carlos, creusa, luffy, nami, zoro, sanji, usopp, franky, brook);

        mario.addFriend(romulo);
        mario.addFriend(maria);
        mario.addFriend(jurubeba);
        romulo.addFriend(mario);
        romulo.addFriend(monica);
        maria.addFriend(mario);
        jurubeba.addFriend(mario);
        jurubeba.addFriend(monica);
        jurubeba.addFriend(cebolinha);
        monica.addFriend(romulo);
        monica.addFriend(jurubeba);
        monica.addFriend(cascao);
        cebolinha.addFriend(jurubeba);
        cascao.addFriend(monica);
        cascao.addFriend(magalina);
        magalina.addFriend(cascao);
        carlos.addFriend(creusa);
        creusa.addFriend(carlos);
        luffy.addFriend(nami);
        luffy.addFriend(zoro);
        luffy.addFriend(sanji);
        nami.addFriend(luffy);
        zoro.addFriend(luffy);
        sanji.addFriend(luffy);
        usopp.addFriend(franky);
        franky.addFriend(usopp);
        brook.addFriend(mario);

        var socialNetwork = new SocialNetwork();
        var personWithMoreFriends = socialNetwork.getPersonWithMoreFriends(people);
        var personWithLessFriends = socialNetwork.getPersonWithLessFriends(people);
        var personWithOldestFriend = socialNetwork.getPersonWithOldestFriend(people);

        System.out.println("Person with more friends: " + personWithMoreFriends.getName());
        System.out.println("Person with less friends: " + personWithLessFriends.getName());
        System.out.println("Person with oldest friend: " + personWithOldestFriend.getName());
    }
}
