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

public class CeaserCyper {

    public static String CaesarCipher(String str, int num) {
        // code goes here
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isLetter(c)) {
                if (Character.isUpperCase(c)) {
                    c = (char) ('A' + (c - 'A' + num) % 26);
                } else {
                    c = (char) ('a' + (c - 'a' + num) % 26);
                }
            } else if (Character.isDigit(c)) {
                c = (char) ('0' + (c - '0' + num) % 10);
            }
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        // keep this function call here
        System.out.println(CaesarCipher("abc", 0));
        System.out.println(CaesarCipher("Hello", 4));
        System.out.println(CaesarCipher("Caesar Cipher", 2));
    }

}
