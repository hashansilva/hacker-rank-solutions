/*
 * Copyright (c) 2023. Hashan Silva
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

package com.coderbyte.challenges;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BracketCombinations {

    public static int BracketCombinations(int num) {
        // code goes here
        List<String> combinations = new ArrayList();
        backtrack("", 0, 0, num, combinations);
        int results = combinations.size();
        return results;
    }

    private static void backtrack(String s, int left, int right, int n, List<String> combinations){
        if(s.length() == 2*n){
            combinations.add(s);
            return;
        }
        if(left < n){
            backtrack(s+"(",left+1, right, n, combinations);
        }
        if(right < left){
            backtrack(s+")",left, right+1, n, combinations);
        }
    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print(BracketCombinations(Integer.parseInt(s.nextLine())));
    }

}
