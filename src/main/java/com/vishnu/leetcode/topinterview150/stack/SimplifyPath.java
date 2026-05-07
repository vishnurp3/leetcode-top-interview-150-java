package com.vishnu.leetcode.topinterview150.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class SimplifyPath {

    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();
        String[] components = path.split("/");

        for (String component : components) {
            if (component.isEmpty() || component.equals(".")) {
                continue;
            } else if (component.equals("..")) {
                stack.pollLast();
            } else {
                stack.offerLast(component);
            }
        }

        if (stack.isEmpty()) {
            return "/";
        }

        StringBuilder result = new StringBuilder();
        for (String dir : stack) {
            result.append("/").append(dir);
        }

        return result.toString();
    }
}
