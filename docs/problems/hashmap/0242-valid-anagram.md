# 242. Valid Anagram

## Link
https://leetcode.com/problems/valid-anagram/

## Problem Summary
Given two strings `s` and `t`, determine if `t` is an anagram of `s`.

An anagram is formed by rearranging the letters of another string using all the original characters exactly once.

---

## Examples

### Example 1
Input:
```
s = "anagram"
t = "nagaram"
```

Output:
```
true
```

### Example 2
Input:
```
s = "rat"
t = "car"
```

Output:
```
false
```

---

## Constraints

- `1 <= s.length, t.length <= 5 * 10^4`
- `s` and `t` consist of lowercase English letters

---

## Approach

Use a **frequency array** of size 26 (for lowercase letters).

1. If lengths differ, return `false`
2. Iterate through both strings:
    - Increment count for characters in `s`
    - Decrement count for characters in `t`
3. After processing, check if all counts are zero
    - If yes → anagram
    - If not → not anagram

---

## Complexity

- Time Complexity: `O(n)`
- Space Complexity: `O(1)` (fixed size array of 26)

---

## Edge Cases

- Different lengths → `false`
- Empty strings → `true`
- Same strings → `true`
- Same characters but different counts → `false`

---

## Notes

- Using an array is more efficient than using a HashMap for this problem.
- Works only because input is limited to lowercase English letters.
- If Unicode characters are involved, use a HashMap instead.
