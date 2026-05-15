package com.mariofernandes.javapoc.sep.dpk09;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class DPK09Impl5 {

    public interface Filter<T> {
        boolean test(T t);
    }

    public interface Sequence<T> {
        boolean hasNext();
        T next();
    }

    public static class CollectionSequence<T> implements Sequence<T> {
        private final Iterator<T> iterator;

        public CollectionSequence(Collection<T> items) {
            validateItems(items);
            this.iterator = items.iterator();
        }

        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }

        @Override
        public T next() {
            return iterator.next();
        }
    }

    public static class ArraySequence<T> implements Sequence<T> {
        private final T[] items;
        private int index;

        public ArraySequence(T[] items) {
            validateItems(items);
            this.items = items;
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
            return index < items.length;
        }

        @Override
        public T next() {
            return items[index++];
        }
    }

    public<T> Collection<T> filter(Sequence<T> items, Filter<T> filter) {
        validateFilter(filter);

        Collection<T> result = new ArrayList<>();

        while (items.hasNext()) {
            T item = items.next();
            if (filter.test(item)) {
                result.add(item);
            }
        }

        return result;
    }

    private static<T> void validateItems(Collection<T> items) {
        if (items == null) {
            throw new IllegalArgumentException();
        }
    }

    private static<T> void validateItems(T[] items) {
        if (items == null) {
            throw new IllegalArgumentException();
        }
    }

    private<T> void validateFilter(Filter<T> filter) {
        if (filter == null) {
            throw new IllegalArgumentException();
        }
    }

    public static void main(String[] args) {
        System.out.println("--> DPK 09 - Implementation 05 <--");
        DPK09Impl5 dpk09Impl5 = new DPK09Impl5();

        var input1 = new CollectionSequence<Integer>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        var result = dpk09Impl5.filter(input1, (x) -> x % 2 == 0);
        System.out.println("filter([1, 2, 3, 4, 5, 6, 7, 8, 9, 10], (x) -> x % 2 == 0) -> " + result);

        // char to decimal: 'a': 97; 'b': 98'; c': 99'; d': 100'; e': 101'; f': 102'; g': 103'; h': 104'; i': 105'; j': 106
        var input2 = new ArraySequence<String>(new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"});
        var result2 = dpk09Impl5.filter(input2, (term) -> term.charAt(0) % 2 == 0);
        System.out.println("filter([\"a\",\"b\",\"c\",\"d\",\"e\",\"f\",\"g\",\"h\",\"i\",\"j\"], (term) -> term.charAt(0) % 2 == 0) -> " + result2);
    }
}

