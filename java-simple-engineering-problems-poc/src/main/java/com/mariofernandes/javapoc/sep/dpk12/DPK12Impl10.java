package com.mariofernandes.javapoc.sep.dpk12;

import java.util.ArrayList;
import java.util.List;

public class DPK12Impl10 {

    public interface Sortable<T> {
        int size();
        T get(int index);
        void set(int index, T value);

        default void swap(int left, int right) {
            T temp = get(left);

            set(left, get(right));
            set(right, temp);
        }

        static<T> Sortable<T> from(T[] items) {
            return new ArraySortable<>(items);
        }

        static<T> Sortable<T> from(List<T> items) {
            return new ListSortable<>(items);
        }
    }

    public interface Comparator<T> {
        boolean shouldSwap(T left, T right);
    }

    public static class ArraySortable<T> implements Sortable<T> {
        private final T[] items;

        public ArraySortable(T[] items) {
            if (items == null) {
                throw new IllegalArgumentException();
            }
            this.items = items;
        }

        @Override
        public int size() {
            return items.length;
        }

        @Override
        public T get(int index) {
            return items[index];
        }

        @Override
        public void set(int index, T value) {
            items[index] = value;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder("[");
            for (int i = 0; i < items.length; i++) {
                if (i > 0) {
                    sb.append(", ");
                }
                sb.append(items[i]);
            }
            sb.append("]");

            return sb.toString();
        }
    }

    public static class ListSortable<T> implements Sortable<T> {
        private final List<T> items;

        public ListSortable(List<T> items) {
            if (items == null) {
                throw new IllegalArgumentException();
            }
            this.items = items;
        }

        @Override
        public int size() {
            return items.size();
        }

        @Override
        public T get(int index) {
            return items.get(index);
        }

        @Override
        public void set(int index, T value) {
            items.set(index, value);
        }

        @Override
        public String toString() {
            return "" +  items;
        }
    }

    public<T> void bubbleSort(Sortable<T> items, Comparator<T> comparator) {
        if (items == null) {
            throw new IllegalArgumentException();
        }
        if (comparator == null) {
            throw new IllegalArgumentException();
        }

        for (int end = items.size() - 1; end > 0; end--) {
            boolean swapped = false;

            for (int i = 0; i < end; i++) {
                if (comparator.shouldSwap(items.get(i), items.get(i + 1))) {
                    items.swap(i, i + 1);

                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("--> DPK 12 - Implementation 09 <--");
        DPK12Impl10 dpk12Impl9 = new DPK12Impl10();

        var input1 = Sortable.from(new Integer[]{5,4,3,2,1});
        System.out.print("bubbleSort(" + input1 + ") -> ");
        var startTime = System.nanoTime();
        dpk12Impl9.bubbleSort(input1, (a, b) -> a > b);
        var endTime = System.nanoTime();
        System.out.println(input1 + " - " + (endTime - startTime) + " nanoseconds");

        var input2 = Sortable.from(new Integer[]{1,4,3,2,5});
        System.out.print("bubbleSort(" + input2 + ") -> ");
        startTime = System.nanoTime();
        dpk12Impl9.bubbleSort(input2, (a, b) -> a > b);
        endTime = System.nanoTime();
        System.out.println(input2 + " - " + (endTime - startTime) + " nanoseconds");

        var input3 = Sortable.from(new Integer[]{1,2,3,4,5});
        System.out.print("bubbleSort(" + input3 + ") -> ");
        startTime = System.nanoTime();
        dpk12Impl9.bubbleSort(input3, (a, b) -> a > b);
        endTime = System.nanoTime();
        System.out.println(input3 + " - " + (endTime - startTime) + " nanoseconds");

        var input4 = Sortable.from(new ArrayList<>(List.of(5,4,3,2,1)));
        System.out.print("bubbleSort(" + input4 + ") -> ");
        startTime = System.nanoTime();
        dpk12Impl9.bubbleSort(input4, (a, b) -> a > b);
        endTime = System.nanoTime();
        System.out.println(input4 + " - " + (endTime - startTime) + " nanoseconds");
    }
}

