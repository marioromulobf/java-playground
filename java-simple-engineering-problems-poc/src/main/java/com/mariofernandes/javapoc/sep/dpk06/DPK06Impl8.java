package com.mariofernandes.javapoc.sep.dpk06;

import java.util.ArrayList;
import java.util.List;

public class DPK06Impl8 {

    public List<String> tokenize(String text, String token) {
        List<String> result = new ArrayList<>();

        if (text == null || token == null || token.isEmpty()) {
            throw new IllegalArgumentException();
        }

        if (text.isEmpty()) {
            result.add("");
            return result;
        }

        int start = 0;

        for (int i = 0; i < text.length();) {
            if (matchToken(text, token, i)) {
                result.add(extract(text, start, i));
                i += token.length();
                start = i;
            } else {
                i++;
            }
        }
        result.add(extract(text, start, text.length()));

        return result;
    }

    private boolean matchToken(String text, String token, int index) {
        if (index + token.length() > text.length()) {
            return false;
        }

        for (int i = 0; i < token.length(); i++) {
            if (text.charAt(index + i) != token.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    private String extract(String text, int start, int end) {
        StringBuilder sb = new StringBuilder();

        for (int i = start; i < end; i++) {
            sb.append(text.charAt(i));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("--> DPK 06 - Implementation 08 <--");
        DPK06Impl8 dpk06Impl8 = new DPK06Impl8();

        var result = dpk06Impl8.tokenize("Hello,World,How,Are,You", ",");
        System.out.println("tokenize(\"Hello,World,How,Are,You\", \",\") -> " + result);

        result = dpk06Impl8.tokenize("Hello World How Are You", " ");
        System.out.println("tokenize(\"Hello World How Are You\", \" \") -> " + result);

        result = dpk06Impl8.tokenize("Hello-World-How-Are-You", "-");
        System.out.println("tokenize(\"Hello-World-How-Are-You\", \"-\") -> " + result);

        result = dpk06Impl8.tokenize("Hello--World--How--Are--You", "--");
        System.out.println("tokenize(\"Hello--World--How--Are--You\", \"--\") -> " + result);
    }
}

