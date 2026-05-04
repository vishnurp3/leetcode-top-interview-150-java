package com.vishnu.leetcode.topinterview150.interval;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return result;
        }

        for (int index = 0; index < nums.length; index++) {
            int start = nums[index];
            while (index + 1 < nums.length && nums[index + 1] == nums[index] + 1) {
                index++;
            }
            if (start == nums[index]) {
                result.add(String.valueOf(start));
            } else {
                result.add(start + "->" + nums[index]);
            }
        }
        return result;
    }
}
