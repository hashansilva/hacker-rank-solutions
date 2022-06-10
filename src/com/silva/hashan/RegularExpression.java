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
