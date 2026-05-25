package com.mariofernandes.javapoc.sep.dpk11;

public class DPK11Impl1 {

    public String replace(String string, String oldToken, String newToken) {
        char[] chars = new char[string.length()];
        char newChar = newToken.charAt(0);
        char oldChar = oldToken.charAt(0);
        int discount = 0;

        int tokenLength = oldToken.length() - 1;
        if (tokenLength > 0 && oldToken.charAt(tokenLength) != oldChar) {
            oldChar = 0;
        }

        for (int i = 0; i < string.length(); i++) {
            chars[i - discount] = string.charAt(i);
            if (chars[i - discount] == oldChar) {
                if (isDelimiterAt(string, oldToken, i)) {
                    discount += tokenLength;
                    i += tokenLength;
                    chars[i - discount] = newChar;
                } else {
                    chars[i - discount] = newChar;
                }
            }
        }

        return new String(chars);
    }

    private boolean isDelimiterAt(String input, String delimiter, int start) {
        if (delimiter.length() == 1) {
            return false;
        }
        if (start + delimiter.length() > input.length()) {
            return false;
        }

        for (int i = 0; i < delimiter.length(); i++) {
            if (input.charAt(start + i) != delimiter.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("--> DPK 11 - Implementation 01 <--");
        DPK11Impl1 dpk10Impl1 = new DPK11Impl1();

        var input1 = "Hello,World,How,Are,You";
        var result1 = dpk10Impl1.replace(input1, ",", "-");
        System.out.println("replace(\"Hello,World,How,Are,You\", \",\", \"-\") -> " + result1);

        var result2 = dpk10Impl1.replace(input1, ",World,", "-");
        System.out.println("replace(\"Hello,World,How,Are,You\", \",World,\", \"-\") -> " + result2);
    }
}

