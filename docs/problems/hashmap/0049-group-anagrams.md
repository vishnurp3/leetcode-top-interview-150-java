# 49. Group Anagrams

## Link
https://leetcode.com/problems/group-anagrams/

## Problem Summary
Given an array of strings `strs`, group the anagrams together.

An anagram is a word formed by rearranging the letters of another word using all the original letters exactly once.

Return the groups of anagrams in any order.

---

## Examples

### Example 1
Input:
```
strs = ["eat","tea","tan","ate","nat","bat"]
```

Output:
```
[["bat"],["nat","tan"],["ate","eat","tea"]]
```

### Example 2
Input:
```
strs = [""]
```

Output:
```
[[""]]
```

### Example 3
Input:
```
strs = ["a"]
```

Output:
```
[["a"]]
```

---

## Constraints

- `1 <= strs.length <= 10^4`
- `0 <= strs[i].length <= 100`
- `strs[i]` consists of lowercase English letters

---

## Approach

Use a **hash map** to group anagrams based on a unique key.

### Key Idea
Two strings are anagrams if their character frequencies are the same.

### Steps

1. For each word:
    - Build a frequency array of size 26
    - Convert the frequency array into a unique string key

2. Use a HashMap:
    - Key → frequency signature
    - Value → list of words with that signature

3. Add each word to its corresponding group

4. Return all grouped values

---

## Complexity

- Time Complexity: `O(n * k)`
    - `n` = number of strings
    - `k` = max length of a string

- Space Complexity: `O(n * k)`

---

## Edge Cases

- Empty string → valid group
- Single character strings
- Duplicate strings
- All strings belong to one group

---

## Notes

- Using a frequency-based key avoids sorting (`O(k log k)`), making it more efficient.
- Alternative approach:
    - Sort each string and use it as a key (simpler but slightly slower).
- The order of groups in the result does not matter.