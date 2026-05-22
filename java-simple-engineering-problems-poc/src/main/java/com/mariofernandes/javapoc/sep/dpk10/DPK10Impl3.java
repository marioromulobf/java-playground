package com.mariofernandes.javapoc.sep.dpk10;

public class DPK10Impl3 {

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

    private static<I> void validateItems(I[] items) {
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
        System.out.println("--> DPK 10 - Implementation 03 <--");
        DPK10Impl3 dpk10Impl3 = new DPK10Impl3();

        var input1 = new Integer[]{1, 2, 3, 4, 5};
        var result = dpk10Impl3.reduce(input1, (acc, x) -> acc + x, 0);
        System.out.println("reduce([1, 2, 3, 4, 5], (acc, x) -> acc + x, 0) -> " + result);

        var input2 = new String[]{"a", "b", "c", "d", "e"};
        var result2 = dpk10Impl3.reduce(input2, (acc, x) -> acc + x, "");
        System.out.println("reduce([\"a\",\"b\",\"c\",\"d\",\"e\"], (acc, x) -> acc + x, \"\") -> " + result2);

        // char to decimal: 'a': 97; 'b': 98'; c': 99'; d': 100'; e': 101'
        var result3 = dpk10Impl3.reduce(input2, (acc, x) -> acc + x.charAt(0), 0);
        System.out.println("reduce([\"a\",\"b\",\"c\",\"d\",\"e\"], (acc, x) -> acc + x.charAt(0), 0) -> " + result3);
    }
}

