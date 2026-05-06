# 0020. Valid Parentheses

## Link

[LeetCode - Valid Parentheses](https://leetcode.com/problems/valid-parentheses/)

## Problem Summary

Given a string `s` containing just the characters `'('`, `')'`, `'{'`, `'}'`, `'['` and `']'`, determine if the input
string is valid. An input string is valid if open brackets are closed by the same type of brackets, and open brackets
must be closed in the correct order.

## Examples

- **Input:** `s = "()"`
- **Output:** `true`

- **Input:** `s = "()[]{}"`
- **Output:** `true`

- **Input:** `s = "(]"`
- **Output:** `false`

## Constraints

- $1 \le s.length \le 10^4$
- `s` consists of parentheses only `'()[]{}'`.

## Approach

1. **Use a Stack:** Iterate through the string character by character. We use a Stack (specifically an `ArrayDeque` in
   Java for better performance) to keep track of the open brackets.
2. **Push Expected Closing Brackets:** When encountering an open bracket (`(`, `{`, `[`), push its corresponding closing
   bracket (`)`, `}`, `]`) onto the stack. This simplifies the checking logic later.
3. **Pop and Compare:** When encountering a closing bracket, pop the top element from the stack. If the stack is empty (
   meaning there was no preceding open bracket) or the popped element does not match the current closing bracket, the
   string is invalid.
4. **Final Check:** After the loop finishes, check if the stack is empty. If it is, all brackets were correctly matched
   and closed. If it is not, there are leftover open brackets, making the string invalid.

## Complexity

- **Time Complexity:** $O(n)$, where $n$ is the length of the string `s`. We traverse the string exactly once, and stack
  push/pop operations take $O(1)$ time.
- **Space Complexity:** $O(n)$, in the worst-case scenario (e.g., all open brackets `"(((((("`), the stack will hold
  all $n$ characters.

## Edge Cases

- **Odd Length Strings:** An odd-length string can never be valid. Returning `false` immediately saves time.
- **Starting with a Closing Bracket:** Handled correctly. The stack will be empty when a pop is attempted, returning
  `false`.
- **All Open Brackets:** E.g., `"((("`. Handled correctly. Loop finishes but the stack won't be empty, returning
  `false`.

## Notes

Using `ArrayDeque` is generally preferred over `Stack` in modern Java for stack implementations because it is not
synchronized, offering slightly better performance. Pushing the expected closing bracket instead of the open bracket
makes the `else if` validation logic significantly cleaner and more readable.