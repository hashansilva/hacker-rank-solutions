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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RecurringLetter {
    public static void main(String[] args) {
        String characters = "acbbac";
        System.out.println(solution(characters));
    }

    private static String solution(String characters) {
        List<String> resultMap = new ArrayList<>();
        for (char character : characters.toCharArray()) {
            if (!resultMap.contains(String.valueOf(character))) {
                resultMap.add(String.valueOf(character));
            } else {
                return String.valueOf(character);
            }
        }
        return null;
    }
}
