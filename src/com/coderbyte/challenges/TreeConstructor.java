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

import java.util.*;

public class TreeConstructor {
    public static String TreeConstructor(String[] strArr) {
        // code goes here
        // Map to store parent-child relationships
        Map<Integer, Integer> parentMap = new HashMap<>();
        // Set to keep track of child nodes
        Set<Integer> childSet = new HashSet<>();

        for (String pair : strArr) {
            String[] nodes = pair.substring(1, pair.length() - 1).split(",");
            int child = Integer.parseInt(nodes[0]);
            int parent = Integer.parseInt(nodes[1]);

            // Check if the same child has more than one parent
            if (parentMap.containsKey(child)) {
                return "false";
            }

            // Check if there is a cycle
            if (hasCycle(parentMap, childSet, child, parent)) {
                return "false";
            }

            // Add parent-child relationship to the map
            parentMap.put(child, parent);
            // Add child node to the set
            childSet.add(child);
        }

        // Check if there is only one root node (no parent)
        int rootCount = 0;
        for (int child : childSet) {
            if (!parentMap.containsKey(child)) {
                rootCount++;
                if (rootCount > 1) {
                    return "false";
                }
            }
        }

        // If all conditions are met, it is a valid tree
        return "true";
    }

    private static boolean hasCycle(Map<Integer, Integer> parentMap, Set<Integer> childSet, int child, int parent) {
        while (parent != 0) {
            // If the parent is already a child of some other node, there is a cycle
            if (childSet.contains(parent)) {
                return true;
            }
            parent = parentMap.getOrDefault(parent, 0);
        }
        return false;
    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print(TreeConstructor(new String[]{s.nextLine()}));
    }
}
