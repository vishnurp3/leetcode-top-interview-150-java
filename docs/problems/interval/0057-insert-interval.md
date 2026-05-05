# 0057. Insert Interval

## Link

[LeetCode - Insert Interval](https://leetcode.com/problems/insert-interval/)

## Problem Summary

You are given an array of non-overlapping `intervals` sorted by their start time and a `newInterval` to insert. Insert
`newInterval` into `intervals` such that `intervals` is still sorted by start time and contains no overlapping
intervals (merge overlapping intervals if necessary).

## Examples

- **Input:** `intervals = [[1,3],[6,9]]`, `newInterval = [2,5]`
- **Output:** `[[1,5],[6,9]]`

- **Input:** `intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]]`, `newInterval = [4,8]`
- **Output:** `[[1,2],[3,10],[12,16]]`
- **Explanation:** Because the new interval `[4,8]` overlaps with `[3,5],[6,7],[8,10]`.

## Constraints

- $0 \le intervals.length \le 10^4$
- $intervals[i].length == 2$
- $0 \le intervals[i][0] \le intervals[i][1] \le 10^5$
- `intervals` is sorted by `intervals[i][0]` in ascending order.
- `newInterval.length == 2`
- $0 \le newInterval[0] \le newInterval[1] \le 10^5$

## Approach

Because the input `intervals` array is already sorted, we can achieve an $O(n)$ solution by traversing the array
linearly and constructing the result:

1. **Non-overlapping Before:** Iterate and add all intervals that end strictly before `newInterval` starts.
2. **Merge Overlapping:** For all intervals that overlap with `newInterval`, update `newInterval`'s start to the minimum
   of starts and its end to the maximum of ends. Add this merged `newInterval` to the result.
3. **Non-overlapping After:** Add all remaining intervals that start strictly after the merged `newInterval` ends.

## Complexity

- **Time Complexity:** $O(n)$, where $n$ is the number of intervals. We traverse the array exactly once.
- **Space Complexity:** $O(n)$ to store the new list of intervals before converting it back to an array.

## Edge Cases

- **Empty Intervals List:** The loop conditions will simply fall through, and just the `newInterval` will be added.
- **`newInterval` at Extremes:** Handled naturally; if it belongs at the very beginning or very end, step 2 executes
  once and the appropriate while-loops in steps 1 or 3 take care of the rest.
- **`newInterval` Encompasses All:** If `newInterval` covers all existing intervals, they will all be consumed in step
  2, resulting in a single large interval.

## Notes

The fact that the initial array is sorted is the key to achieving $O(n)$ instead of $O(n \log n)$. This problem is a
more specialized, optimized version of "Merge Intervals" (Problem 0056).