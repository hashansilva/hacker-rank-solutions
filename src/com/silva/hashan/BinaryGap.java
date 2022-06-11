/*
 * Copyright (c) 2022. Hashan Silva
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

package com.silva.hashan;

/**
 * Binary Gaps - Codility
 */
class BinaryGap {
    public int solution(int N) {
        // write your code in Java SE 8
        int gaps = 0;
        int maxCount = 0;
        String binaryStr = Integer.toBinaryString(N);
        char[] charsStr = binaryStr.toCharArray();
        boolean flag = false;
        int temp = 0;
        for (char charStr : charsStr) {
            flag = !flag && !Boolean.getBoolean(String.valueOf(charStr));
            if (flag) {
                temp = temp + 1;
            }
            if (temp > 0 && !flag) {
                gaps = gaps + 1;
                temp = 0;
            }
            if (gaps > 0 && maxCount < temp) {
                maxCount = temp;
            }
        }
        return maxCount;
    }
}