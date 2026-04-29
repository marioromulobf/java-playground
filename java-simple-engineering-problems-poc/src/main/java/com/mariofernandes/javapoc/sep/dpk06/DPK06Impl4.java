package com.mariofernandes.javapoc.sep.dpk06;

import java.util.ArrayList;
import java.util.List;

public class DPK06Impl4 {

    public List<String> tokenize(String data, String token) {
        List<String> result = new ArrayList<>();

        if (data == null || data.isEmpty() || token == null || token.isEmpty()) {
            return result;
        }

        int start = 0;

        for (int i = 0; i < data.length(); i++) {
            if (matchToken(data, token, i)) {
                result.add(extract(data, start, i));
                start = i + token.length();
            }
        }
        result.add(extract(data, start, data.length()));

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

    private String extract(String data, int start, int end) {
        StringBuilder sb = new StringBuilder();

        for (int i = start; i < end; i++) {
            sb.append(data.charAt(i));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("--> DPK 06 - Implementation 04 <--");
        DPK06Impl4 dpk06Impl4 = new DPK06Impl4();

        var result = dpk06Impl4.tokenize("Hello,World,How,Are,You", ",");
        System.out.println("tokenize(\"Hello,World,How,Are,You\", \",\") -> " + result);

        result = dpk06Impl4.tokenize("Hello World How Are You", " ");
        System.out.println("tokenize(\"Hello World How Are You\", \" \") -> " + result);

        result = dpk06Impl4.tokenize("Hello-World-How-Are-You", "-");
        System.out.println("tokenize(\"Hello-World-How-Are-You\", \"-\") -> " + result);

        result = dpk06Impl4.tokenize("Hello--World--How--Are--You", "--");
        System.out.println("tokenize(\"Hello--World--How--Are--You\", \"--\") -> " + result);
    }
}

