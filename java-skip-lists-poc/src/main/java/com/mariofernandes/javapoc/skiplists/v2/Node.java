package com.mariofernandes.javapoc.skiplists.v2;

public record Node(int key, long value, Node[] forward) {
    public Node(int key, long value, int level) {
        this(key, value, new Node[level + 1]);
    }

    public Node next(int level) {
        return forward[level];
    }

    public void setNext(int level, Node node) {
        forward[level] = node;
    }
}
