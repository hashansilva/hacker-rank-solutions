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

public class RotateMatrix {
    public static void main(String[] args) {
        int[][] inputMatrix = new int[][]{{1, 2, 3,}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(Arrays.deepToString(inputMatrix));
        System.out.println(Arrays.deepToString(solution(inputMatrix)));
    }

    private static int[][] solution(int[][] inputMatrix) {
        int length = inputMatrix.length;
        int[][] outputMatrix = new int[length][length];
        for (int i = 0; i <= length - 1; i++) {
            for (int j = 0; j <= length - 1; j++) {
                outputMatrix[j][length - i - 1] = inputMatrix[i][j];
            }
        }
        return outputMatrix;
    }
}
