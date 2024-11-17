/*
 * Copyright (c) 2024. Hashan Silva
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

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Result {
    public static int saveThePrisoner(int n, int m, int s) {
        // Calculate the last prisoner to receive a candy
        return (s - 1 + m - 1) % n + 1;
    }

    public static List<Integer> circularArrayRotation(List<Integer> a, int k, List<Integer> queries) {
        List<Integer> result;
        HashMap<Integer, Integer> rotatedArrayMap = new HashMap<>();
        IntStream.range(0, a.size()).forEach(i -> {
            int newPosition = i + (k % a.size());
            rotatedArrayMap.put(newPosition, a.get(i));
        });
        result = queries.stream().map(rotatedArrayMap::get).collect(Collectors.toList());
        return result;
    }

    public static List<Integer> permutationEquation(List<Integer> p) {
        List<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> numberPositionMap = new HashMap<>();
        int position = 0;
        for (Integer number : p) {
            numberPositionMap.put(number, position);
            position++;
        }

        for (int i = 1; i <= p.size(); i++) {
            int tempPosition = numberPositionMap.get(i);
            int existingPosition = numberPositionMap.get(tempPosition);
            result.add(p.get(existingPosition));
        }
        return result;
    }

    public static int jumpingOnClouds(int[] c, int k) {
        int energy = 100;
        int cloudPosition = 0;
        int cloudLength = c.length;
        do {
            cloudPosition = (cloudPosition + k) % cloudLength;
            if (c[cloudPosition] == 1) {
                energy = energy - 2;
            }
            energy = energy - 1;

        } while (cloudPosition == 0);
        return energy;
    }

    public static int findDigits(int n) {
        int result = 0;
        String numberAsString = String.valueOf(n);
        for (char digitAsChar : numberAsString.toCharArray()) {
            int digit = Integer.parseInt(String.valueOf(digitAsChar));
            if (digit > 0 && n % digit == 0) {
                result++;
            }
        }
        return result;
    }

    public static void extraLongFactorials(int n) {
        BigInteger result = BigInteger.valueOf(1);
        do {
            result = result.multiply(BigInteger.valueOf(n));
            n = n - 1;
        } while (n > 0);
        System.out.println(result);
    }
}
