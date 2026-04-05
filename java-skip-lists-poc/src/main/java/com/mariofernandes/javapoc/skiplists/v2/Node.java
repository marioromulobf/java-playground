package com.mariofernandes.javapoc.skiplists.v2;

import java.util.concurrent.atomic.AtomicReferenceArray;

public record Node(int key, long value, AtomicReferenceArray<Node> forward) {
    public Node(int key, long value, int level) {
        this(key, value, new AtomicReferenceArray<>(level + 1));
    }

    public Node nextInLevel(int level) {
        return forward.get(level);
    }

    public void setNextInLevel(int level, Node node) {
        forward.set(level, node);
    }

    public boolean compareAndSetNextInLevel(int level, Node observedNext, Node node) {
        return forward.compareAndSet(level, observedNext, node);
    }

    @Override
    public String toString() {
        return "{ key=" + key + ", value=" + value + " }";
    }
}
