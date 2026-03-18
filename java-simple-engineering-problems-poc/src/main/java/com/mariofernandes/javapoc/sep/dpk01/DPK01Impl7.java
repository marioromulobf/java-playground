package com.mariofernandes.javapoc.sep.dpk01;

public class DPK01Impl7 {
    public String revertString(String str) {
        int length = str.length();
        int lengthMinusOne = length - 1;
        char[] reverted = new char[length];

        for (int i = 0; i < length; i++) {
            reverted[i] = str.charAt(lengthMinusOne - i);
        }

        return new String(reverted);
    }

    public static void main(String[] args) {
        System.out.println("--> DPK 01 - Implementation 07 <--");
        DPK01Impl7 dpk01Impl7 = new DPK01Impl7();
        String str = "Mario Romulo";

        String reverted = dpk01Impl7.revertString(str);

        System.out.println("Original: " + str);
        System.out.println("Reverted: " + reverted);
        System.out.println(" -- // -- ");
    }
}
