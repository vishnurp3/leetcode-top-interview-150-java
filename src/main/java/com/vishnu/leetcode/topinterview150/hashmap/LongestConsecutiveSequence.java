package com.vishnu.leetcode.topinterview150.hashmap;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int longestStreak = 0;
        Set<Integer> numSet = new HashSet<>();

        for (int num : nums) {
            numSet.add(num);
        }

        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {
                int currentNumber = num;
                int currentStreak = 1;

                while (numSet.contains(currentNumber + 1)) {
                    currentNumber++;
                    currentStreak++;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }
}
