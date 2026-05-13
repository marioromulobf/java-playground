package com.mariofernandes.javapoc.sep.dpk08;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class DPK08Impl10 {

    public interface Mapper<I, O> {
        O apply(I input);
    }

    public interface Sequence<I> {
        boolean hasNext();
        I next();
    }

    public static class CollectionSequence<I> implements Sequence<I> {
        private final Iterator<I> iterator;

        public CollectionSequence(Collection<I> items) {
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
    }

    public static class ArraySequence<I> implements Sequence<I> {
        private final I[] items;

        private int index;

        public ArraySequence(I[] items) {
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
    }

    public<I, O> Collection<O> map(Sequence<I> items, Mapper<I, O> mapper) {
        validateItems(items);
        validateMapper(mapper);

        Collection<O> result = new ArrayList<>();

        while (items.hasNext()) {
            result.add(mapper.apply(items.next()));
        }

        return result;
    }

    private<I> void validateItems(Sequence<I> items) {
        if (items == null) {
            throw new IllegalArgumentException();
        }
    }

    private<I, O> void validateMapper(Mapper<I, O> mapper) {
        if (mapper == null) {
            throw new IllegalArgumentException();
        }
    }

    public static void main(String[] args) {
        System.out.println("--> DPK 08 - Implementation 10 <--");
        DPK08Impl10 dpk08Impl10 = new DPK08Impl10();

        var result = dpk08Impl10.map(
                new CollectionSequence<Integer>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)),
                (x) -> x * 2
        );
        System.out.println("map([1, 2, 3, 4, 5, 6, 7, 8, 9, 10], (x) -> x * 2) -> " + result);

        var result2 = dpk08Impl10.map(
                new ArraySequence<String>(new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"}),
                (term) -> "term: " + term
        );
        System.out.println("map([\"a\",\"b\",\"c\",\"d\",\"e\",\"f\",\"g\",\"h\",\"i\",\"j\"], (term) -> \"term: \" + term) -> " + result2);
    }
}

