package com.mariofernandes.javapoc.sep.dpk10;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class DPK10Impl10 {

    public interface Reducer<A, I> {
        A apply(A accumulator, I item);
    }

    public interface Flow<I> {
        boolean hasNext();
        I next();

        default<A> A reduce(Reducer<A, I> reducer, A initial) {
            validateReducer(reducer);
            validateInitialValue(initial);

            A accumulator = initial;

            while (hasNext()) {
                accumulator = reducer.apply(accumulator, next());
            }

            return accumulator;
        }

        private static<A, I> void validateReducer(Reducer<A, I> reducer) {
            if (reducer == null) {
                throw new IllegalArgumentException();
            }
        }

        private static<A> void validateInitialValue(A initial) {
            if (initial == null) {
                throw new IllegalArgumentException();
            }
        }

        static<I> Flow<I> from(I[] items) {
            return new ArrayFlow<>(items);
        }

        static<I> Flow<I> from(Collection<I> items) {
            return new CollectionFlow<>(items);
        }
    }

    private static class ArrayFlow<I> implements Flow<I> {
        private final I[] items;
        private int index;

        public ArrayFlow(I[] items) {
            validateItems(items);
            this.items = items;
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
            return index < items.length;
        }

        @Override
        public I next() {
            return items[index++];
        }

        private void validateItems(I[] items) {
            if (items == null) {
                throw new IllegalArgumentException();
            }
        }
    }

    private static class CollectionFlow<I> implements Flow<I> {
        private final Iterator<I> iterator;

        public CollectionFlow(Collection<I> items) {
            validateItems(items);
            this.iterator = items.iterator();
        }

        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }

        @Override
        public I next() {
            return iterator.next();
        }

        private void validateItems(Collection<I> items) {
            if (items == null) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("--> DPK 10 - Implementation 10 <--");

        var input1 = Flow.from(new Integer[]{1, 2, 3, 4, 5});
        var result1 = input1.reduce((acc, x) -> acc + x, 0);
        System.out.println("reduce([1, 2, 3, 4, 5], (acc, x) -> acc + x, 0) -> " + result1);

        var input2 = Flow.from(new String[]{"a", "b", "c", "d", "e"});
        var result2 = input2.reduce((acc, x) -> acc + x, "");
        System.out.println("reduce([\"a\",\"b\",\"c\",\"d\",\"e\"], (acc, x) -> acc + x, \"\") -> " + result2);

        // char to decimal: 'a': 97; 'b': 98'; c': 99'; d': 100'; e': 101'
        var input3 = Flow.from(new String[]{"a", "b", "c", "d", "e"});
        var result3 = input3.reduce((acc, x) -> acc + x.charAt(0), 0);
        System.out.println("reduce([\"a\",\"b\",\"c\",\"d\",\"e\"], (acc, x) -> acc + x.charAt(0), 0) -> " + result3);

        var input4 = Flow.from(List.of(1, 2, 3, 4, 5));
        var result4 = input4.reduce((acc, x) -> acc + x, 0);
        System.out.println("reduce(List[1, 2, 3, 4, 5], (acc, x) -> acc + x, 0) -> " + result4);

        // char to decimal: 'a': 97; 'b': 98'; c': 99'; d': 100'; e': 101'
        var input5 = Flow.from(List.of("a", "b", "c", "d", "e"));
        var result5 = input5.reduce((acc, x) -> acc + x.charAt(0), 0);
        System.out.println("reduce(List[\"a\",\"b\",\"c\",\"d\",\"e\"], (acc, x) -> acc + x.charAt(0), 0) -> " + result5);
    }
}

