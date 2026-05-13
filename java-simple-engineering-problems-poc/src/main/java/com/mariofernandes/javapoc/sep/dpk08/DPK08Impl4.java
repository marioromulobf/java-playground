package com.mariofernandes.javapoc.sep.dpk08;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class DPK08Impl4 {

    public interface Mapper<I, O> {
        O apply(I input);
    }

    public<I, O> Collection<O> map(Collection<I> items, Mapper<I, O> mapper) {
        Collection<O> result = new ArrayList<>();

        Iterator<I> iterator = items.iterator();
        while (iterator.hasNext()) {
            result.add(mapper.apply(iterator.next()));
        }

        return result;
    }

    public<I, O> Collection<O> map(I[] items, Mapper<I, O> mapper) {
        Collection<O> result = new ArrayList<>();
        for (I item : items) {
            result.add(mapper.apply(item));
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("--> DPK 08 - Implementation 04 <--");
        DPK08Impl4 dpk08Impl4 = new DPK08Impl4();

        var result = dpk08Impl4.map(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), (x) -> x * 2);
        System.out.println("map([1, 2, 3, 4, 5, 6, 7, 8, 9, 10], (x) -> x * 2) -> " + result);

        var result2 = dpk08Impl4.map(new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"}, (term) -> "term: " + term);
        System.out.println("map([\"a\",\"b\",\"c\",\"d\",\"e\",\"f\",\"g\",\"h\",\"i\",\"j\"], (term) -> \"term: \" + term) -> " + result2);
    }
}

