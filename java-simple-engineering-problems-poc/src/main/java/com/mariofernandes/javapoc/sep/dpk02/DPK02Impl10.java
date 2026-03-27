package com.mariofernandes.javapoc.sep.dpk02;

import java.util.Arrays;
import java.util.List;

public class DPK02Impl10 {
    public <T> void revert(List<T> list) {
        if (list == null || list.size() <= 1) {
            return;
        }

        int max = list.size() / 2;
        int sizeMinusOne = list.size() - 1;
        for (int i = 0; i < max; i++) {
            var aux = list.get(i);
            list.set(i, list.get(sizeMinusOne - i));
            list.set(sizeMinusOne - i, aux);
        }
    }

    public static void main(String[] args) {
        System.out.println("--> DPK 02 - Implementation 10 <--");
        DPK02Impl10 dpk02Impl10 = new DPK02Impl10();

        var list = Arrays.asList(1,2,3,4,5);
        System.out.println("Before revert: " + list);

        dpk02Impl10.revert(list);

        System.out.println("After revert: " + list);
        System.out.println(" -- // -- ");
    }
}
