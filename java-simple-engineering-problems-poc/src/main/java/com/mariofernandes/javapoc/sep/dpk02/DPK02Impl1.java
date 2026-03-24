package com.mariofernandes.javapoc.sep.dpk02;

import java.util.Arrays;

public class DPK02Impl1 {
    public <T> void revert(T[] list) {
        if (list == null || list.length <= 1) {
            return;
        }

        int max = list.length/2;
        for (int i=0; i < max; i++) {
            var aux = list[i];
            list[i] = list[list.length - 1 - i];
            list[list.length - 1 - i] = aux;
        }
    }

    public static void main(String[] args) {
        System.out.println("--> DPK 02 - Implementation 1 <--");
        DPK02Impl1 dpk02Impl1 = new DPK02Impl1();

        var list = new Integer[]{ 1,2,3,4,5 };
        System.out.println("Before revert: " + Arrays.toString(list));

        dpk02Impl1.revert(list);

        System.out.println("After revert: " + Arrays.toString(list));
        System.out.println(" -- // -- ");
    }
}
