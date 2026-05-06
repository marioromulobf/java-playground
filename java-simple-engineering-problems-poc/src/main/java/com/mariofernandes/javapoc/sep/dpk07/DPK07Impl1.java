package com.mariofernandes.javapoc.sep.dpk07;

import java.util.ArrayList;
import java.util.List;

public class DPK07Impl1 {

    public<T> List<List<T>> groupBy(List<T> items, int sizeGroup) {
        List<List<T>> result = new ArrayList<>();

        if (items.size() <= sizeGroup) {
            result.add(items);
            return result;
        }

        List<T> subList = new ArrayList<>(sizeGroup);
        int countBySizeGroup = 0;
        for (int i = 0; (countBySizeGroup + i) < items.size(); i++) {
            if (subList.size() == sizeGroup) {
                result.add(subList);
                subList = new ArrayList<>(sizeGroup);
                i = 0;
                countBySizeGroup = result.size() * sizeGroup;
            }
            subList.add(items.get(countBySizeGroup + i));
        }

        if (subList.size() > 0) {
            result.add(subList);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println("--> DPK 07 - Implementation 01 <--");
        DPK07Impl1 dpk07Impl1 = new DPK07Impl1();

        var result = dpk07Impl1.groupBy(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 3);
        System.out.println("groupBy([1, 2, 3, 4, 5, 6, 7, 8, 9, 10], 3) -> " + result);

        var result2 = dpk07Impl1.groupBy(List.of("a", "b", "c", "d", "e", "f", "g", "h", "i", "j"), 3);
        System.out.println("groupBy([\"a\",\"b\",\"c\",\"d\",\"e\",\"f\",\"g\",\"h\",\"i\",\"j\"], 3) -> " + result2);
    }
}

