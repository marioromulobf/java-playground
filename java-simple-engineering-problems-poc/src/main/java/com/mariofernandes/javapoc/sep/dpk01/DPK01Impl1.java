package com.mariofernandes.javapoc.sep.dpk01;

public class DPK01Impl1 {
    public String revertString(String str) {
        String reverted = "";

        for (int i = str.length(); i > 0; i--) {
            reverted += str.charAt(i - 1);
        }

        return reverted;
    }

    public static void main(String[] args) {
        DPK01Impl1 dpkImpl1 = new DPK01Impl1();
        String str = "Mario Romulo";
        String reverted = dpkImpl1.revertString(str);
        System.out.println("Original: " + str);
        System.out.println("Reverted: " + reverted);
    }
}
