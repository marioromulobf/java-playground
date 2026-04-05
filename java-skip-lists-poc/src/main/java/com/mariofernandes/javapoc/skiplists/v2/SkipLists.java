package com.mariofernandes.javapoc.skiplists.v2;

import java.util.OptionalLong;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.random.RandomGenerator;

public class SkipLists {
    private static final int INITIAL_LEVEL = 0;
    private final int MAX_LEVEL;
    private static final double P_FRACTION = 0.5;

    private final Node header;
    private final AtomicInteger currentLevel;
    private static final ScopedValue<RandomGenerator> RANDOM = ScopedValue.newInstance();
    private final RandomGenerator defaultRandom;

    public SkipLists(int maxLevel) {
        this.MAX_LEVEL = maxLevel;
        header = new Node(-1, Long.MIN_VALUE, MAX_LEVEL);
        currentLevel = new AtomicInteger(INITIAL_LEVEL);
        defaultRandom = RandomGenerator.getDefault();
    }

    public Node getHeader() {
        return header;
    }

    @Override
    public String toString() {
        var sb = new StringBuilder();
        var level = currentLevel.get();
        sb.append("SkipLists{");
        for (int i = level; i >= INITIAL_LEVEL; i--) {
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

    public OptionalLong search(int key) {
        var currentNode = header;
        var level = currentLevel.get();

        for (int i = level; i >= INITIAL_LEVEL; i--) {
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

    public void insert(int key, long value) {
        ScopedValue.where(RANDOM, defaultRandom).run(() -> {
            while (true) { // retry
                var update = new Node[MAX_LEVEL + 1];
                var currentNode = header;
                var level = currentLevel.get();

                // search
                for (int i = level; i >= INITIAL_LEVEL; i--) {
                    var next = currentNode.nextInLevel(i);
                    while (next != null && next.key() < key) {
                        currentNode = next;
                        next = currentNode.nextInLevel(i);
                    }
                    update[i] = currentNode;
                }

                currentNode = currentNode.nextInLevel(INITIAL_LEVEL);

                if (currentNode != null && currentNode.key() == key) {
                    // do nothing, node already exists
                    return;
                }

                var newLevel = getRandomLevel();
                var newNode = new Node(key, value, newLevel);
                boolean success = true;

                if (newLevel > level) {
                    for (int i = level + 1; i <= newLevel; i++) {
                        update[i] = header;
                    }
                    updateCurrentLevel(newLevel);
                }

                for (int i = INITIAL_LEVEL; i <= newLevel; i++) {
                    while (true) { //retry
                        var observedNext = update[i].nextInLevel(i);
                        // check if position is still valid
                        if (observedNext != null && observedNext.key() < key) {
                            // position isn't valid anymore, need to search again
                            success = false;
                            break;
                        }
                        newNode.setNextInLevel(i, observedNext);
                        // compare and set
                        if (update[i].compareAndSetNextInLevel(i, observedNext, newNode)) {
                            // successfully inserted in this level, move to next level
                            break;
                        }
                    }
                    if (!success) {
                        break;
                    }
                }

                if (success) {
                    return;
                }
            }
        });
    }

    public void delete(int key) {
        var update = new Node[MAX_LEVEL + 1];
        var currentNode = header;
        var level = currentLevel.get();

        for (int i = level; i >= INITIAL_LEVEL; i--) {
            var next = currentNode.nextInLevel(i);
            while (next != null && next.key() < key) {
                currentNode = next;
                next = currentNode.nextInLevel(i);
            }
            update[i] = currentNode;
        }
        currentNode = currentNode.nextInLevel(INITIAL_LEVEL);

        if (currentNode != null && currentNode.key() == key) {
            for (int i = INITIAL_LEVEL; i <= level; i++) {
                while (true) {
                    var observed = update[i].nextInLevel(i);

                    if (observed == null || observed.key() != key) {
                        break;
                    }

                    if (observed != currentNode) break;

                    if (update[i].compareAndSetNextInLevel(i, observed, currentNode.nextInLevel(i))) {
                        break;
                    }
                }
            }
            tryReduceLevel();
        }
    }

    private void tryReduceLevel() {
        while (true) {
            int current = currentLevel.get();
            // stop if current is equal to initial level
            if (current == INITIAL_LEVEL) return;
            // stop if higher level isn't empty
            if (header.nextInLevel(current) != null) return;
            // try change current value
            currentLevel.compareAndSet(current, current - 1);
        }
    }

    private void updateCurrentLevel(int newLevel) {
        while (true) {
            int current = currentLevel.get();
            // stop if newLevel is less than or equal to current level
            if (newLevel <= current) return;
            // try change current value
            if (currentLevel.compareAndSet(current, newLevel)) return;
        }
    }

    private int getRandomLevel() {
        var newLevel = INITIAL_LEVEL;

        while (newLevel < MAX_LEVEL && RANDOM.get().nextDouble() < P_FRACTION) {
            newLevel++;
        }

        return newLevel;
    }
}
