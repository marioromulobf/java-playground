package com.mariofernandes.javapoc.sep.dpk02;

import java.util.ArrayList;
import java.util.List;

public class DPK02Impl4 {
    public <T> List<T> revert(List<T> list) {
        if (list == null || list.size() <= 1) {
            return list;
        }

        var result = new ArrayList<T>();
        int count = list.size() - 1;
        while (result.size() < list.size()) {
            result.add(list.get(count));
            count--;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println("--> DPK 02 - Implementation 4 <--");
        DPK02Impl4 dpk02Impl4 = new DPK02Impl4();

        var list = List.of(1,2,3,4,5);
        System.out.println("Before revert: " + list);

        var result = dpk02Impl4.revert(list);

        System.out.println("After revert: " + result);
        System.out.println(" -- // -- ");
    }
}
