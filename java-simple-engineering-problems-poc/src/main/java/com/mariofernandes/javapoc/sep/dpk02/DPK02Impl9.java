package com.mariofernandes.javapoc.sep.dpk02;

import java.util.Arrays;
import java.util.List;

public class DPK02Impl9 {
    public <T> void revert(List<T> list) {
        if (list == null || list.size() <= 1) {
            return;
        }

        int max = list.size() / 2;
        for (int i = 1; i <= max; i++) {
            var aux = list.get(i - 1);
            list.set(i - 1, list.get(list.size() - i));
            list.set(list.size() - i, aux);
        }
    }

    public static void main(String[] args) {
        System.out.println("--> DPK 02 - Implementation 9 <--");
        DPK02Impl9 dpk02Impl9 = new DPK02Impl9();

        var list = Arrays.asList(1,2,3,4,5);
        System.out.println("Before revert: " + list);

        dpk02Impl9.revert(list);

        System.out.println("After revert: " + list);
        System.out.println(" -- // -- ");
    }
}
