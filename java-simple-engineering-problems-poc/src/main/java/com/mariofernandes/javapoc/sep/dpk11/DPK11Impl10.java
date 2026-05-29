package com.mariofernandes.javapoc.sep.dpk11;

public class DPK11Impl10 {

    private final TokenMatcher tokenMatcher;

    public DPK11Impl10(TokenMatcher tokenMatcher) {
        this.tokenMatcher = tokenMatcher;
    }

    public interface TokenMatcher {
        int matchLength(String source, String token, int start);

        default boolean exactMatch(String source, String token, int start) {
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

        default boolean separatorMatch(String source, String token, int start) {
            char separator = token.charAt(0);
            if (token.charAt(token.length() - 1) == separator && source.charAt(start) == separator) {
                return true;
            }
            return false;
        }
    }

    public static class ExactTokenMatcher implements TokenMatcher {
        @Override
        public int matchLength(String source, String token, int start) {
            return exactMatch(source, token, start) ? token.length() : 0;
        }
    }

    public static class DelimitedTokenMatcher implements TokenMatcher {
        @Override
        public int matchLength(String source, String token, int start) {
            if (exactMatch(source, token, start)) {
                return token.length();
            }

            return separatorMatch(source, token, start) ? 1 : 0;
        }
    }

    public String replace(String source, String oldToken, String newToken) {
        validate(source, oldToken, newToken);
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < source.length();) {
            int increment = tokenMatcher.matchLength(source, oldToken, i);
            if (increment > 0) {
                result.append(newToken);
                i += increment;
            } else {
                result.append(source.charAt(i));
                i++;
            }
        }

        return result.toString();
    }

    private void validate(String source, String oldToken, String newToken) {
        if (source == null || oldToken == null || newToken == null) {
            throw new IllegalArgumentException();
        }

        if (oldToken.length() == 0) {
            throw new IllegalArgumentException();
        }

        if (tokenMatcher == null) {
            throw new IllegalArgumentException();
        }
    }

    public static void main(String[] args) {
        System.out.println("--> DPK 11 - Implementation 10 <--");
        DPK11Impl10 dpk11Impl10 = new DPK11Impl10(new ExactTokenMatcher());

        var input1 = "Hello,World,How,Are,You";
        var result1 = dpk11Impl10.replace(input1, ",", "-");
        System.out.println("replace(\"Hello,World,How,Are,You\", \",\", \"-\") -> " + result1);

        var result2 = dpk11Impl10.replace(input1, ",World,", "-");
        result2 = dpk11Impl10.replace(result2, ",", "-");
        System.out.println("replace(\"Hello,World,How,Are,You\", \",World,\", \"-\") -> " + result2);

        dpk11Impl10 = new DPK11Impl10(new DelimitedTokenMatcher());
        var result3 = dpk11Impl10.replace(input1, ",World,", "-");
        System.out.println("replace(\"Hello,World,How,Are,You\", \",World,\", \"-\") -> " + result3);
    }
}

