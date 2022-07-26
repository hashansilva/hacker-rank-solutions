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
import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class MigratoryBirds {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.migratoryBirds(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

    private static class Result {
        public static int migratoryBirds(List<Integer> arr) {
            List<Integer> sortedArr = arr.stream().sorted().collect(toList());
            HashMap<Integer, Integer> resultMap = new HashMap<>();
            int count = 1;
            for (int i = 1; i < sortedArr.size(); i++) {
                if (sortedArr.get(i) != sortedArr.get(i - 1)) {
                    resultMap.put(sortedArr.get(i - 1), count);
                    count = 1;
                } else {
                    count++;
                    if (i == sortedArr.size() - 1) {
                        resultMap.put(sortedArr.get(i), count);
                    }
                }
            }
            return Collections.max(resultMap.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
        }
    }
}
