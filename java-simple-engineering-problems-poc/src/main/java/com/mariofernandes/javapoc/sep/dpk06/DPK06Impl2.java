package com.mariofernandes.javapoc.sep.dpk06;

import java.util.ArrayList;
import java.util.List;

public class DPK06Impl2 {

    public List<String> tokenize(String data, String token) {
        List<String> result = new ArrayList<>();

        if (data == null || data.isEmpty() || token == null || token.isEmpty()) {
            return result;
        }

        int start = 0;

        for (int i = 0; i < data.length(); i++) {
            if (token.charAt(0) == data.charAt(i)) {
                result.add(data.substring(start, i));
                start = i + 1;
            }
        }
        result.add(data.substring(start));

        return result;
    }

    public static void main(String[] args) {
        System.out.println("--> DPK 06 - Implementation 02 <--");
        DPK06Impl2 dpk06Impl2 = new DPK06Impl2();

        var result = dpk06Impl2.tokenize("Hello,World,How,Are,You", ",");
        System.out.println("tokenize(\"Hello,World,How,Are,You\", \",\") -> " + result);

        result = dpk06Impl2.tokenize("Hello World How Are You", " ");
        System.out.println("tokenize(\"Hello World How Are You\", \" \") -> " + result);

        result = dpk06Impl2.tokenize("Hello-World-How-Are-You", "-");
        System.out.println("tokenize(\"Hello-World-How-Are-You\", \"-\") -> " + result);
    }
}

