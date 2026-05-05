# 0056. Merge Intervals

## Link

[LeetCode - Merge Intervals](https://leetcode.com/problems/merge-intervals/)

## Problem Summary

Given an array of `intervals` where `intervals[i] = [start_i, end_i]`, merge all overlapping intervals, and return an
array of the non-overlapping intervals that cover all the intervals in the input.

## Examples

- **Input:** `intervals = [[1,3],[2,6],[8,10],[15,18]]`
- **Output:** `[[1,6],[8,10],[15,18]]`
- **Explanation:** Since intervals `[1,3]` and `[2,6]` overlap, merge them into `[1,6]`.

- **Input:** `intervals = [[1,4],[4,5]]`
- **Output:** `[[1,5]]`
- **Explanation:** Intervals `[1,4]` and `[4,5]` are considered overlapping.

## Constraints

- $1 \le intervals.length \le 10^4$
- $intervals[i].length == 2$
- $0 \le start_i \le end_i \le 10^4$

## Approach

1. **Sort the Intervals:** First, sort the intervals based on their start times in ascending order. This guarantees that
   intervals which can be merged will appear contiguously.
2. **Iterate and Merge:** Initialize a list to hold the merged intervals. Iterate through the sorted intervals one by
   one.
3. **Compare Ends:** For each interval, compare its start time with the end time of the last interval added to the
   merged list:
    - If it doesn't overlap (current start > last end), add it directly to the list.
    - If it does overlap (current start <= last end), merge them by updating the last interval's end time to the maximum
      of both end times.

## Complexity

- **Time Complexity:** $O(n \log n)$, where $n$ is the number of intervals. Sorting the intervals dominates the time
  complexity. The subsequent linear scan takes $O(n)$ time.
- **Space Complexity:** $O(n)$, which is the space required to store the sorted output in the merged list in the
  worst-case scenario (where no intervals overlap). Also accounts for the space required by the sorting algorithm.

## Edge Cases

- **Empty Array or Single Interval:** Handled correctly by returning the input array early.
- **Fully Contained Intervals:** `[[1, 10], [2, 6]]` will correctly merge into `[[1, 10]]` because of the `Math.max()`
  check.
- **Identical Intervals:** `[[1, 4], [1, 4]]` correctly merges to a single `[[1, 4]]`.
- **Unsorted Input:** The initial sort handles any out-of-order bounds, such as `[[1, 4], [0, 4]]` becoming
  `[[0, 4], [1, 4]]` prior to merging.

## Notes

The sorting step is crucial. Attempting to solve this without sorting requires comparing every interval against every
other interval, degrading the time complexity to $O(n^2)$.