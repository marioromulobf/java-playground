package com.mariofernandes.javapoc.sep.dpk02;

import java.util.ArrayList;
import java.util.List;

public class DPK02Impl8 {
    public <T> List<T> revert(List<T> list) {
        if (list == null || list.size() <= 1) {
            return list;
        }

        var result = new ArrayList<>(list);
        int max = list.size() / 2;
        for (int i = 1; i < max; i++) {
            var aux = list.get(i - 1);
            result.set(i, list.get(list.size() - i));
            result.set(list.size() - i, aux);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println("--> DPK 02 - Implementation 8 <--");
        DPK02Impl8 dpk02Impl8 = new DPK02Impl8();

        var list = List.of(1,2,3,4,5);
        System.out.println("Before revert: " + list);

        var result = dpk02Impl8.revert(list);

        System.out.println("After revert: " + result);
        System.out.println(" -- // -- ");
    }
}
