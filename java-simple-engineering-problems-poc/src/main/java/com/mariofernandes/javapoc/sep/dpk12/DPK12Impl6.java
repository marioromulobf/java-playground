package com.mariofernandes.javapoc.sep.dpk12;

import java.util.ArrayList;
import java.util.List;

public class DPK12Impl6 {

    public interface Sortable {
        int size();
        int get(int index);
        void set(int index, int value);
    }

    public static class ArraySortable implements Sortable {
        private final int[] items;

        public ArraySortable(int[] items) {
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
        public int get(int index) {
            return items[index];
        }

        @Override
        public void set(int index, int value) {
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

    static class ListSortable implements Sortable {
        private final List<Integer> items;

        public ListSortable(List<Integer> items) {
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
        public int get(int index) {
            return items.get(index);
        }

        @Override
        public void set(int index, int value) {
            items.set(index, value);
        }

        @Override
        public String toString() {
            return "" +  items;
        }
    }

    public void bubbleSort(Sortable items) {
        for (int end = items.size() - 1; end > 0; end--) {
            boolean swapped = false;

            for (int i = 0; i < end; i++) {
                if (items.get(i) > items.get(i + 1)) {
                    swap(items, i, i + 1);

                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }
    }

    private void swap(Sortable items, int index, int nextIndex) {
        int temp = items.get(index);

        items.set(index, items.get(nextIndex));
        items.set(nextIndex, temp);
    }

    public static void main(String[] args) {
        System.out.println("--> DPK 12 - Implementation 06 <--");
        DPK12Impl6 dpk12Impl6 = new DPK12Impl6();

        var input1 = new ArraySortable(new int[]{5,4,3,2,1});
        System.out.print("bubbleSort(" + input1 + ") -> ");
        var startTime = System.nanoTime();
        dpk12Impl6.bubbleSort(input1);
        var endTime = System.nanoTime();
        System.out.println(input1 + " - " + (endTime - startTime) + " nanoseconds");

        var input2 = new ArraySortable(new int[]{1,4,3,2,5});
        System.out.print("bubbleSort(" + input2 + ") -> ");
        startTime = System.nanoTime();
        dpk12Impl6.bubbleSort(input2);
        endTime = System.nanoTime();
        System.out.println(input2 + " - " + (endTime - startTime) + " nanoseconds");

        var input3 = new ArraySortable(new int[]{1,2,3,4,5});
        System.out.print("bubbleSort(" + input3 + ") -> ");
        startTime = System.nanoTime();
        dpk12Impl6.bubbleSort(input3);
        endTime = System.nanoTime();
        System.out.println(input3 + " - " + (endTime - startTime) + " nanoseconds");

        var input4 = new ListSortable(new ArrayList<>(List.of(5,4,3,2,1)));
        System.out.print("bubbleSort(" + input4 + ") -> ");
        startTime = System.nanoTime();
        dpk12Impl6.bubbleSort(input4);
        endTime = System.nanoTime();
        System.out.println(input4 + " - " + (endTime - startTime) + " nanoseconds");
    }
}

