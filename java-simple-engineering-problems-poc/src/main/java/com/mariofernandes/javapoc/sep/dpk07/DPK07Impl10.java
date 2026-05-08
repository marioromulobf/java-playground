package com.mariofernandes.javapoc.sep.dpk07;

import java.lang.reflect.Array;

public class DPK07Impl10 {

    public<T> T[][] groupBy(T[] items, int groupSize) {
        if (items == null || groupSize <= 0) {
            throw new IllegalArgumentException();
        }

        int numberOfGroups = (items.length + groupSize - 1) / groupSize;
        Class<?> componentType = items.getClass().getComponentType();
        T[][] result = (T[][]) Array.newInstance(componentType, numberOfGroups, 0);
        int count = 0;

        for (int i = 0; i < numberOfGroups; i++) {
            int currentGroupSize = items.length - count;
            if (groupSize < currentGroupSize) {
                currentGroupSize = groupSize;
            }

            result[i] = buildGroup(items, count, currentGroupSize, componentType);

            count += currentGroupSize;
        }

        return result;
    }

    private<T> T[] buildGroup(T[] items, int start, int length, Class<?> componentType) {
        T[] group = (T[]) Array.newInstance(componentType, length);

        for (int i = 0; i < length; i++) {
            group[i] = items[start + i];
        }

        return group;
    }

    public<T> String toString(T[][] result) {
        StringBuilder sb = new StringBuilder("[");

        for (int i = 0; i < result.length; i++) {
            if (i > 0) {
                sb.append(", ");
            }

            sb.append("[");
            for (int j = 0; j < result[i].length; j++) {
                if (j > 0) {
                    sb.append(", ");
                }

                sb.append(result[i][j]);
            }
            sb.append("]");
        }
        sb.append("]");

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("--> DPK 07 - Implementation 10 <--");
        DPK07Impl10 dpk07Impl10 = new DPK07Impl10();

        var result = dpk07Impl10.groupBy(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 3);
        System.out.println("groupBy([1, 2, 3, 4, 5, 6, 7, 8, 9, 10], 3) -> " + dpk07Impl10.toString(result));

        var result2 = dpk07Impl10.groupBy(new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"}, 3);
        System.out.println("groupBy([\"a\",\"b\",\"c\",\"d\",\"e\",\"f\",\"g\",\"h\",\"i\",\"j\"], 3) -> " + dpk07Impl10.toString(result2));
    }
}

