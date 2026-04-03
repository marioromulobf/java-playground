package com.mariofernandes.javapoc.skiplists.v1;

public class Node {
    private int key;
    private Long value;
    Node[] forward;

    public Node(int key, Long value, int level) {
        this.key = key;
        this.value = value;
        this.forward = new Node[level + 1];
    }

    public int getKey() {
        return key;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{key=")
                .append(key)
                .append(", value=")
                .append(value)
                .append("}");
        return sb.toString();
    }
}
