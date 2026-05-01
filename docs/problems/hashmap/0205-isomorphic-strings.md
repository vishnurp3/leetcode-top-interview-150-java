# 205. Isomorphic Strings

## Link
https://leetcode.com/problems/isomorphic-strings/

## Problem Summary
Given two strings `s` and `t`, determine if they are isomorphic.

Two strings are isomorphic if the characters in `s` can be replaced to get `t`.

Rules:
- All occurrences of a character must be replaced with another character.
- The order of characters must be preserved.
- No two different characters may map to the same character.
- A character may map to itself.

---

## Examples

### Example 1
Input:
```
s = "egg"
t = "add"
```
Output:
```
true
```

### Example 2
Input:
```
s = "foo"
t = "bar"
```
Output:
```
false
```

### Example 3
Input:
```
s = "paper"
t = "title"
```
Output:
```
true
```

---

## Constraints

- `1 <= s.length <= 5 * 10^4`
- `t.length == s.length`
- `s` and `t` consist of any valid ASCII character

---

## Approach

Use **two hash maps** to ensure a one-to-one mapping:

1. Map characters from `s → t`
2. Map characters from `t → s`

For each index:
- If a mapping already exists, verify it matches
- If not, create the mapping in both directions
- If any mismatch occurs, return `false`

---

## Complexity

- Time Complexity: `O(n)`
- Space Complexity: `O(k)`  
  where `k` is the number of distinct characters

---

## Edge Cases

- Different length strings → `false`
- Same characters mapping to different ones → `false`
- Multiple characters mapping to same character → `false`
- Empty strings → `true`

---

## Notes

- One-directional mapping is **not sufficient**
- Example:
  ```
  s = "ab"
  t = "aa"
  ```
  Should return `false`
