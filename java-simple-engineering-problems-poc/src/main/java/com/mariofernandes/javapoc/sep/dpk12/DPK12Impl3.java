package com.mariofernandes.javapoc.sep.dpk12;

import java.util.ArrayList;
import java.util.List;

public class DPK12Impl3 {

    public void bubbleSort(int[] items) {
        for (int end = items.length - 1; end > 0; end--) {
            boolean swapped = false;

            for (int i = 0; i < end; i++) {
                if (items[i] > items[i + 1]) {
                    int temp = items[i];

                    items[i] = items[i + 1];
                    items[i + 1] = temp;

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

    public static String toString(int[] items) {
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

    public static void main(String[] args) {
        System.out.println("--> DPK 12 - Implementation 03 <--");
        DPK12Impl3 dpk12Impl3 = new DPK12Impl3();

        var input1 = new int[]{5,4,3,2,1};
        System.out.print("bubbleSort(" + DPK12Impl3.toString(input1) + ") -> ");
        var startTime = System.nanoTime();
        dpk12Impl3.bubbleSort(input1);
        var endTime = System.nanoTime();
        System.out.println(DPK12Impl3.toString(input1) + " - " + (endTime - startTime) + " nanoseconds");

        var input2 = new int[]{1,4,3,2,5};
        System.out.print("bubbleSort(" + DPK12Impl3.toString(input2) + ") -> ");
        startTime = System.nanoTime();
        dpk12Impl3.bubbleSort(input2);
        endTime = System.nanoTime();
        System.out.println(DPK12Impl3.toString(input2) + " - " + (endTime - startTime) + " nanoseconds");

        var input3 = new int[]{1,2,3,4,5};
        System.out.print("bubbleSort(" + DPK12Impl3.toString(input3) + ") -> ");
        startTime = System.nanoTime();
        dpk12Impl3.bubbleSort(input3);
        endTime = System.nanoTime();
        System.out.println(DPK12Impl3.toString(input3) + " - " + (endTime - startTime) + " nanoseconds");

        var input4 = new ArrayList<>(List.of(5,4,3,2,1));
        System.out.print("bubbleSort(" + input4 + ") -> ");
        startTime = System.nanoTime();
        dpk12Impl3.bubbleSort(input4);
        endTime = System.nanoTime();
        System.out.println(input4 + " - " + (endTime - startTime) + " nanoseconds");
    }
}

