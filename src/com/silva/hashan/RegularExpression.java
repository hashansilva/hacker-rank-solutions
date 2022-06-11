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

package com.silva.hashan;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Hacker Rank
 */
public class RegularExpression {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        // Write your code here.
        List<String> words = Arrays.stream(s.split("\\P{Alpha}|\\S|![!,?._'@]+]")).filter(word -> word.trim().length() > 0).collect(Collectors.toList());
        System.out.println(words.size());
        for (String word : words) {
            System.out.println(word);
        }
        scan.close();
    }
}
