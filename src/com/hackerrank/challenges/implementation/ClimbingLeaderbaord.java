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

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ClimbingLeaderbaord {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int rankedCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ranked = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int playerCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> player = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = climbingLeaderboard(ranked, player);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }

    private static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        // Create a list of unique scores from the ranked list to represent the distinct ranks
        List<Integer> uniqueRanks = new ArrayList<>();
        uniqueRanks.add(ranked.get(0)); // Add the first element to start the list

        // Iterate through the ranked list to collect unique scores only
        for (int i = 1; i < ranked.size(); i++) {
            if (!ranked.get(i).equals(ranked.get(i - 1))) {
                uniqueRanks.add(ranked.get(i)); // Add score if it is different from the previous one
            }
        }

        // Result list to store the rank for each player's score
        List<Integer> result = new ArrayList<>();
        int index = uniqueRanks.size() - 1; // Start from the end of the uniqueRanks list

        // Iterate over each score in the player's list
        for (int score : player) {
            // Traverse the uniqueRanks from the end to find the correct rank for the current player's score
            while (index >= 0 && score >= uniqueRanks.get(index)) {
                index--; // Move left until we find where the player's score fits
            }
            // Calculate the rank (index + 2) because:
            // - index is 0-based, but rank is 1-based.
            // - Adding 2 adjusts for when we step past the valid position (index will be -1 when at the leftmost).
            result.add(index + 2);
        }

        // Return the list of ranks for the player's scores
        return result;
    }
}
