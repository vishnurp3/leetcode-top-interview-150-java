# 219. Contains Duplicate II

## Link
https://leetcode.com/problems/contains-duplicate-ii/

## Problem Summary
Given an integer array `nums` and an integer `k`, return `true` if there are two distinct indices `i` and `j` such that:

- `nums[i] == nums[j]`
- `abs(i - j) <= k`

Otherwise, return `false`.

---

## Examples

### Example 1
Input:
```
nums = [1,2,3,1]
k = 3
```

Output:
```
true
```

### Example 2
Input:
```
nums = [1,0,1,1]
k = 1
```

Output:
```
true
```

### Example 3
Input:
```
nums = [1,2,3,1,2,3]
k = 2
```

Output:
```
false
```

---

## Constraints

- `1 <= nums.length <= 10^5`
- `-10^9 <= nums[i] <= 10^9`
- `0 <= k <= 10^5`

---

## Approach

Use a **HashMap** to store the latest index where each number was seen.

### Steps

1. Create a map:
    - Key → number
    - Value → latest index of that number

2. Iterate through `nums`.

3. For each number:
    - If it was seen before, get its previous index
    - Check if the distance between current index and previous index is less than or equal to `k`
    - If yes, return `true`

4. Update the latest index of the current number.

5. If no nearby duplicate is found, return `false`.

---

## Complexity

- Time Complexity: `O(n)`
- Space Complexity: `O(n)`

---

## Edge Cases

- `k = 0` → always `false` because indices must be distinct
- Duplicate exists but distance is greater than `k` → `false`
- Duplicate exists within distance `k` → `true`
- Array with one element → `false`

---

## Notes

- Always store the latest index, not the first index.
- Storing the latest index gives the smallest possible distance for future duplicates.
- Alternative approach:
    - Use a sliding window with a HashSet of size at most `k`