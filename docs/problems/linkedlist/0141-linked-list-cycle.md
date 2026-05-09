# 0141. Linked List Cycle

## Link

[LeetCode - Linked List Cycle](https://leetcode.com/problems/linked-list-cycle/)

## Problem Summary

Given the `head` of a linked list, determine if the linked list has a cycle in it. A cycle exists if there is some node
in the list that can be reached again by continuously following the `next` pointer. Return `true` if there is a cycle,
otherwise return `false`.

## Examples

- **Input:** `head = [3,2,0,-4], pos = 1`
- **Output:** `true`
- **Explanation:** There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).

- **Input:** `head = [1,2], pos = 0`
- **Output:** `true`
- **Explanation:** There is a cycle in the linked list, where the tail connects to the 0th node.

- **Input:** `head = [1], pos = -1`
- **Output:** `false`
- **Explanation:** There is no cycle in the linked list.

## Constraints

- The number of the nodes in the list is in the range $[0, 10^4]$.
- $-10^5 \le Node.val \le 10^5$
- `pos` is $-1$ or a valid index in the linked list. *(Note: `pos` is used for testing/examples, but not passed as a
  parameter to the method).*

## Approach

1. **Floyd's Cycle-Finding Algorithm (Tortoise and Hare):** Utilize two pointers, `slow` and `fast`.
2. **Initialization:** Start `slow` at `head` and `fast` at `head.next`.
3. **Traversal:** Move `slow` forward by one node and `fast` forward by two nodes at each step.
4. **Cycle Detection:** If the linked list has a cycle, the `fast` pointer will eventually lap the `slow` pointer,
   causing them to meet (`slow == fast`).
5. **No Cycle:** If there is no cycle, the `fast` pointer will reach the end of the list (`null`), at which point we can
   safely return `false`.

## Complexity

- **Time Complexity:** $O(n)$, where $n$ is the total number of nodes in the linked list. If there is no cycle, `fast`
  reaches the end in $n/2$ steps. If there is a cycle, the two pointers will meet in at most $n$ iterations.
- **Space Complexity:** $O(1)$, as we only use two pointers (`slow` and `fast`) regardless of the size of the linked
  list.

## Edge Cases

- **Empty List (`head == null`):** Checked initially. Returns `false`.
- **Single Node (`head.next == null`):** Checked initially. Returns `false`.
- **Cycle Connects to Head:** Handled perfectly; pointers will overlap naturally.

## Notes

While using a `HashSet` to store visited nodes is an intuitive approach with an $O(n)$ time complexity, it
requires $O(n)$ space. The two-pointer approach is the optimal solution because it solves the problem in $O(1)$ space.