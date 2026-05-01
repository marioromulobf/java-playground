package com.mariofernandes.javapoc.sep.dpk06;

import java.util.ArrayList;
import java.util.List;

public class DPK06Impl9 {

    public List<String> tokenize(String text, String delimiter) {
        validateInput(text, delimiter);

        List<String> result = new ArrayList<>();

        if (text.isEmpty()) {
            result.add("");
            return result;
        }

        int tokenStart = 0;

        for (int i = 0; i < text.length();) {
            if (matchToken(text, delimiter, i)) {
                result.add(extract(text, tokenStart, i));
                i += delimiter.length();
                tokenStart = i;
            } else {
                i++;
            }
        }
        result.add(extract(text, tokenStart, text.length()));

        return result;
    }

    private void validateInput(String text, String delimiter) {
        if (text == null || delimiter == null || delimiter.isEmpty()) {
            throw new IllegalArgumentException();
        }
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
        System.out.println("--> DPK 06 - Implementation 09 <--");
        DPK06Impl9 dpk06Impl9 = new DPK06Impl9();

        var result = dpk06Impl9.tokenize("Hello,World,How,Are,You", ",");
        System.out.println("tokenize(\"Hello,World,How,Are,You\", \",\") -> " + result);

        result = dpk06Impl9.tokenize("Hello World How Are You", " ");
        System.out.println("tokenize(\"Hello World How Are You\", \" \") -> " + result);

        result = dpk06Impl9.tokenize("Hello-World-How-Are-You", "-");
        System.out.println("tokenize(\"Hello-World-How-Are-You\", \"-\") -> " + result);

        result = dpk06Impl9.tokenize("Hello--World--How--Are--You", "--");
        System.out.println("tokenize(\"Hello--World--How--Are--You\", \"--\") -> " + result);
    }
}

