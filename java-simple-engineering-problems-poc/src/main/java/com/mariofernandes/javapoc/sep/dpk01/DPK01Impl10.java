package com.mariofernandes.javapoc.sep.dpk01;

public class DPK01Impl10 {
    public String revertString(String str) {
        if (str == null || str.length() <= 1) {
            return str;
        }

        int begin = str.length() / 2;
        int lengthMinusOne = str.length() - 1;
        char[] reverted = str.toCharArray();

        for (int i = begin; i < str.length(); i++) {
            char auxChar = reverted[i];
            reverted[i] = reverted[lengthMinusOne - i];
            reverted[lengthMinusOne - i] = auxChar;
        }

        return new String(reverted);
    }

    public static void main(String[] args) {
        System.out.println("--> DPK 01 - Implementation 10 <--");
        DPK01Impl10 dpk01Impl10 = new DPK01Impl10();
        String str = "Mario Romulo";

        String reverted = dpk01Impl10.revertString(str);

        System.out.println("Original: " + str);
        System.out.println("Reverted: " + reverted);
        System.out.println(" -- // -- ");
    }
}
