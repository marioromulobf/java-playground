package com.mariofernandes.javapoc.sep.dpk08;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class DPK08Impl8 {

    public interface Mapper<I, O> {
        O apply(I input);
    }

    public<I, O> Collection<O> map(Collection<I> items, Mapper<I, O> mapper) {
        validateItems(items);
        validateMapper(mapper);

        Collection<O> result = new ArrayList<>();

        Iterator<I> iterator = items.iterator();
        while (iterator.hasNext()) {
            result.add(mapper.apply(iterator.next()));
        }

        return result;
    }

    public<I, O> Collection<O> map(I[] items, Mapper<I, O> mapper) {
        validateItems(items);
        validateMapper(mapper);

        Collection<O> result = new ArrayList<>();

        for (int i = 0; i < items.length; i++) {
            result.add(mapper.apply(items[i]));
        }

        return result;
    }

    private<I> void validateItems(Collection<I> items) {
        if (items == null) {
            throw new IllegalArgumentException();
        }
    }

    private<I> void validateItems(I[] items) {
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
        System.out.println("--> DPK 08 - Implementation 08 <--");
        DPK08Impl8 dpk08Impl8 = new DPK08Impl8();

        var result = dpk08Impl8.map(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), (x) -> x * 2);
        System.out.println("map([1, 2, 3, 4, 5, 6, 7, 8, 9, 10], (x) -> x * 2) -> " + result);

        var result2 = dpk08Impl8.map(new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"}, (term) -> "term: " + term);
        System.out.println("map([\"a\",\"b\",\"c\",\"d\",\"e\",\"f\",\"g\",\"h\",\"i\",\"j\"], (term) -> \"term: \" + term) -> " + result2);
    }
}

