package com.mariofernandes.javapoc.sep.dpk02;

import java.util.Arrays;

public class DPK02Impl2 {
    public <T> void revert(T[] list) {
        if (list == null || list.length <= 1) {
            return;
        }

        int min = list.length / 2;
        for (int i = list.length; i > min; i--) {
            var aux = list[i - 1];
            list[i - 1] = list[list.length - i];
            list[list.length - i] = aux;
        }
    }

    public static void main(String[] args) {
        System.out.println("--> DPK 02 - Implementation 2 <--");
        DPK02Impl2 dpk02Impl2 = new DPK02Impl2();

        var list = new Integer[]{ 1,2,3,4,5 };
        System.out.println("Before revert: " + Arrays.toString(list));

        dpk02Impl2.revert(list);

        System.out.println("After revert: " + Arrays.toString(list));
        System.out.println(" -- // -- ");
    }
}
