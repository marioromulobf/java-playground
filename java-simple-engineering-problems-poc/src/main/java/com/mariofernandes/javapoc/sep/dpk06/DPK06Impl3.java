package com.mariofernandes.javapoc.sep.dpk06;

import java.util.ArrayList;
import java.util.List;

public class DPK06Impl3 {

    public List<String> tokenize(String data, String token) {
        List<String> result = new ArrayList<>();

        if (data == null || data.isEmpty() || token == null || token.isEmpty()) {
            return result;
        }

        int start = 0;

        for (int i = 0; i < data.length(); i++) {
            if (matchToken(data, token, i)) {
                result.add(data.substring(start, i));
                start = i + token.length();
            }
        }
        result.add(data.substring(start));

        return result;
    }

    private boolean matchToken(String data, String token, int index) {
        for (int i = 0; i < token.length(); i++) {
            if (data.charAt(index + i) != token.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("--> DPK 06 - Implementation 03 <--");
        DPK06Impl3 dpk06Impl3 = new DPK06Impl3();

        var result = dpk06Impl3.tokenize("Hello,World,How,Are,You", ",");
        System.out.println("tokenize(\"Hello,World,How,Are,You\", \",\") -> " + result);

        result = dpk06Impl3.tokenize("Hello World How Are You", " ");
        System.out.println("tokenize(\"Hello World How Are You\", \" \") -> " + result);

        result = dpk06Impl3.tokenize("Hello-World-How-Are-You", "-");
        System.out.println("tokenize(\"Hello-World-How-Are-You\", \"-\") -> " + result);

        result = dpk06Impl3.tokenize("Hello--World--How--Are--You", "--");
        System.out.println("tokenize(\"Hello--World--How--Are--You\", \"--\") -> " + result);
    }
}

