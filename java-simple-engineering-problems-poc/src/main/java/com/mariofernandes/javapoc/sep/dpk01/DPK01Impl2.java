package com.mariofernandes.javapoc.sep.dpk01;

public class DPK01Impl2 {
    public String revertString(String str) {
        int length = str.length();
        char[] reverted = new char[length];

        for (int i = 0; i < length; i++) {
            reverted[length - i - 1] = str.charAt(i);
        }

        return new String(reverted);
    }

    public static void main(String[] args) {
        DPK01Impl2 dpk01Impl2 = new DPK01Impl2();
        String str = "Mario Romulo";

        String reverted = dpk01Impl2.revertString(str);

        System.out.println("Original: " + str);
        System.out.println("Reverted: " + reverted);
    }
}
