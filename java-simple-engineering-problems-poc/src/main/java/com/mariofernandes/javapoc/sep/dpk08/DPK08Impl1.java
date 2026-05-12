package com.mariofernandes.javapoc.sep.dpk08;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DPK08Impl1 {

    public interface Mapper<T> {
        T apply(T t);
    }

    public<T> Collection<T> map(Collection<T> items, Mapper<T> mapper) {
        Collection<T> result = new ArrayList<>();
        for (T item : items) {
            result.add(mapper.apply(item));
        }
        return result;
    }

    public<T> Collection<T> map(T[] items, Mapper<T> mapper) {
        Collection<T> result = new ArrayList<>();
        for (T item : items) {
            result.add(mapper.apply(item));
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("--> DPK 08 - Implementation 01 <--");
        DPK08Impl1 dpk08Impl1 = new DPK08Impl1();

        var result = dpk08Impl1.map(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), (x) -> x * 2);
        System.out.println("map([1, 2, 3, 4, 5, 6, 7, 8, 9, 10], (x) -> x * 2) -> " + result);

        var result2 = dpk08Impl1.map(new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"}, (term) -> "term: " + term);
        System.out.println("map([\"a\",\"b\",\"c\",\"d\",\"e\",\"f\",\"g\",\"h\",\"i\",\"j\"], (term) -> \"term: \" + term) -> " + result2);
    }
}

