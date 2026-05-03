package com.mariofernandes.javapoc.sep.dpk07;

import java.util.ArrayList;
import java.util.List;

public class DPK07Impl2 {

    public<T> List<List<T>> groupBy(List<T> items, int groupSize) {
        if (items == null || groupSize <= 0) {
            throw new IllegalArgumentException();
        }

        List<List<T>> result = new ArrayList<>();

        if (items.size() <= groupSize) {
            result.add(items);
            return result;
        }

        List<T> group = new ArrayList<>(groupSize);
        for (int i = 0; i < items.size(); i++) {
            if (group.size() == groupSize) {
                result.add(group);
                group = new ArrayList<>(groupSize);
            }
            group.add(items.get(i));
        }

        if (group.size() > 0) {
            result.add(group);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println("--> DPK 07 - Implementation 02 <--");
        DPK07Impl2 dpk07Impl2 = new DPK07Impl2();

        var result = dpk07Impl2.groupBy(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 3);
        System.out.println("groupBy([1, 2, 3, 4, 5, 6, 7, 8, 9, 10], 3) -> " + result);

        var result2 = dpk07Impl2.groupBy(List.of("a", "b", "c", "d", "e", "f", "g", "h", "i", "j"), 3);
        System.out.println("groupBy([\"a\",\"b\",\"c\",\"d\",\"e\",\"f\",\"g\",\"h\",\"i\",\"j\"], 3) -> " + result2);
    }
}

