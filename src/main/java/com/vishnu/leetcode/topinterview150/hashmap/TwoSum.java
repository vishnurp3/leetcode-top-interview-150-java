package com.vishnu.leetcode.topinterview150.hashmap;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numberToIndex = new HashMap<>();

        for (int index = 0; index < nums.length; index++) {
            int currentNumber = nums[index];
            int complement = target - currentNumber;

            if (numberToIndex.containsKey(complement)) {
                return new int[]{numberToIndex.get(complement), index};
            }
            numberToIndex.put(currentNumber, index);
        }
        return new int[0];
    }
}
