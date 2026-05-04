# 0228. Summary Ranges

## Link

[LeetCode - Summary Ranges](https://leetcode.com/problems/summary-ranges/)

## Problem Summary

Return the smallest sorted list of ranges that cover all numbers in a sorted unique integer array. Each element
`nums[i]` is mapped to either a single value `"a"` (if no consecutive elements follow) or a range `"a->b"`.

## Examples

- **Input:** `nums = [0,1,2,4,5,7]`
- **Output:** `["0->2","4->5","7"]`

## Constraints

- $0 \le nums.length \le 20$
- $-2^{31} \le nums[i] \le 2^{31} - 1$
- All the values of `nums` are **unique**.
- `nums` is sorted in ascending order.

## Approach

1. **Two-Pointer Iteration:** Since the array is already sorted, we can iterate through the array once.
2. **Find Contiguous Segments:** Use a pointer (or index `i`) to track the start of a potential range. Use a nested loop
   or condition to increment the index as long as `nums[i + 1] == nums[i] + 1`.
3. **String Formatting:** Once the end of a contiguous segment is reached:
    - If `start == end`, add the single number to the list.
    - If `start != end`, format it as `"start->end"`.

## Complexity

- **Time Complexity:** $O(n)$, where $n$ is the length of the array. Each element is visited exactly once.
- **Space Complexity:** $O(1)$ if we don't count the space required for the output list.

## Edge Cases

- **Empty Array:** Returns an empty list.
- **Single Element:** Returns that element as a single string.
- **No Consecutive Elements:** Returns each element as its own range.
- **Integer Overflow:** While the problem uses `nums[i] + 1`, we must be careful if the range spans the limit of
  `Integer.MAX_VALUE`. However, since $nums[i+1]$ is also an integer, the comparison `nums[i+1] == nums[i] + 1` is safe
  as long as we don't exceed array bounds.

## Notes

This is a classic "two-pointer" or "sliding window" logic problem applied to ranges. The key is to leverage the sorted
property of the input array.