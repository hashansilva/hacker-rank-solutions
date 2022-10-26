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

package com.codesignal.challenges;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        String[] wordList = new String[]{"hot", "dot", "dog","lot","log","cog"};
        int solution = solution(beginWord, endWord, wordList);
        System.out.println(solution);
    }

    private static int solution(String beginWord, String endWord, String[] wordList) {
        beginWord = beginWord.toLowerCase();
        endWord = endWord.toLowerCase();
        Set<String> wordsSet = new HashSet<>();
        for(String word:wordList)
        {
            wordsSet.add(word.toLowerCase());
        }


        if(beginWord.equals(endWord)){
            return 0;
        }

        if(!wordsSet.contains(endWord)){
            return 0;
        }

        int level = 0;
        int wordLength = beginWord.length();

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        while(!queue.isEmpty()){

            ++level;
            int queueSize = queue.size();

            for(int i =0;i<queueSize;i++){

                char[] wordChars = queue.peek().toCharArray();
                queue.remove();

                for(int j = 0; j < wordLength; j++){
                    char originalChar = wordChars[j];

                    for(char character='a'; character<= 'z'; ++character){
                        wordChars[j] = character;
                        String variation = new String(wordChars);
                        if(variation.equals(endWord)){
                            return level+1;
                        }
                        if(!wordsSet.contains(variation)){
                            continue;
                        }
                        wordsSet.remove(variation);
                        queue.add(variation);

                    }
                    wordChars[j] = originalChar;
                }
            }
        }
        return 0;
    }
}
