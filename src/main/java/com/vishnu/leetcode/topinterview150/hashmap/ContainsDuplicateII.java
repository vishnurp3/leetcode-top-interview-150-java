package com.vishnu.leetcode.topinterview150.hashmap;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateII {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> numberToLatestIndex = new HashMap<>();

        for (int index = 0; index < nums.length; index++) {
            if (numberToLatestIndex.containsKey(nums[index])) {
                int previousIndex = numberToLatestIndex.get(nums[index]);
                if (index - previousIndex <= k) {
                    return true;
                }
            }
            numberToLatestIndex.put(nums[index], index);
        }
        return false;

    }
}
