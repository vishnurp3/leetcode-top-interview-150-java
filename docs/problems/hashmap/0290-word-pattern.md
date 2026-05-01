# 290. Word Pattern

## Link
https://leetcode.com/problems/word-pattern/

## Problem Summary
Given a string `pattern` and a string `s`, determine if `s` follows the same pattern.

Each character in `pattern` must map to exactly one word in `s`, and each word in `s` must map back to exactly one character in `pattern`.

This means the mapping must be one-to-one.

---

## Examples

### Example 1
Input:
```
pattern = "abba"
s = "dog cat cat dog"
```

Output:
```
true
```

### Example 2
Input:
```
pattern = "abba"
s = "dog cat cat fish"
```

Output:
```
false
```

### Example 3
Input:
```
pattern = "aaaa"
s = "dog cat cat dog"
```

Output:
```
false
```

---

## Constraints

- `1 <= pattern.length <= 300`
- `pattern` contains only lowercase English letters
- `1 <= s.length <= 3000`
- `s` contains lowercase English letters and spaces
- `s` does not contain leading or trailing spaces
- All words in `s` are separated by a single space

---

## Approach

Use two hash maps to ensure a one-to-one mapping:

1. Map characters from `pattern → word`
2. Map words from `word → pattern`

First, split `s` into words.

If the number of words does not match the length of `pattern`, return `false`.

Then, for each index:
- Get the current pattern character
- Get the current word
- Check if the pattern character is already mapped to a different word
- Check if the word is already mapped to a different pattern character
- If either check fails, return `false`
- Otherwise, store both mappings

If all mappings are valid, return `true`.

---

## Complexity

- Time Complexity: `O(n)`
- Space Complexity: `O(n)`

where `n` is the number of words in `s`.

---

## Edge Cases

- Pattern length and word count are different → `false`
- Same pattern character maps to different words → `false`
- Different pattern characters map to the same word → `false`
- Single character and single word → `true`

---

## Notes

- One-directional mapping is not enough.
- Example:
  ```
  pattern = "abba"
  s = "dog dog dog dog"
  ```
  Should return `false`.

- This problem is very similar to **205. Isomorphic Strings**.
- The main difference is that this problem maps characters to words instead of characters to characters.
