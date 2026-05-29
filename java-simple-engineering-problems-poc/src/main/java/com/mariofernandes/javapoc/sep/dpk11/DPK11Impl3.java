package com.mariofernandes.javapoc.sep.dpk11;

public class DPK11Impl3 {

    public String replace(String source, String oldToken, String newToken) {
        StringBuilder result = new StringBuilder();
        char separator = extractSeparator(oldToken);

        for (int i = 0; i < source.length();) {
            if (matchesAt(source, oldToken, i)) {
                result.append(newToken);
                i += oldToken.length();
            } else if (separator == source.charAt(i)) {
                result.append(newToken);
                i++;
            } else {
                result.append(source.charAt(i));
                i++;
            }
        }

        return result.toString();
    }

    private boolean matchesAt(String source, String token, int start) {
        if (start + token.length() > source.length()) {
            return false;
        }

        for (int i = 0; i < token.length(); i++) {
            if (source.charAt(start + i) != token.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    private char extractSeparator(String token) {
        if (token.length() == 1) {
            return token.charAt(0);
        }

        if (token.charAt(0) == token.charAt(token.length() - 1)) {
            return token.charAt(0);
        }

        return 0;
    }

    public static void main(String[] args) {
        System.out.println("--> DPK 11 - Implementation 03 <--");
        DPK11Impl3 dpk11Impl3 = new DPK11Impl3();

        var input1 = "Hello,World,How,Are,You";
        var result1 = dpk11Impl3.replace(input1, ",", "-");
        System.out.println("replace(\"Hello,World,How,Are,You\", \",\", \"-\") -> " + result1);

        var result2 = dpk11Impl3.replace(input1, ",World,", "-");
        System.out.println("replace(\"Hello,World,How,Are,You\", \",World,\", \"-\") -> " + result2);
    }
}

