package com.mariofernandes.javapoc.sep.dpk10;

import java.util.Collection;
import java.util.List;

public class DPK10Impl4 {

    public interface Reducer<A, I> {
        A apply(A accumulator, I item);
    }

    public<A, I> A reduce(I[] items, Reducer<A, I> reducer, A initial) {
        validateItems(items);
        validateReducer(reducer);
        validateInitialValue(initial);

        var accumulator = initial;

        for (I item : items) {
            accumulator = reducer.apply(accumulator, item);
        }

        return accumulator;
    }

    public<A, I> A reduce(Collection<I> items, Reducer<A, I> reducer, A initial) {
        validateItems(items);
        validateReducer(reducer);
        validateInitialValue(initial);

        var accumulator = initial;

        for (I item : items) {
            accumulator = reducer.apply(accumulator, item);
        }

        return accumulator;
    }

    private static<I> void validateItems(I[] items) {
        if (items == null) {
            throw new IllegalArgumentException();
        }
    }

    private static<I> void validateItems(Collection<I> items) {
        if (items == null) {
            throw new IllegalArgumentException();
        }
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

    public static void main(String[] args) {
        System.out.println("--> DPK 10 - Implementation 04 <--");
        DPK10Impl4 dpk10Impl4 = new DPK10Impl4();

        var input1 = new Integer[]{1, 2, 3, 4, 5};
        var result1 = dpk10Impl4.reduce(input1, (acc, x) -> acc + x, 0);
        System.out.println("reduce([1, 2, 3, 4, 5], (acc, x) -> acc + x, 0) -> " + result1);

        var input2 = new String[]{"a", "b", "c", "d", "e"};
        var result2 = dpk10Impl4.reduce(input2, (acc, x) -> acc + x, "");
        System.out.println("reduce([\"a\",\"b\",\"c\",\"d\",\"e\"], (acc, x) -> acc + x, \"\") -> " + result2);

        // char to decimal: 'a': 97; 'b': 98'; c': 99'; d': 100'; e': 101'
        var result3 = dpk10Impl4.reduce(input2, (acc, x) -> acc + x.charAt(0), 0);
        System.out.println("reduce([\"a\",\"b\",\"c\",\"d\",\"e\"], (acc, x) -> acc + x.charAt(0), 0) -> " + result3);

        var input4 = List.of(1, 2, 3, 4, 5);
        var result4 = dpk10Impl4.reduce(input4, (acc, x) -> acc + x, 0);
        System.out.println("reduce(List[1, 2, 3, 4, 5], (acc, x) -> acc + x, 0) -> " + result4);

        // char to decimal: 'a': 97; 'b': 98'; c': 99'; d': 100'; e': 101'
        var input5 = List.of("a", "b", "c", "d", "e");
        var result5 = dpk10Impl4.reduce(input5, (acc, x) -> acc + x.charAt(0), 0);
        System.out.println("reduce(List[\"a\",\"b\",\"c\",\"d\",\"e\"], (acc, x) -> acc + x.charAt(0), 0) -> " + result5);
    }
}

