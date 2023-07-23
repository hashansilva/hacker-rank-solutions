/*
 * Copyright (c) 2023. Hashan Silva
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 */

package com.coderbyte.challenges;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MinWindowSubstring {
    public static String MinWindowSubstring(String[] strArr) {
        // code goes here
        String N = strArr[0];
        String K = strArr[1];
        Map<Character, Integer> targetFreqMap = new HashMap<>();
        for (char c : K.toCharArray()) {
            targetFreqMap.put(c, targetFreqMap.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int minLeft = 0;
        int minLength = Integer.MAX_VALUE;
        int count = K.length();

        for (int right = 0; right < N.length(); right++) {
            char rightChar = N.charAt(right);

            if (targetFreqMap.containsKey(rightChar)) {
                targetFreqMap.put(rightChar, targetFreqMap.get(rightChar) - 1);
                if (targetFreqMap.get(rightChar) >= 0) {
                    count--;
                }
            }

            while (count == 0) {
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    minLeft = left;
                }

                char leftChar = N.charAt(left);

                if (targetFreqMap.containsKey(leftChar)) {
                    targetFreqMap.put(leftChar, targetFreqMap.get(leftChar) + 1);
                    if (targetFreqMap.get(leftChar) > 0) {
                        count++;
                    }
                }

                left++;
            }
        }

        return N.substring(minLeft, minLeft + minLength);
    }

    public static void main(String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print(MinWindowSubstring(new String[]{s.nextLine()}));
    }

}
