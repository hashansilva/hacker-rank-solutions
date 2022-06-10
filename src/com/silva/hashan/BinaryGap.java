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