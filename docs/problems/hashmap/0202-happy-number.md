# 202. Happy Number

## Link
https://leetcode.com/problems/happy-number/

## Problem Summary
Write an algorithm to determine if a number `n` is a happy number.

A happy number is defined by the following process:

- Starting with any positive integer, replace the number with the sum of the squares of its digits
- Repeat the process until:
    - The number equals `1` (happy number), OR
    - The process loops endlessly (not a happy number)

Return `true` if `n` is a happy number, and `false` otherwise.

---

## Examples

### Example 1
Input:
```
n = 19
```

Output:
```
true
```

Explanation:
```
1² + 9² = 82
8² + 2² = 68
6² + 8² = 100
1² + 0² + 0² = 1
```

### Example 2
Input:
```
n = 2
```

Output:
```
false
```

---

## Constraints

- `1 <= n <= 2^31 - 1`

---

## Approach

Use a **HashSet** to detect cycles.

### Steps

1. Initialize a set to track seen numbers
2. Repeat:
    - Replace number with sum of squares of digits
    - If number becomes `1` → return `true`
    - If number is already in the set → cycle detected → return `false`
    - Otherwise, add number to the set

---

## Complexity

- Time Complexity: `O(log n)` per iteration
- Space Complexity: `O(log n)` for storing seen numbers

---

## Edge Cases

- `n = 1` → `true`
- Numbers entering a cycle (e.g., `2`) → `false`

---

## Notes

- All non-happy numbers eventually fall into a known cycle:
  ```
  4 → 16 → 37 → 58 → 89 → 145 → 42 → 20 → 4
  ```
- Using a HashSet is the simplest way to detect cycles.
- Alternative approach:
    - Use Floyd’s Cycle Detection (slow and fast pointers)