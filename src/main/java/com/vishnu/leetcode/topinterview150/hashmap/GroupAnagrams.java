package com.vishnu.leetcode.topinterview150.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groupedAnagrams = new HashMap<>();

        for (String word : strs) {
            int[] characterFrequency = new int[26];
            for (int index = 0; index < word.length(); index++) {
                characterFrequency[word.charAt(index) - 'a']++;
            }

            String key = buildKey(characterFrequency);

            groupedAnagrams
                    .computeIfAbsent(key, ignored -> new ArrayList<>())
                    .add(word);
        }
        return new ArrayList<>(groupedAnagrams.values());
    }

    private String buildKey(int[] characterFrequency) {
        StringBuilder keyBuilder = new StringBuilder();
        for (int count : characterFrequency) {
            keyBuilder.append('#').append(count);
        }
        return keyBuilder.toString();
    }
}
