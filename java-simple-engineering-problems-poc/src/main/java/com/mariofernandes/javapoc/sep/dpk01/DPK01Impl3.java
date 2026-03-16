package com.mariofernandes.javapoc.sep.dpk01;

public class DPK01Impl3 {
    public String revertString(String str) {
        int length = str.length();
        int lengthMinusOne = length - 1;
        char[] reverted = new char[length];


        for (int i = 0; i < length; i++) {
            reverted[lengthMinusOne - i] = str.charAt(i);
        }

        return new String(reverted);
    }

    public static void main(String[] args) {
        DPK01Impl3 dpk01Impl3 = new DPK01Impl3();
        String str = "Mario Romulo";

        String reverted = dpk01Impl3.revertString(str);

        System.out.println("Original: " + str);
        System.out.println("Reverted: " + reverted);
    }
}
