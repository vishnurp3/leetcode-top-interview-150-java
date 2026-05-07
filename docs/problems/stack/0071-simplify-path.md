# 0071. Simplify Path

## Link

[LeetCode - Simplify Path](https://leetcode.com/problems/simplify-path/)

## Problem Summary

Given a string `path`, which is an absolute path (starting with a slash `'/'`) to a file or directory in a Unix-style
file system, convert it to the simplified canonical path.

In a Unix-style file system:

- A single period `.` refers to the current directory.
- A double period `..` refers to the directory up a level.
- Any multiple consecutive slashes (i.e. `//`) are treated as a single slash `/`.

The canonical path should:

1. Start with a single slash `/`.
2. Any two directories are separated by a single slash `/`.
3. The path does not end with a trailing `/` (unless it's just the root `/`).
4. Only contain the directories on the path from the root to the target file or directory (no `.` or `..`).

## Examples

- **Input:** `path = "/home/"`
- **Output:** `"/home"`
- **Explanation:** Note that there is no trailing slash after the last directory name.

- **Input:** `path = "/../"`
- **Output:** `"/"`
- **Explanation:** Going one level up from the root directory is a no-op, as the root level is the highest level you can
  go.

- **Input:** `path = "/home//foo/"`
- **Output:** `"/home/foo"`
- **Explanation:** In the canonical path, multiple consecutive slashes are replaced by a single one.

## Constraints

- $1 \le path.length \le 3000$
- `path` consists of English letters, digits, period `'.'`, slash `'/'` or `'_'`.
- `path` is a valid absolute Unix path.

## Approach

1. **Split the Path:** Use the `split("/")` method to break the input path into its individual components based on the
   slash delimiter.
2. **Use a Stack (Deque):** Iterate through the parsed components.
    - If the component is empty `""` (resulting from consecutive slashes) or a single period `"."`, ignore it.
    - If the component is a double period `".."`, pop the top element from the stack (if the stack is not empty),
      effectively navigating up one directory.
    - Otherwise, the component is a valid directory or file name, so push it onto the stack.
3. **Reconstruct the Path:** After processing all components, the stack will contain the valid directories in order.
   Iterate through the stack from bottom to top, prepending a slash `/` to each component, and append them to a
   `StringBuilder`.
4. **Handle Root:** If the stack is empty (e.g., the path was `/../`), return a single root slash `/`.

## Complexity

- **Time Complexity:** $O(n)$, where $n$ is the length of the string. Splitting the string takes $O(n)$ time, iterating
  through the components takes $O(n)$ time, and building the final string takes $O(n)$ time.
- **Space Complexity:** $O(n)$, the stack will store at most $n$ characters. The array created by the `split` method
  also takes $O(n)$ space.

## Edge Cases

- **Going Beyond Root:** Inputs like `/../` or `/a/../../` are handled by checking if the stack is empty before popping.
- **Multiple Slashes:** The `split("/")` function automatically handles multiple slashes by generating empty string
  tokens `""`, which we explicitly ignore.
- **Valid Names Resembling Operators:** Edge cases like `/.../` or `/.hidden` are treated correctly as standard
  directory names because they don't explicitly match the string `"."` or `".."`.

## Notes

Using `ArrayDeque` in Java is preferred over the legacy `Stack` class because it is faster (no synchronized methods
overhead) and provides a cleaner API (`offerLast`, `pollLast`, and enhanced for-loop iteration from first to last).