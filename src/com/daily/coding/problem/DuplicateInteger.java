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

package com.daily.coding.problem;

import java.util.Arrays;

public class DuplicateInteger {
    public static void main(String[] args) {
        int[] inputArray = new int[]{5, 4, 5, 2, 3, 1};
        System.out.println(solution(inputArray));
    }

    private static int solution(int[] inputArray) {
        Arrays.sort(inputArray);
        int arrayLength = inputArray.length-1;
        int totalSum = (arrayLength * (arrayLength+1))/2;
        int tempSum = 0;
        for (int input : inputArray) {
            tempSum = tempSum + input;
        }
        return Math.abs(totalSum - tempSum);
    }
}
