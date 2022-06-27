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

public class SmallerElement {
    public static void main(String[] args) {
        int[] input = new int[]{3, 4, 9, 6, 1};
        System.out.println(Arrays.toString(solution(input)));
    }

    private static int[] solution(int[] input) {
        int[] result = new int[input.length];
        for (int i = 0; i < input.length - 1; i++) {
            int count = 0;
            for (int j = i; j <= input.length - 1; j++) {
                if (input[i] > input[j]) {
                    count++;
                }
            }
            result[i] = count;
        }
        return result;
    }
}
