package com.mariofernandes.javapoc.sep.dpk11;

public class DPK11Impl6 {

    private final TokenMacher tokenMacher;

    public DPK11Impl6(TokenMacher tokenMacher) {
        this.tokenMacher = tokenMacher;
    }

    public interface TokenMacher {
        boolean matchesAt(String source, String token, int start);
    }

    public static class ExtractTokenMacher implements TokenMacher {
        @Override
        public boolean matchesAt(String source, String token, int start) {
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
    }

    public String replace(String source, String oldToken, String newToken) {
        validate(source, oldToken, newToken);
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < source.length();) {
            if (tokenMacher.matchesAt(source, oldToken, i)) {
                result.append(newToken);
                i += oldToken.length();
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
    }

    public static void main(String[] args) {
        System.out.println("--> DPK 11 - Implementation 06 <--");
        DPK11Impl6 dpk11Impl6 = new DPK11Impl6(new ExtractTokenMacher());

        var input1 = "Hello,World,How,Are,You";
        var result1 = dpk11Impl6.replace(input1, ",", "-");
        System.out.println("replace(\"Hello,World,How,Are,You\", \",\", \"-\") -> " + result1);

        var result2 = dpk11Impl6.replace(input1, ",World,", "-");
        result2 = dpk11Impl6.replace(result2, ",", "-");
        System.out.println("replace(\"Hello,World,How,Are,You\", \",World,\", \"-\") -> " + result2);
    }
}

