package com.mariofernandes.javapoc.sep.dpk06;

import java.util.ArrayList;
import java.util.List;

public class DPK06Impl7 {

    public List<String> tokenize(String data, String token) {
        List<String> result = new ArrayList<>();

        if (data == null || token == null || token.isEmpty()) {
            throw new IllegalArgumentException();
        }

        if (data.isEmpty()) {
            return List.of("");
        }

        int start = 0;

        for (int i = 0; i < data.length();) {
            if (matchToken(data, token, i)) {
                result.add(extract(data, start, i));
                i += token.length();
                start = i;
            } else {
                i++;
            }
        }
        result.add(extract(data, start, data.length()));

        return result;
    }

    private boolean matchToken(String data, String token, int index) {
        if (index + token.length() > data.length()) {
            return false;
        }

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
        System.out.println("--> DPK 06 - Implementation 07 <--");
        DPK06Impl7 dpk06Impl7 = new DPK06Impl7();

        var result = dpk06Impl7.tokenize("Hello,World,How,Are,You", ",");
        System.out.println("tokenize(\"Hello,World,How,Are,You\", \",\") -> " + result);

        result = dpk06Impl7.tokenize("Hello World How Are You", " ");
        System.out.println("tokenize(\"Hello World How Are You\", \" \") -> " + result);

        result = dpk06Impl7.tokenize("Hello-World-How-Are-You", "-");
        System.out.println("tokenize(\"Hello-World-How-Are-You\", \"-\") -> " + result);

        result = dpk06Impl7.tokenize("Hello--World--How--Are--You", "--");
        System.out.println("tokenize(\"Hello--World--How--Are--You\", \"--\") -> " + result);
    }
}

