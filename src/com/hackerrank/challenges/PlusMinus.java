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

package com.hackerrank.challenges;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class PlusMinus {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result.plusMinus(arr);

        bufferedReader.close();
    }

    private static class Result {
        public static void plusMinus(List<Integer> arr) {
            double positiveCount = 0;
            double zeroCount = 0;
            double minusCount = 0;
            double arrayLength = arr.size();
            for (Integer value : arr) {
                if (value > 0) {
                    positiveCount++;
                } else if (value == 0) {
                    zeroCount++;
                } else {
                    minusCount++;
                }
            }
            DecimalFormat df = new DecimalFormat();
            df.setMaximumFractionDigits(6);
            System.out.println(df.format(positiveCount / arrayLength));
            System.out.println(df.format(minusCount / arrayLength));
            System.out.println(df.format(zeroCount / arrayLength));
        }
    }
}
