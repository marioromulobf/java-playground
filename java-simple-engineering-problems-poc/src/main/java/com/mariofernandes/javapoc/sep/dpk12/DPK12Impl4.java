package com.mariofernandes.javapoc.sep.dpk12;

import java.util.ArrayList;
import java.util.List;

public class DPK12Impl4 {

    interface Sortable {
        int size();
        int get(int index);
        void set(int index, int value);
        String toString();
    }

    public static class ArraySortable implements Sortable {
        private final int[] items;

        public ArraySortable(int[] items) {
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

    public void bubbleSort(ArraySortable items) {
        for (int end = items.size() - 1; end > 0; end--) {
            boolean swapped = false;

            for (int i = 0; i < end; i++) {
                if (items.get(i) > items.get(i + 1)) {
                    int temp = items.get(i);

                    items.set(i, items.get(i + 1));
                    items.set(i + 1, temp);

                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }
    }

    public void bubbleSort(List<Integer> items) {
        for (int end = items.size() - 1; end > 0; end--) {
            boolean swapped = false;

            for (int i = 0; i < end; i++) {
                if (items.get(i) > items.get(i + 1)) {
                    int temp = items.get(i);

                    items.set(i, items.get(i + 1));
                    items.set(i + 1, temp);

                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("--> DPK 12 - Implementation 04 <--");
        DPK12Impl4 dpk12Impl4 = new DPK12Impl4();

        var input1 = new ArraySortable(new int[]{5,4,3,2,1});
        System.out.print("bubbleSort(" + input1 + ") -> ");
        var startTime = System.nanoTime();
        dpk12Impl4.bubbleSort(input1);
        var endTime = System.nanoTime();
        System.out.println(input1 + " - " + (endTime - startTime) + " nanoseconds");

        var input2 = new ArraySortable(new int[]{1,4,3,2,5});
        System.out.print("bubbleSort(" + input2 + ") -> ");
        startTime = System.nanoTime();
        dpk12Impl4.bubbleSort(input2);
        endTime = System.nanoTime();
        System.out.println(input2 + " - " + (endTime - startTime) + " nanoseconds");

        var input3 = new ArraySortable(new int[]{1,2,3,4,5});
        System.out.print("bubbleSort(" + input3 + ") -> ");
        startTime = System.nanoTime();
        dpk12Impl4.bubbleSort(input3);
        endTime = System.nanoTime();
        System.out.println(input3 + " - " + (endTime - startTime) + " nanoseconds");

        var input4 = new ArrayList<>(List.of(5,4,3,2,1));
        System.out.print("bubbleSort(" + input4 + ") -> ");
        startTime = System.nanoTime();
        dpk12Impl4.bubbleSort(input4);
        endTime = System.nanoTime();
        System.out.println(input4 + " - " + (endTime - startTime) + " nanoseconds");
    }
}

