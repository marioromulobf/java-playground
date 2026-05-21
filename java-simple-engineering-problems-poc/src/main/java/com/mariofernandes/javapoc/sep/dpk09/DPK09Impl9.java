package com.mariofernandes.javapoc.sep.dpk09;

import java.lang.reflect.Array;

public class DPK09Impl9 {

    public interface Filter<T> {
        boolean test(T t);
    }

    public<T> T[] filter(T[] items, Filter<T> filter) {
        validateItems(items);
        validateFilter(filter);

        int validItemsCount = countValidItems(items, filter);
        T[] result = (T[]) Array.newInstance(items.getClass().getComponentType(), validItemsCount);
        int writeIndex = 0;

        for (T item : items) {
            if (filter.test(item)) {
                result[writeIndex] = item;
                writeIndex++;
            }
        }

        return result;
    }

    private<T> int countValidItems(T[] items, Filter<T> filter) {
        int count = 0;

        for (T item : items) {
            if (filter.test(item)) {
                count++;
            }
        }

        return count;
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

    public<T> String toString(T[] items, int validLength) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < validLength; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(items[i]);
        }
        sb.append("]");

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("--> DPK 09 - Implementation 09 <--");
        DPK09Impl9 dpk09Impl9 = new DPK09Impl9();

        var input1 = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        var result1 = dpk09Impl9.filter(input1, (x) -> x % 2 == 0);
        System.out.println("filter([1, 2, 3, 4, 5, 6, 7, 8, 9, 10], (x) -> x % 2 == 0) -> "
                + dpk09Impl9.toString(result1, result1.length));

        // char to decimal: 'a': 97; 'b': 98'; c': 99'; d': 100'; e': 101'; f': 102'; g': 103'; h': 104'; i': 105'; j': 106
        var input2 = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};
        var result2 = dpk09Impl9.filter(input2, (term) -> term.charAt(0) % 2 == 0);
        System.out.println("filter([\"a\",\"b\",\"c\",\"d\",\"e\",\"f\",\"g\",\"h\",\"i\",\"j\"], (term) -> term.charAt(0) % 2 == 0) -> "
                + dpk09Impl9.toString(result2, result2.length));
    }
}
