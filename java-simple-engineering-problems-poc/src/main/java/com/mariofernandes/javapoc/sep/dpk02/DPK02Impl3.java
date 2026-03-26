package com.mariofernandes.javapoc.sep.dpk02;

import java.util.Arrays;

public class DPK02Impl3 {
    public <T> void revert(T[] list) {
        if (list == null || list.length <= 1) {
            return;
        }

        int begin = 0;
        int end = list.length - 1;
        while (end > begin) {
            var aux = list[begin];
            list[begin] = list[end];
            list[end] = aux;
            begin++;
            end--;
        }
    }

    public static void main(String[] args) {
        System.out.println("--> DPK 02 - Implementation 3 <--");
        DPK02Impl3 dpk02Impl3 = new DPK02Impl3();

        var list = new Integer[]{ 1,2,3,4,5 };
        System.out.println("Before revert: " + Arrays.toString(list));

        dpk02Impl3.revert(list);

        System.out.println("After revert: " + Arrays.toString(list));
        System.out.println(" -- // -- ");
    }
}
