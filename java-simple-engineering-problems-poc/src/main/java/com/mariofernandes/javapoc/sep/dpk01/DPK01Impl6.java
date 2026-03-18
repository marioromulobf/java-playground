package com.mariofernandes.javapoc.sep.dpk01;

public class DPK01Impl6 {
    public String revertString(String str) {
        int length = str.length();
        char[] reverted = new char[length];

        for (int i = 0; i < length; i++) {
            reverted[i] = str.charAt(length - i - 1);
        }

        return new String(reverted);
    }

    public static void main(String[] args) {
        System.out.println("--> DPK 01 - Implementation 06 <--");
        DPK01Impl6 dpk01Impl6 = new DPK01Impl6();
        String str = "Mario Romulo";

        String reverted = dpk01Impl6.revertString(str);

        System.out.println("Original: " + str);
        System.out.println("Reverted: " + reverted);
        System.out.println(" -- // -- ");
    }
}
