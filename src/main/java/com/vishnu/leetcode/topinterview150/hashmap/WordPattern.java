package com.vishnu.leetcode.topinterview150.hashmap;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {

    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (pattern.length() != words.length) {
            return false;
        }

        Map<Character, String> patternToWord = new HashMap<>();
        Map<String, Character> wordToPattern = new HashMap<>();

        for (int index = 0; index < words.length; index++) {
            char patternCharacter = pattern.charAt(index);
            String word = words[index];
            String mappedWord = patternToWord.get(patternCharacter);
            Character mappedPatternCharacter = wordToPattern.get(word);

            if (mappedWord != null && !mappedWord.equals(word)) {
                return false;
            }

            if (mappedPatternCharacter != null && mappedPatternCharacter != patternCharacter) {
                return false;
            }

            patternToWord.put(patternCharacter, word);
            wordToPattern.put(word, patternCharacter);
        }
        return true;
    }
}