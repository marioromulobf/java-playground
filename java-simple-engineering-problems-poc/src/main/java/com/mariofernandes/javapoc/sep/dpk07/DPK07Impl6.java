package com.mariofernandes.javapoc.sep.dpk07;

import java.util.ArrayList;
import java.util.List;

public class DPK07Impl6 {

    public<T> List<List<T>> groupBy(List<T> items, int groupSize) {
        if (items == null || groupSize <= 0) {
            throw new IllegalArgumentException();
        }

        List<List<T>> result = new ArrayList<>();

        for (int i = 0; i < items.size(); i += groupSize) {
            List<T> group = new ArrayList<>(groupSize);

            int end = i + groupSize;
            if (end > items.size()) {
                end = items.size();
            }

            for (int j = i; j < end; j++) {
                group.add(items.get(j));
            }

            result.add(group);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println("--> DPK 07 - Implementation 06 <--");
        DPK07Impl6 dpk07Impl6 = new DPK07Impl6();

        var result = dpk07Impl6.groupBy(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 3);
        System.out.println("groupBy([1, 2, 3, 4, 5, 6, 7, 8, 9, 10], 3) -> " + result);

        var result2 = dpk07Impl6.groupBy(List.of("a", "b", "c", "d", "e", "f", "g", "h", "i", "j"), 3);
        System.out.println("groupBy([\"a\",\"b\",\"c\",\"d\",\"e\",\"f\",\"g\",\"h\",\"i\",\"j\"], 3) -> " + result2);
    }
}

