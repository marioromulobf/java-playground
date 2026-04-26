package com.mariofernandes.javapoc.sep.dpk06;

import java.util.ArrayList;
import java.util.List;

public class DPK06Impl1 {

    public List<String> tokenize(String data, String token) {
        int startIndex = 0;
        List<String> result = new ArrayList<>();

        for (int i = 0; i < data.length(); i++) {
            if (token.charAt(0) == data.charAt(i)) {
                result.add(data.substring(startIndex, i));
                startIndex = i + 1;
            }
        }
        result.add(data.substring(startIndex));

        return result;
    }

    public static void main(String[] args) {
        System.out.println("--> DPK 06 - Implementation 01 <--");
        DPK06Impl1 dpk06Impl1 = new DPK06Impl1();

        var result = dpk06Impl1.tokenize("Hello,World,How,Are,You", ",");
        System.out.println("tokenize(\"Hello,World,How,Are,You\", \",\") -> " + result);

        result = dpk06Impl1.tokenize("Hello World How Are You", " ");
        System.out.println("tokenize(\"Hello World How Are You\", \" \") -> " + result);

        result = dpk06Impl1.tokenize("Hello-World-How-Are-You", "-");
        System.out.println("tokenize(\"Hello-World-How-Are-You\", \"-\") -> " + result);
    }
}

