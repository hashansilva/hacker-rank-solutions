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

package com.hackerrank.challenges.implementation;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class SalesByMatch {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ar = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.sockMerchant(n, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

    private static class Result {
        public static int sockMerchant(int n, List<Integer> ar) {
            int matchedSocks = 0;
            HashMap<Integer, Integer> sockMap = new HashMap<>();
            ar.forEach(value -> {
                if (sockMap.containsKey(value)) {
                    int count = sockMap.get(value);
                    count++;
                    sockMap.replace(value, count);
                }else {
                    sockMap.put(value, 1);
                }
            });
            for (Integer value : sockMap.values()) {
                matchedSocks = matchedSocks + (value / 2);
            }
            return matchedSocks;
        }
    }
}
