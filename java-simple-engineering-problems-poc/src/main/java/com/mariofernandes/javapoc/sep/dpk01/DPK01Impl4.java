package com.mariofernandes.javapoc.sep.dpk01;

public class DPK01Impl4 {
    public String revertString(String str) {
        String reverted = "";
        int count = 1;

        while (count <= str.length()) {
            reverted += str.charAt(str.length() - count);
            count++;
        }

        return reverted;
    }

    public static void main(String[] args) {
        System.out.println("--> DPK 01 - Implementation 04 <--");
        DPK01Impl4 dpk01Impl4 = new DPK01Impl4();
        String str = "Mario Romulo";

        String reverted = dpk01Impl4.revertString(str);

        System.out.println("Original: " + str);
        System.out.println("Reverted: " + reverted);
        System.out.println(" -- // -- ");
    }
}
