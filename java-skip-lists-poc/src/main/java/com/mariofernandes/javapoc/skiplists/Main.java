package com.mariofernandes.javapoc.skiplists;

import com.mariofernandes.javapoc.skiplists.v2.SkipLists;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.StructuredTaskScope;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("=== Java Skip Lists POC ===\n");

        runSingleThread();
        System.out.println(" ----------------------------------------------\n");
        runWithConcurrency();
    }

    static void runSingleThread() {
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

    static void runWithConcurrency() {
        // 16 is appropriate for data structures containing up to 2^16 elements.
        SkipLists skipLists = new SkipLists(16);
        var dataInsert = new ArrayList<>(List.of(3, 6, 7, 9, 12, 19, 17, 26, 21, 21, 25));
        Collections.shuffle(dataInsert);
        try (var scope = StructuredTaskScope.open()) {
            for (int value : dataInsert) {
                scope.fork(() -> skipLists.insert(value, value));
            }
            scope.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(skipLists);
        try (var scope = StructuredTaskScope.open()) {
            scope.fork(() -> System.out.println("Search 19 result: " + skipLists.search(19)));
            scope.fork(() -> System.out.println("Search 30 result: " + skipLists.search(30)));
            scope.fork(() -> {
                System.out.println("Delete 21");
                skipLists.delete(21);
            });
            scope.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(skipLists);
    }
}
