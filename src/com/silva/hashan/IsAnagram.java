package com.silva.hashan;

import java.util.Arrays;
import java.util.Scanner;

public class IsAnagram {

    static boolean isAnagram(String a, String b) {
        // Complete the function
        if (a.length() != b.length()) {
            return false;
        }
        a = a.toLowerCase();
        b = b.toLowerCase();

        int[] aInt = new int[256];
        int[] bInt = new int[256];

        for (int i = 0; i < a.length(); i++) {
            aInt[(int) a.charAt(i)] += 1;
            bInt[(int) b.charAt(i)] += 1;
        }

        for (int i = 0; i < 256; i++) {
            if (aInt[i] != bInt[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println((ret) ? "Anagrams" : "Not Anagrams");
    }
}