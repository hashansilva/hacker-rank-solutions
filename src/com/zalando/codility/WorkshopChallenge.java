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

package com.zalando.codility;

import java.util.*;

public class WorkshopChallenge {

    public int solution(String[] E) {
        // write your code in Java SE 8
        HashMap<Integer, List<Integer>> availableEmployees = new HashMap<>();
        HashMap<Integer, Integer> resultMap = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            availableEmployees.put(i, new ArrayList<>());
            resultMap.put(i, 0);
        }
        for (int e = 0; e < E.length; e++) {
            char[] daysE = E[e].toCharArray();
            for (char dayChar : daysE) {
                if (Character.isDigit(dayChar)) {
                    int dayNum = Character.getNumericValue(dayChar);
                    availableEmployees.get(dayNum).add(e);
                }
            }
        }
        availableEmployees.forEach((day, value) -> {
            availableEmployees.forEach((key, value1) -> {
                Set<Integer> tempSet = new HashSet<>();
                tempSet.addAll(value);
                tempSet.addAll(value1);
                resultMap.put(day, Math.max(tempSet.size(), resultMap.get(day)));
            });
        });
        return Collections.max(resultMap.values());
    }
}
