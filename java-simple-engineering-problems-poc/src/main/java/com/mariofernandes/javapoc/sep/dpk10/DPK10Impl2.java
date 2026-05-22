package com.mariofernandes.javapoc.sep.dpk10;

public class DPK10Impl2 {

    public interface Reducer<T> {
        T apply(T accumulator, T item);
    }

    public<T> T reduce(T[] items, Reducer<T> reducer, T initial) {
        validateItems(items);
        validateReducer(reducer);
        validateInitialValue(initial);

        var accumulator = initial;

        for (T item : items) {
            accumulator = reducer.apply(accumulator, item);
        }

        return accumulator;
    }

    private static<T> void validateItems(T[] items) {
        if (items == null) {
            throw new IllegalArgumentException();
        }
    }

    private static<T> void validateReducer(Reducer<T> reducer) {
        if (reducer == null) {
            throw new IllegalArgumentException();
        }
    }

    private static<T> void validateInitialValue(T initial) {
        if (initial == null) {
            throw new IllegalArgumentException();
        }
    }

    public static void main(String[] args) {
        System.out.println("--> DPK 10 - Implementation 02 <--");
        DPK10Impl2 dpk10Impl2 = new DPK10Impl2();

        var input1 = new Integer[]{1, 2, 3, 4, 5};
        var result = dpk10Impl2.reduce(input1, (acc, x) -> acc + x, 0);
        System.out.println("reduce([1, 2, 3, 4, 5], (acc, x) -> acc + x, 0) -> " + result);

        // char to decimal: 'a': 97; 'b': 98'; c': 99'; d': 100'; e': 101'
        var input2 = new String[]{"a", "b", "c", "d", "e"};
        var result2 = dpk10Impl2.reduce(input2, (acc, x) -> acc + x, "");
        System.out.println("reduce([\"a\",\"b\",\"c\",\"d\",\"e\"], (acc, x) -> acc + x, \"\") -> " + result2);
    }
}

