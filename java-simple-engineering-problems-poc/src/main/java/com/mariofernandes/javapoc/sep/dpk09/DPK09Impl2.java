package com.mariofernandes.javapoc.sep.dpk09;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class DPK09Impl2 {

    public interface Filter<T> {
        boolean test(T t);
    }

    public<T> Collection<T> filter(Collection<T> items, Filter<T> filter) {
        Collection<T> result = new ArrayList<>();
        Iterator<T> iterator = items.iterator();

        while (iterator.hasNext()) {
            T item = iterator.next();
            if (filter.test(item)) {
                result.add(item);
            }
        }

        return result;
    }

    public<T> Collection<T> filter(T[] items, Filter<T> filter) {
        Collection<T> result = new ArrayList<>();
        for (T item : items) {
            if (filter.test(item)) {
                result.add(item);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("--> DPK 09 - Implementation 02 <--");
        DPK09Impl2 dpk09Impl2 = new DPK09Impl2();

        var result = dpk09Impl2.filter(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), (x) -> x % 2 == 0);
        System.out.println("filter([1, 2, 3, 4, 5, 6, 7, 8, 9, 10], (x) -> x % 2 == 0) -> " + result);

        // char to decimal: 'a': 97; 'b': 98'; c': 99'; d': 100'; e': 101'; f': 102'; g': 103'; h': 104'; i': 105'; j': 106
        var result2 = dpk09Impl2.filter(
                new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"},
                (term) -> term.charAt(0) % 2 == 0
        );
        System.out.println("filter([\"a\",\"b\",\"c\",\"d\",\"e\",\"f\",\"g\",\"h\",\"i\",\"j\"], (term) -> term.charAt(0) % 2 == 0) -> " + result2);
    }
}

