package com.mariofernandes.javapoc.sep.dpk01;

public class DPK01Impl5 {
    public String revertString(String str) {
        String reverted = "";

        for (int i = str.length() - 1; i >= 0; i--) {
            reverted += str.charAt(i);
        }

        return reverted;
    }

    public static void main(String[] args) {
        System.out.println("--> DPK 01 - Implementation 05 <--");
        DPK01Impl5 dpk01Impl4 = new DPK01Impl5();
        String str = "Mario Romulo";

        String reverted = dpk01Impl4.revertString(str);

        System.out.println("Original: " + str);
        System.out.println("Reverted: " + reverted);
        System.out.println(" -- // -- ");
    }
}
