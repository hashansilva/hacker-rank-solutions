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

import java.util.Arrays;
import java.util.HashSet;

public class DemoTest {
    public int solution(int[] A) {
        // write your code in Java SE 8
        Arrays.sort(A);
        int result = 1;
        for (int i : A) {
            if (i == result) {
                result++;
            }
        }

        return result;
    }
}
