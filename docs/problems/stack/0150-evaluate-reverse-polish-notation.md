# 0150. Evaluate Reverse Polish Notation

## Link

[LeetCode - Evaluate Reverse Polish Notation](https://leetcode.com/problems/evaluate-reverse-polish-notation/)

## Problem Summary

Evaluate the value of an arithmetic expression given in Reverse Polish Notation (RPN).
Valid operators are `+`, `-`, `*`, and `/`. Each operand may be an integer or another expression. Note that division
between two integers should truncate toward zero.

## Examples

- **Input:** `tokens = ["2","1","+","3","*"]`
- **Output:** `9`
- **Explanation:** `((2 + 1) * 3) = 9`

- **Input:** `tokens = ["4","13","5","/","+"]`
- **Output:** `6`
- **Explanation:** `(4 + (13 / 5)) = 6`

- **Input:** `tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]`
- **Output:** `22`
- **Explanation:** `((10 * (6 / ((9 + 3) * -11))) + 17) + 5 = 22`

## Constraints

- $1 \le tokens.length \le 10^4$
- `tokens[i]` is either an operator: `"+"`, `"-"`, `"*"`, or `"/"`, or an integer in the range `[-200, 200]`.
- The given RPN expression is always valid.

## Approach

1. **Use a Stack:** Initialize an `ArrayDeque` to store integer operands.
2. **Iterate through Tokens:** Process each string in the array one by one.
3. **Handle Numbers:** If the current token is a number, parse it as an integer and push it onto the stack.
4. **Handle Operators:** If the token is an operator (`+`, `-`, `*`, `/`):
    - Pop the top two elements from the stack.
    - The *first* popped element acts as the second operand (e.g., right side of subtraction/division).
    - The *second* popped element acts as the first operand.
    - Perform the arithmetic operation and push the result back onto the stack.
5. **Final Result:** Once the loop finishes, the final computed value will be the only item remaining on the stack.

## Complexity

- **Time Complexity:** $O(n)$, where $n$ is the number of tokens. We traverse the array exactly once, and stack
  operations (push/pop) take $O(1)$ time.
- **Space Complexity:** $O(n)$, in the worst-case scenario where the expression contains many consecutive numbers before
  any operators, requiring us to store roughly $n / 2$ integers on the stack.

## Edge Cases

- **Single Number:** An array with a single numeric string (e.g., `["18"]`) skips operator logic entirely and directly
  pops the answer.
- **Order of Operations:** Standard subtraction and division are non-commutative, so popping the "subtrahend" or "
  divisor" *first* is a critical detail to get correct.
- **Division Truncation:** Java's default integer division naturally truncates toward zero, fulfilling the problem's
  division constraint perfectly.

## Notes

Using a switch statement on Strings (supported in Java 7+) is ideal here for clean, readable routing of operators vs.
operands. `ArrayDeque` is the modern Java standard for stacks.