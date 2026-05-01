package com.mariofernandes.javapoc.sep.dpk06;

import java.util.ArrayList;
import java.util.List;

public class DPK06Impl10 {

    public List<String> tokenize(String text, String delimiter) {
        validateInput(text, delimiter);

        List<String> result = new ArrayList<>();

        if (text.isEmpty()) {
            result.add("");
            return result;
        }

        int tokenStart = 0;

        for (int i = 0; i < text.length();) {
            if (isDelimiterAt(text, delimiter, i)) {
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

    private boolean isDelimiterAt(String text, String delimiter, int position) {
        if (position + delimiter.length() > text.length()) {
            return false;
        }

        for (int i = 0; i < delimiter.length(); i++) {
            if (text.charAt(position + i) != delimiter.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    private String extract(String text, int start, int end) {
        StringBuilder result = new StringBuilder();

        for (int i = start; i < end; i++) {
            result.append(text.charAt(i));
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println("--> DPK 06 - Implementation 10 <--");
        DPK06Impl10 dpk06Impl10 = new DPK06Impl10();

        var result = dpk06Impl10.tokenize("Hello,World,How,Are,You", ",");
        System.out.println("tokenize(\"Hello,World,How,Are,You\", \",\") -> " + result);

        result = dpk06Impl10.tokenize("Hello World How Are You", " ");
        System.out.println("tokenize(\"Hello World How Are You\", \" \") -> " + result);

        result = dpk06Impl10.tokenize("Hello-World-How-Are-You", "-");
        System.out.println("tokenize(\"Hello-World-How-Are-You\", \"-\") -> " + result);

        result = dpk06Impl10.tokenize("Hello--World--How--Are--You", "--");
        System.out.println("tokenize(\"Hello--World--How--Are--You\", \"--\") -> " + result);
    }
}

