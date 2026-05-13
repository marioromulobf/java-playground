package com.mariofernandes.javapoc.sep.dpk08;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DPK08Impl2 {

    public interface Mapper<I, O> {
        O apply(I i);
    }

    public<I, O> Collection<O> map(Collection<I> items, Mapper<I, O> mapper) {
        Collection<O> result = new ArrayList<>();
        for (I item : items) {
            result.add(mapper.apply(item));
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
        System.out.println("--> DPK 08 - Implementation 01 <--");
        DPK08Impl2 dpk08Impl1 = new DPK08Impl2();

        var result = dpk08Impl1.map(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), (x) -> x * 2);
        System.out.println("map([1, 2, 3, 4, 5, 6, 7, 8, 9, 10], (x) -> x * 2) -> " + result);

        var result2 = dpk08Impl1.map(new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"}, (term) -> "term: " + term);
        System.out.println("map([\"a\",\"b\",\"c\",\"d\",\"e\",\"f\",\"g\",\"h\",\"i\",\"j\"], (term) -> \"term: \" + term) -> " + result2);
    }
}

