package com.mariofernandes.javapoc.sep.dpk15;

import java.util.ArrayList;
import java.util.List;

public class DPK15Impl1 {
    public static void main(String[] args) {
        System.out.println("--> DPK 15 - Implementation 01 <--");
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
        var zorro = new Person("Zorro", 34);
        var sanjia = new Person("Sanjia", 35);
        var usop = new Person("Usop", 36);
        var frankly = new Person("Frankly", 37);
        var brook = new Person("Brook", 38);

        var people = List.of(mario, romulo, maria, jurubeba, monica, cebolinha, cascao, magalina, carlos, creusa, luffy, nami, zorro, sanjia, usop, frankly, brook);

        mario.getFriendships().addFriend(romulo);
        mario.getFriendships().addFriend(maria);
        mario.getFriendships().addFriend(jurubeba);
        romulo.getFriendships().addFriend(mario);
        romulo.getFriendships().addFriend(monica);
        maria.getFriendships().addFriend(mario);
        jurubeba.getFriendships().addFriend(mario);
        jurubeba.getFriendships().addFriend(monica);
        jurubeba.getFriendships().addFriend(cebolinha);
        monica.getFriendships().addFriend(romulo);
        monica.getFriendships().addFriend(jurubeba);
        monica.getFriendships().addFriend(cascao);
        cebolinha.getFriendships().addFriend(jurubeba);
        cascao.getFriendships().addFriend(monica);
        cascao.getFriendships().addFriend(magalina);
        magalina.getFriendships().addFriend(cascao);
        carlos.getFriendships().addFriend(creusa);
        creusa.getFriendships().addFriend(carlos);
        luffy.getFriendships().addFriend(nami);
        luffy.getFriendships().addFriend(zorro);
        luffy.getFriendships().addFriend(sanjia);
        nami.getFriendships().addFriend(luffy);
        zorro.getFriendships().addFriend(luffy);
        sanjia.getFriendships().addFriend(luffy);
        usop.getFriendships().addFriend(frankly);
        frankly.getFriendships().addFriend(usop);
        brook.getFriendships().addFriend(mario);

        var socialNetwork = new SocialNetwork();
        var personWithMoreFriends = socialNetwork.getPersonWithMoreFriends(people);
        var personWithLessFriends = socialNetwork.getPersonWithLessFriends(people);
        var personWithOldestFriend = socialNetwork.getPersonWithOldestFriend(people);

        System.out.println("Person with more friends: " + personWithMoreFriends.getName());
        System.out.println("Person with less friends: " + personWithLessFriends.getName());
        System.out.println("Person with oldest friend: " + personWithOldestFriend.getName());
    }
}

class Person {
    private final String name;
    private final int age;

    private final Friendships friendships;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        this.friendships = new Friendships();
    }

    public Friendships getFriendships() {
        return friendships;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

class Friendships {

    private List<Person> friends;

    public Friendships() {
        this.friends = new ArrayList<>();
    }

    public void addFriend(Person friend) {
        if (!friends.contains(friend)) {
            friends.add(friend);
        }
    }

    public boolean removeFriend(Person friend) {
        return friends.remove(friend);
    }

    public List<Person> getFriends() {
        return friends;
    }
}

class SocialNetwork {
    public Person getPersonWithMoreFriends(List<Person> people) {
        Person personWithMoreFriends = null;
        int maxFriends = -1;

        for (Person person : people) {
            int friendCount = person.getFriendships().getFriends().size();
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

        for (Person person : people) {
            int friendCount = person.getFriendships().getFriends().size();
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

        for (Person person : people) {
            for (Person friend : person.getFriendships().getFriends()) {
                if (friend.getAge() > maxAge) {
                    maxAge = friend.getAge();
                    personWithOldestFriend = person;
                }
            }
        }

        return personWithOldestFriend;
    }
}


