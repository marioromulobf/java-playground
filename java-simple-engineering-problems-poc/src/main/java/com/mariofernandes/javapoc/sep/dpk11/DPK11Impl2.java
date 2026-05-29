package com.mariofernandes.javapoc.sep.dpk11;

public class DPK11Impl2 {

    public String replace(String string, String oldToken, String newToken) {
        StringBuilder result = new StringBuilder();
        var oldChar =  oldToken.charAt(0);
        if (oldToken.length() > 1 && oldToken.charAt(oldToken.length() - 1) != oldChar) {
            oldChar = 0;
        }

        for (int i = 0; i < string.length();) {
            if (matchesAt(string, oldToken, i)) {
                result.append(newToken);
                i += oldToken.length();
            } else if (oldChar == string.charAt(i)) {
                result.append(newToken);
                i++;
            } else {
                result.append(string.charAt(i));
                i++;
            }
        }

        return result.toString();
    }

    private boolean matchesAt(String input, String delimiter, int start) {
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
        System.out.println("--> DPK 11 - Implementation 02 <--");
        DPK11Impl2 dpk11Impl2 = new DPK11Impl2();

        var input1 = "Hello,World,How,Are,You";
        var result1 = dpk11Impl2.replace(input1, ",", "-");
        System.out.println("replace(\"Hello,World,How,Are,You\", \",\", \"-\") -> " + result1);

        var result2 = dpk11Impl2.replace(input1, ",World,", "-");
        System.out.println("replace(\"Hello,World,How,Are,You\", \",World,\", \"-\") -> " + result2);
    }
}

