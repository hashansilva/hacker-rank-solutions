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
import java.util.stream.IntStream;

public class UtopianTree {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                int result = Result.utopianTree(n);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }

    private static class Result {

        private static final int SPRING = 1;
        private static final int SUMMER = 2;

        public static int utopianTree(int n) {
            int treeHeight = 1;
            int cycle = Result.SPRING;
            for (int i = 0; i < n; i++) {
                switch (cycle) {
                    case SUMMER:
                        treeHeight = treeHeight + 1;
                        cycle = SPRING;
                        break;
                    case SPRING:
                        treeHeight = treeHeight * 2;
                        cycle = SUMMER;
                        break;
                }
            }
            return treeHeight;

        }
    }
}
