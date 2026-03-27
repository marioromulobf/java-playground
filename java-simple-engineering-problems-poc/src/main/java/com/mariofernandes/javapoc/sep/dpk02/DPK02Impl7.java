package com.mariofernandes.javapoc.sep.dpk02;

import java.util.ArrayList;
import java.util.List;

public class DPK02Impl7 {
    public <T> List<T> revert(List<T> list) {
        if (list == null || list.size() <= 1) {
            return list;
        }

        var result = new ArrayList<T>();
        for (int i = 1; i <= list.size(); i++) {
            result.add(list.get(list.size() - i));
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println("--> DPK 02 - Implementation 7 <--");
        DPK02Impl7 dpk02Impl7 = new DPK02Impl7();

        var list = List.of(1,2,3,4,5);
        System.out.println("Before revert: " + list);

        var result = dpk02Impl7.revert(list);

        System.out.println("After revert: " + result);
        System.out.println(" -- // -- ");
    }
}
