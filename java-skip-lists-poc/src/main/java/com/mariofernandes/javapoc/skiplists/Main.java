package com.mariofernandes.javapoc.skiplists;

import com.mariofernandes.javapoc.skiplists.v2.SkipLists;

public class Main {

    public static void main(String[] args) {
        System.out.println("=== Java Skip Lists POC ===\n");
        // 16 is appropriate for data structures containing up to 2^16 elements.
        SkipLists skipLists = new SkipLists(16);
        skipLists.insert(3, 3L);
        skipLists.insert(6, 6L);
        skipLists.insert(7, 7L);
        skipLists.insert(9, 9L);
        skipLists.insert(12, 12L);
        skipLists.insert(19, 19L);
        skipLists.insert(17, 17L);
        skipLists.insert(26, 26L);
        skipLists.insert(21, 21L);
        skipLists.insert(21, 21L);
        skipLists.insert(25, 25L);
        System.out.println(skipLists);
        System.out.println("Search 19 result: " + skipLists.search(19));
        System.out.println("Search 30 result: " + skipLists.search(30));
        System.out.println("Delete 21");
        skipLists.delete(21);
        System.out.println(skipLists);
    }
}
