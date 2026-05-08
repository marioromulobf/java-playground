package com.mariofernandes.javapoc.sep.dpk07;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DPK07Impl9 {

    public<T> List<List<T>> groupBy(List<T> items, int groupSize) {
        if (items == null || groupSize <= 0) {
            throw new IllegalArgumentException();
        }

        List<List<T>> result = new ArrayList<>();
        Iterator<T> iterator = items.iterator();

        while (iterator.hasNext()) {
            List<T> group = new ArrayList<>(groupSize);

            for (int i = 0; i < groupSize && iterator.hasNext(); i++) {
                group.add(iterator.next());
            }

            result.add(group);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println("--> DPK 07 - Implementation 09 <--");
        DPK07Impl9 dpk07Impl9 = new DPK07Impl9();

        var result = dpk07Impl9.groupBy(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 3);
        System.out.println("groupBy([1, 2, 3, 4, 5, 6, 7, 8, 9, 10], 3) -> " + result);

        var result2 = dpk07Impl9.groupBy(List.of("a", "b", "c", "d", "e", "f", "g", "h", "i", "j"), 3);
        System.out.println("groupBy([\"a\",\"b\",\"c\",\"d\",\"e\",\"f\",\"g\",\"h\",\"i\",\"j\"], 3) -> " + result2);
    }
}

