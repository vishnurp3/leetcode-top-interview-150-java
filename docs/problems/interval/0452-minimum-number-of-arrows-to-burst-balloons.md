# 0452. Minimum Number of Arrows to Burst Balloons

## Link

[LeetCode - Minimum Number of Arrows to Burst Balloons](https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/)

## Problem Summary

There are some spherical balloons taped onto a flat wall that represents the XY-plane. The balloons are represented as a
2D integer array `points` where `points[i] = [x_start, x_end]`. Arrows can be shot straight up from the x-axis. An arrow
shot at `x` will burst all balloons where `x_start <= x <= x_end`. Find the minimum number of arrows required to burst
all balloons.

## Examples

- **Input:** `points = [[10,16],[2,8],[1,6],[7,12]]`
- **Output:** `2`
- **Explanation:** The balloons can be burst by 2 arrows:
    - Shoot an arrow at x = 6, bursting the balloons [2,8] and [1,6].
    - Shoot an arrow at x = 11, bursting the balloons [10,16] and [7,12].

- **Input:** `points = [[1,2],[3,4],[5,6],[7,8]]`
- **Output:** `4`
- **Explanation:** One arrow needs to be shot for each balloon.

## Constraints

- $1 \le points.length \le 10^5$
- $points[i].length == 2$
- $-2^{31} \le x_{start} < x_{end} \le 2^{31} - 1$

## Approach

1. **Greedy Algorithm with Sorting:** The problem requires finding maximum overlapping intervals. By sorting the
   balloons by their **end** coordinates in ascending order, we guarantee that the balloon that ends earliest is handled
   first.
2. **Shoot and Track:** We shoot our first arrow at the end coordinate of the very first sorted balloon (to maximize its
   chance of bursting subsequent balloons).
3. **Iterate:** For each subsequent balloon, we check if its start coordinate is greater than our current arrow's
   position (the tracked `currentEnd`).
    - If it is, this balloon does not overlap with our current arrow. We must shoot a new arrow at the new balloon's end
      coordinate, and increment our arrow count.
    - If it isn't (start coordinate <= current arrow position), the current arrow is already sufficient to burst this
      balloon as well. We continue to the next iteration.

## Complexity

- **Time Complexity:** $O(n \log n)$, where $n$ is the number of balloons. Sorting the array takes $O(n \log n)$ time.
  The subsequent linear scan takes $O(n)$ time.
- **Space Complexity:** $O(1)$ auxiliary space if the sort is done in-place, though Java's `Arrays.sort()` may
  use $O(\log n)$ to $O(n)$ space under the hood depending on the implementation and data types.

## Edge Cases

- **Integer Overflow:** Because start and end points can be `Integer.MIN_VALUE` and `Integer.MAX_VALUE`, calculating
  `a[1] - b[1]` for sorting can cause integer overflow/underflow, resulting in incorrect sorting. Using
  `Integer.compare(a[1], b[1])` safely prevents this.
- **Single Balloon:** Automatically handled. Loop doesn't execute, returns 1.
- **Identical Balloons:** Checked and overlapped successfully, yielding 1 arrow.
- **Touching Intervals:** `[[1,2], [2,3]]` overlapping on the exact edge `2` is considered overlapping per the problem
  rules (`x_start <= x <= x_end`), which the condition `points[i][0] > currentEnd` properly respects.

## Notes

A common mistake is sorting by the start coordinate. While it is possible to solve it by sorting by start coordinates,
sorting by the end coordinates simplifies the logic since it naturally dictates the absolute furthest point you can
place an arrow while still hitting the current balloon.