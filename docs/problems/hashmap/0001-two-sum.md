# 1. Two Sum

## Link
https://leetcode.com/problems/two-sum/

## Problem Summary
Given an array of integers `nums` and an integer `target`, return indices of the two numbers such that they add up to `target`.

Each input has exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

---

## Examples

### Example 1
Input:
```
nums = [2,7,11,15], target = 9
```

Output:
```
[0,1]
```

### Example 2
Input:
```
nums = [3,2,4], target = 6
```

Output:
```
[1,2]
```

### Example 3
Input:
```
nums = [3,3], target = 6
```

Output:
```
[0,1]
```

---

## Constraints

- `2 <= nums.length <= 10^4`
- `-10^9 <= nums[i] <= 10^9`
- `-10^9 <= target <= 10^9`
- Exactly one valid answer exists

---

## Approach

Use a **HashMap** to store previously seen numbers.

### Steps

1. Initialize a map:
    - Key → number
    - Value → index

2. Iterate through the array:
    - Compute `complement = target - currentNumber`
    - If complement exists in the map:
      → return indices
    - Otherwise, store current number and index

---

## Complexity

- Time Complexity: `O(n)`
- Space Complexity: `O(n)`

---

## Edge Cases

- Negative numbers
- Duplicate numbers
- Solution involving same values but different indices

---

## Notes

- One-pass solution is optimal.
- Avoid brute force (`O(n^2)`).
- HashMap enables constant-time lookup.