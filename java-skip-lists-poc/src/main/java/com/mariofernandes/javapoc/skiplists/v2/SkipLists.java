package com.mariofernandes.javapoc.skiplists.v2;

import java.util.OptionalLong;
import java.util.random.RandomGenerator;

public class SkipLists {
    private static final int INITIAL_LEVEL = 0;
    private final int MAX_LEVEL;
    private static final double P_FRACTION = 0.5;

    private final Node header;
    private int currentLevel;
    private static final ScopedValue<RandomGenerator> RANDOM = ScopedValue.newInstance();
    private final RandomGenerator defaultRandom;

    public SkipLists(int maxLevel) {
        this.MAX_LEVEL = maxLevel;
        header = new Node(-1, Long.MIN_VALUE, MAX_LEVEL);
        currentLevel = INITIAL_LEVEL;
        defaultRandom = RandomGenerator.getDefault();
    }

    @Override
    public String toString() {
        var sb = new StringBuilder();
        sb.append("SkipLists{");
        for (int i = currentLevel; i >= INITIAL_LEVEL; i--) {
            sb.append("\n\tLevel ").append(i).append(": ");
            var currentNode = header.nextInLevel(i);
            while (currentNode != null) {
                sb.append(currentNode).append(" -> ");
                currentNode = currentNode.nextInLevel(i);
            }
            sb.append("null");
        }
        sb.append("\n}");
        return sb.toString();
    }

    public OptionalLong search(Integer key) {
        var currentNode = header;

        for (int i = currentLevel; i >= INITIAL_LEVEL; i--) {
            var next = currentNode.nextInLevel(i);
            while (next != null && next.key() < key) {
                currentNode = next;
                next = currentNode.nextInLevel(i);
            }
        }

        currentNode = currentNode.nextInLevel(INITIAL_LEVEL);

        return (currentNode != null && currentNode.key() == key)
                ? OptionalLong.of(currentNode.value())
                : OptionalLong.empty();
    }

    public void insert(int key, Long value) {
        var update = new Node[MAX_LEVEL + 1];
        var currentNode = header;

        for (int i = currentLevel; i >= INITIAL_LEVEL; i--) {
            var next = currentNode.nextInLevel(i);
            while (next != null && next.key() < key) {
                currentNode = next;
                next = currentNode.nextInLevel(i);
            }
            update[i] = currentNode;
        }

        currentNode = currentNode.nextInLevel(INITIAL_LEVEL);

        if (currentNode != null && currentNode.key() == key) {
            // do nothing, because i'm using record
        } else {
            var newLevel = getRandomLevel();

            if (newLevel > currentLevel) {
                for (int i = currentLevel + 1; i <= newLevel; i++) {
                    update[i] = header;
                }
                currentLevel = newLevel;
            }

            var newNode = new Node(key, value, newLevel);
            for (int i = INITIAL_LEVEL; i <= newLevel; i++) {
                newNode.setNextInLevel(i, update[i].nextInLevel(i));
                update[i].setNextInLevel(i, newNode);
            }
        }
    }

    public void delete(int key) {
        var update = new Node[MAX_LEVEL + 1];
        var currentNode = header;

        for (int i = currentLevel; i >= INITIAL_LEVEL; i--) {
            var next = currentNode.nextInLevel(i);
            while (next != null && next.key() < key) {
                currentNode = next;
                next = currentNode.nextInLevel(i);
            }
            update[i] = currentNode;
        }
        currentNode = currentNode.nextInLevel(INITIAL_LEVEL);

        if (currentNode != null && currentNode.key() == key) {
            for (int i = INITIAL_LEVEL; i <= currentLevel; i++) {
                if (update[i].nextInLevel(i) == null || update[i].nextInLevel(i).key() != key) {
                    break;
                }
                update[i].setNextInLevel(i, currentNode.nextInLevel(i));
            }
            while (currentLevel > INITIAL_LEVEL && header.nextInLevel(currentLevel) == null) {
                currentLevel--;
            }
        }
    }

    private int getRandomLevel() {
        return ScopedValue.where(RANDOM, defaultRandom).call(() -> {
            var newLevel = INITIAL_LEVEL;

            while (newLevel < MAX_LEVEL && RANDOM.get().nextDouble() < P_FRACTION) {
                newLevel++;
            }
            return newLevel;
        });
    }
}
