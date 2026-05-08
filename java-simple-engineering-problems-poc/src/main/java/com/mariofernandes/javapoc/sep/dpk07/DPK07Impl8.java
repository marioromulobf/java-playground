package com.mariofernandes.javapoc.sep.dpk07;

import java.util.ArrayList;
import java.util.List;

public class DPK07Impl8 {

    public<T> List<List<T>> groupBy(List<T> items, int groupSize) {
        if (items == null || groupSize <= 0) {
            throw new IllegalArgumentException();
        }

        List<List<T>> result = new ArrayList<>();
        int numberOfGroups = (items.size() + groupSize - 1) / groupSize;

        for (int i = 0; i < numberOfGroups; i++) {
            int start = i * groupSize;
            int end = start + groupSize;

            if (end > items.size()) {
                end = items.size();
            }

            result.add(slice(items, start, end));
        }

        return result;
    }

    private<T> List<T> slice(List<T> items, int start, int end) {
        List<T> group = new ArrayList<>(end - start);

        for (int j = start; j < end; j++) {
            group.add(items.get(j));
        }

        return group;
    }

    public static void main(String[] args) {
        System.out.println("--> DPK 07 - Implementation 08 <--");
        DPK07Impl8 dpk07Impl8 = new DPK07Impl8();

        var result = dpk07Impl8.groupBy(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 3);
        System.out.println("groupBy([1, 2, 3, 4, 5, 6, 7, 8, 9, 10], 3) -> " + result);

        var result2 = dpk07Impl8.groupBy(List.of("a", "b", "c", "d", "e", "f", "g", "h", "i", "j"), 3);
        System.out.println("groupBy([\"a\",\"b\",\"c\",\"d\",\"e\",\"f\",\"g\",\"h\",\"i\",\"j\"], 3) -> " + result2);
    }
}

