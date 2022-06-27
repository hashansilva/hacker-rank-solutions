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

package com.amazon.challenges;

import java.util.*;

public class MaxRiceSet {
    public static void main(String[] args) {
        List<Integer> riceBags = new ArrayList<>();
        riceBags.add(3);
        riceBags.add(4);
        riceBags.add(25);
        riceBags.add(625);
        riceBags.add(9);
        riceBags.add(2);
        riceBags.add(5);

        System.out.println(getMaxRiceSet(riceBags));
    }

    private static int getMaxRiceSet(List<Integer> riceBags) {
        Collections.sort(riceBags);
        HashMap<Double, Integer> resultMap = new HashMap<>();
        for (Integer riceBag : riceBags) {
            double riceBagSqrt = Math.sqrt(riceBag.doubleValue());
            if (resultMap.containsKey(riceBagSqrt)) {
                int count = resultMap.get(riceBagSqrt) +1 ;
                resultMap.put(Double.valueOf(riceBag), count);

            } else {
                resultMap.put(Double.valueOf(riceBag), 1);
            }
        }
        if (!resultMap.isEmpty()) {
            return Collections.max(resultMap.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getValue();
        }
        return -1;
    }
}
