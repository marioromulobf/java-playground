package com.mariofernandes.javapoc.sep.dpk12;

public class DPK12Impl1 {

    public void bubbleSort(int[] items) {
        for (int end = items.length - 1; end > 0; end--) {
            for (int i = 0; i < end; i++) {
                if (items[i] > items[i + 1]) {
                    int temp = items[i];

                    items[i] = items[i + 1];
                    items[i + 1] = temp;
                }
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
        System.out.println("--> DPK 12 - Implementation 01 <--");
        DPK12Impl1 dpk12Impl1 = new DPK12Impl1();

        var input1 = new int[]{5,4,3,2,1};
        System.out.print("bubbleSort(" + DPK12Impl1.toString(input1) + ") -> ");
        dpk12Impl1.bubbleSort(input1);
        System.out.println(DPK12Impl1.toString(input1));
    }
}

