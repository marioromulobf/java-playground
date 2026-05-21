package com.mariofernandes.javapoc.sep.dpk09;

public class DPK09Impl6 {

    public interface Filter<T> {
        boolean test(T t);
    }

    public<T> int filter(T[] items, Filter<T> filter) {
        validateItems(items);
        validateFilter(filter);

        int writeIndex = 0;
        for (T item : items) {
            if (filter.test(item)) {
                items[writeIndex++] = item;
            }
        }

        for (int i = writeIndex; i < items.length; i++) {
            items[i] = null;
        }

        return writeIndex;
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

    public<T> String toString(T[] result) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < result.length; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(result[i]);
        }
        sb.append("]");

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("--> DPK 09 - Implementation 06 <--");
        DPK09Impl6 dpk09Impl6 = new DPK09Impl6();

        var input1 = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        var result = dpk09Impl6.filter(input1, (x) -> x % 2 == 0);
        System.out.println("filter([1, 2, 3, 4, 5, 6, 7, 8, 9, 10], (x) -> x % 2 == 0) -> "
                + dpk09Impl6.toString(input1) + " - " + result);

        // char to decimal: 'a': 97; 'b': 98'; c': 99'; d': 100'; e': 101'; f': 102'; g': 103'; h': 104'; i': 105'; j': 106
        var input2 = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};
        var result2 = dpk09Impl6.filter(input2, (term) -> term.charAt(0) % 2 == 0);
        System.out.println("filter([\"a\",\"b\",\"c\",\"d\",\"e\",\"f\",\"g\",\"h\",\"i\",\"j\"], (term) -> term.charAt(0) % 2 == 0) -> "
                + dpk09Impl6.toString(input2) + " - " + result2);
    }
}
