package com.mariofernandes.javapoc.skiplists;

import java.util.concurrent.ConcurrentSkipListMap;

public class SkipLists {
    private static final int INITIAL_LEVAL = 0;
    private final int MAX_LEVEL;
    private static final double P_FRACTION = 0.5;

    public SkipLists(int maxLevel) {
        this.MAX_LEVEL = maxLevel;
    }


    public void search() {

    }

    public void insert() {

    }

    public int getRandomLevel() {
        int newLevel = INITIAL_LEVAL;

        while (Math.random() < P_FRACTION) {
            newLevel++;
        }

        return Math.min(newLevel, MAX_LEVEL);
    }
}
