# 0128. Longest Consecutive Sequence

## Link

[LeetCode - Longest Consecutive Sequence](https://leetcode.com/problems/longest-consecutive-sequence/)

## Problem Summary

Given an unsorted array of integers `nums`, return the length of the longest consecutive elements sequence. The
algorithm must run in $O(n)$ time.

## Examples

- **Input:** `nums = [100,4,200,1,3,2]`
- **Output:** `4`
- **Explanation:** The longest consecutive elements sequence is `[1, 2, 3, 4]`. Therefore its length is 4.

## Constraints

- $0 \le nums.length \le 10^5$
- $-10^9 \le nums[i] \le 10^9$

## Approach

1. **Use a HashSet:** Insert all numbers from the array into a `HashSet`. This allows for $O(1)$ average time complexity
   for lookups.
2. **Identify Sequence Starts:** Iterate through the set. A number `num` is the start of a sequence only if `num - 1` is
   not present in the set.
3. **Build the Sequence:** Once a start is found, keep checking for `num + 1`, `num + 2`, etc., in the set to determine
   the length of that specific sequence.
4. **Update Maximum:** Keep track of the maximum length found during the iteration.

## Complexity

- **Time Complexity:** $O(n)$. Although there is a nested `while` loop, each number is visited at most twice (once in
  the main loop and once in the `while` loop across all iterations).
- **Space Complexity:** $O(n)$ to store the numbers in the `HashSet`.

## Edge Cases

- **Empty Array:** Should return 0.
- **Single Element:** Should return 1.
- **Duplicates:** Handled naturally by the `HashSet`.
- **Negative Numbers:** Handled correctly by integer comparison.

## Notes

Sorting the array would lead to $O(n \log n)$, which violates the problem constraints. The key insight is identifying
the "start" of a sequence to avoid redundant work.