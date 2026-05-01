package com.vishnu.leetcode.topinterview150.hashmap;

public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] characterFrequency = new int[26];
        for (int index = 0; index < s.length(); index++) {
            characterFrequency[s.charAt(index) - 'a']++;
            characterFrequency[t.charAt(index) - 'a']--;
        }

        for (int frequency : characterFrequency) {
            if (frequency != 0) {
                return false;
            }
        }
        return true;
    }
}
