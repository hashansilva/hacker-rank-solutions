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

public class ReverseBinary {
    public static void main(String[] args) {
        String inputString = "11110000111100001111000011110000";
        System.out.println(solution(inputString));
    }

    private static String solution(String inputString) {
        StringBuilder outputStringBuilder = new StringBuilder();
        for (char inputChar : inputString.toCharArray()) {
            char reverseChar = inputChar == '1' ? '0' : '1';
            outputStringBuilder.append(reverseChar);
        }
        return outputStringBuilder.toString();
    }
}
