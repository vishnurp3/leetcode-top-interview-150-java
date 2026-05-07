# 0155. Min Stack

## Link

[LeetCode - Min Stack](https://leetcode.com/problems/min-stack/)

## Problem Summary

Design a stack that supports `push`, `pop`, `top`, and retrieving the minimum element in constant time.

Implement the `MinStack` class:

- `MinStack()` initializes the stack object.
- `void push(int val)` pushes the element `val` onto the stack.
- `void pop()` removes the element on the top of the stack.
- `int top()` gets the top element of the stack.
- `int getMin()` retrieves the minimum element in the stack.

You must implement a solution with $O(1)$ time complexity for each function.

## Examples

- **Input:**
  `["MinStack","push","push","push","getMin","pop","top","getMin"]`
  `[[],[-2],[0],[-3],[],[],[],[]]`
- **Output:**
  `[null,null,null,null,-3,null,0,-2]`
- **Explanation:**
  `MinStack minStack = new MinStack();`
  `minStack.push(-2);`
  `minStack.push(0);`
  `minStack.push(-3);`
  `minStack.getMin(); // return -3`
  `minStack.pop();`
  `minStack.top();    // return 0`
  `minStack.getMin(); // return -2`

## Constraints

- $-2^{31} \le val \le 2^{31} - 1$
- Methods `pop`, `top` and `getMin` operations will always be called on non-empty stacks.
- At most $3 \times 10^4$ calls will be made to `push`, `pop`, `top`, and `getMin`.

## Approach

1. **Two Stacks:** Use two internal stacks. The `stack` stores the actual values, while `minStack` stores the minimum
   values encountered so far.
2. **Push Operation:** Always push the value onto the main `stack`. For `minStack`, push the value *only* if `minStack`
   is empty or if the new value is less than or equal to the current top of `minStack`.
3. **Pop Operation:** Pop the value from the main `stack`. If the popped value is equal to the top of the `minStack`,
   pop it from `minStack` as well to maintain synchronization.
4. **Top and getMin Operations:** These simply return the `peek()` of the respective stacks, fulfilling the $O(1)$ time
   complexity requirement.

## Complexity

- **Time Complexity:** $O(1)$ for all operations (`push`, `pop`, `top`, `getMin`).
- **Space Complexity:** $O(n)$, where $n$ is the number of elements in the stack. In the worst case (elements inserted
  in descending order), `minStack` will hold exactly as many elements as the main `stack`.

## Edge Cases

- **Duplicate Minimums:** Handled correctly by using `>=` (or strictly `>=` inverted to `<=`) when pushing to
  `minStack`. E.g., pushing `1` and then another `1` ensures both `1`s are logged in the `minStack`, so popping one `1`
  leaves the other `1` as the minimum.
- **Integer Limits:** Values pushed can be `Integer.MIN_VALUE` or `Integer.MAX_VALUE`. Utilizing `Deque<Integer>`
  seamlessly processes these boundaries without risk of mathematical overflow.

## Notes

Using `ArrayDeque` is generally preferred over the legacy `Stack` class in Java due to synchronization overhead present
in `Stack`.

~~~~</Integer>