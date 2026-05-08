package com.mariofernandes.javapoc.sep.dpk07;

import java.util.ArrayList;
import java.util.List;

public class DPK07Impl7 {

    public<T> List<List<T>> groupBy(List<T> items, int groupSize) {
        if (items == null || groupSize <= 0) {
            throw new IllegalArgumentException();
        }

        List<List<T>> result = new ArrayList<>();
        int numberOfGroups = (items.size() + groupSize - 1) / groupSize;

        for (int i = 0; i < numberOfGroups; i++) {
            int startPosition = i * groupSize;
            List<T> group = getGroup(items, startPosition, groupSize);
            result.add(group);
        }

        return result;
    }

    private<T> List<T> getGroup(List<T> items, int startPosition, int groupSize) {
        List<T> group = new ArrayList<>(groupSize);
        int end = startPosition + groupSize;

        if (end > items.size()) {
            end = items.size();
        }

        for (int j = startPosition; j < end; j++) {
            group.add(items.get(j));
        }

        return group;
    }

    public static void main(String[] args) {
        System.out.println("--> DPK 07 - Implementation 07 <--");
        DPK07Impl7 dpk07Impl7 = new DPK07Impl7();

        var result = dpk07Impl7.groupBy(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 3);
        System.out.println("groupBy([1, 2, 3, 4, 5, 6, 7, 8, 9, 10], 3) -> " + result);

        var result2 = dpk07Impl7.groupBy(List.of("a", "b", "c", "d", "e", "f", "g", "h", "i", "j"), 3);
        System.out.println("groupBy([\"a\",\"b\",\"c\",\"d\",\"e\",\"f\",\"g\",\"h\",\"i\",\"j\"], 3) -> " + result2);
    }
}

