package com.mariofernandes.javapoc.sep.dpk01;

public class DPK01Impl8 {
    public String revertString(String str) {
        if (str == null || str.length() <= 1) {
            return str;
        }

        char[] reverted = str.toCharArray();

        for (int i = 0; i < str.length()/2; i++) {
            char auxChar = reverted[i];
            reverted[i] = reverted[str.length() - 1 - i];
            reverted[str.length() - 1 - i] = auxChar;
        }

        return new String(reverted);
    }

    public static void main(String[] args) {
        System.out.println("--> DPK 01 - Implementation 08 <--");
        DPK01Impl8 dpk01Impl8 = new DPK01Impl8();
        String str = "Mario Romulo";

        String reverted = dpk01Impl8.revertString(str);

        System.out.println("Original: " + str);
        System.out.println("Reverted: " + reverted);
        System.out.println(" -- // -- ");
    }
}
