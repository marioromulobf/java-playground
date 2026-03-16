package com.mariofernandes.javapoc.skiplists;

import java.util.Random;

public class SkipLists {

    private static final int INITIAL_LEVAL = 0;
    private final int MAX_LEVEL;
    private static final double P_FRACTION = 0.5;

    private Node header;
    private int currentLevel;
    private Random random;
    private long seed = -5292398372388667826L;

    public SkipLists(int maxLevel) {
        this.MAX_LEVEL = maxLevel;
        header = new Node(-1, null, MAX_LEVEL);
        currentLevel = INITIAL_LEVAL;
        random = new Random();
        seed = random.nextLong();
        random.setSeed(seed);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SkipLists{");
        sb.append("\nRandom seed: ").append(seed);
        for (int i = currentLevel; i >= INITIAL_LEVAL; i--) {
            sb.append("\nLevel ").append(i).append(": ");
            Node currentNode = header.forward[i];
            while (currentNode != null) {
                sb.append(currentNode.toString()).append(" -> ");
                currentNode = currentNode.forward[i];
            }
            sb.append("null");
        }
        sb.append("\n}");
        return sb.toString();
    }

    public Long search(Integer key) {
        Node currentNode = header;

        for (int i = currentLevel; i >= INITIAL_LEVAL; i--) {
            while (currentNode.forward[i] != null && currentNode.forward[i].getKey() < key) {
                currentNode = currentNode.forward[i];
            }
        }
        currentNode = currentNode.forward[INITIAL_LEVAL];
        if (currentNode != null && currentNode.getKey() == key) {
            return currentNode.getValue();
        }
        return null;
    }

    public void insert(int key, Long value) {
        Node[] update = new Node[MAX_LEVEL + 1];
        Node currentNode = header;

        for (int i = currentLevel; i >= INITIAL_LEVAL; i--) {
            while (currentNode.forward[i] != null && currentNode.forward[i].getKey() < key) {
                currentNode = currentNode.forward[i];
            }
            update[i] = currentNode;
        }

        currentNode = currentNode != null ? currentNode.forward[INITIAL_LEVAL] : null;

        if (currentNode != null && currentNode.getKey() == key) {
            currentNode.setValue(value);
        } else {
            int newLevel = getRandomLevel();

            if (newLevel > currentLevel) {
                for (int i = currentLevel + 1; i <= newLevel; i++) {
                    update[i] = header;
                }
                currentLevel = newLevel;
            }

            Node newNode = new Node(key, value, newLevel);
            for (int i = INITIAL_LEVAL; i <= newLevel; i++) {
                newNode.forward[i] = update[i].forward[i];
                update[i].forward[i] = newNode;
            }
        }
    }

    public void delete(int key) {
        Node[] update = new Node[MAX_LEVEL + 1];
        Node currentNode = header;

        for (int i = currentLevel; i >= INITIAL_LEVAL; i--) {
            while (currentNode.forward[i] != null && currentNode.forward[i].getKey() < key) {
                currentNode = currentNode.forward[i];
            }
            update[i] = currentNode;
        }
        currentNode = currentNode.forward[INITIAL_LEVAL];

        if (currentNode != null && currentNode.getKey() == key) {
            for (int i = INITIAL_LEVAL; i <= currentLevel; i++) {
                if (update[i].forward[i] == null || update[i].forward[i].getKey() != key) {
                    break;
                }
                update[i].forward[i] = currentNode.forward[i];
            }
            while (currentLevel > INITIAL_LEVAL && header.forward[currentLevel] == null) {
                currentLevel--;
            }
        }
    }

    private int getRandomLevel() {
        int newLevel = INITIAL_LEVAL;

        while (newLevel < MAX_LEVEL && random.nextDouble() < P_FRACTION) {
            newLevel++;
        }

        return newLevel;
    }
}
