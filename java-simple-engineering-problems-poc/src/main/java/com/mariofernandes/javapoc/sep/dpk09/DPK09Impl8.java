package com.mariofernandes.javapoc.sep.dpk09;

public class DPK09Impl8 {

    public interface Filter<T> {
        boolean test(T t);
    }

    public<T> int filterInPlace(T[] items, Filter<T> filter) {
        validateItems(items);
        validateFilter(filter);

        int validItemsCount = 0;
        for (T item : items) {
            if (filter.test(item)) {
                items[validItemsCount] = item;
                validItemsCount++;
            }
        }
        clearRemaining(items, validItemsCount);

        return validItemsCount;
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

    private<T> void clearRemaining(T[] items, int start) {
        for (int i = start; i < items.length; i++) {
            items[i] = null;
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
        System.out.println("--> DPK 09 - Implementation 08 <--");
        DPK09Impl8 dpk09Impl8 = new DPK09Impl8();

        var input1 = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        var validLength1 = dpk09Impl8.filterInPlace(input1, (x) -> x % 2 == 0);
        System.out.println("filter([1, 2, 3, 4, 5, 6, 7, 8, 9, 10], (x) -> x % 2 == 0) -> "
                + dpk09Impl8.toString(input1, validLength1));

        // char to decimal: 'a': 97; 'b': 98'; c': 99'; d': 100'; e': 101'; f': 102'; g': 103'; h': 104'; i': 105'; j': 106
        var input2 = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};
        var validLength2 = dpk09Impl8.filterInPlace(input2, (term) -> term.charAt(0) % 2 == 0);
        System.out.println("filter([\"a\",\"b\",\"c\",\"d\",\"e\",\"f\",\"g\",\"h\",\"i\",\"j\"], (term) -> term.charAt(0) % 2 == 0) -> "
                + dpk09Impl8.toString(input2, validLength2));
    }
}
