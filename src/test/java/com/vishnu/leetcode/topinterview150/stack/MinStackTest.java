package com.vishnu.leetcode.topinterview150.stack;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class MinStackTest {

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void testMinStackOperations(String[] commands, int[][] args, Integer[] expected) {
        MinStack minStack = null;

        for (int i = 0; i < commands.length; i++) {
            switch (commands[i]) {
                case "MinStack":
                    minStack = new MinStack();
                    assertNull(expected[i]);
                    break;
                case "push":
                    minStack.push(args[i][0]);
                    assertNull(expected[i]);
                    break;
                case "pop":
                    minStack.pop();
                    assertNull(expected[i]);
                    break;
                case "top":
                    assertEquals(expected[i], minStack.top());
                    break;
                case "getMin":
                    assertEquals(expected[i], minStack.getMin());
                    break;
            }
        }
    }

    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(
                        new String[]{"MinStack", "push", "push", "push", "getMin", "pop", "top", "getMin"},
                        new int[][]{{}, {-2}, {0}, {-3}, {}, {}, {}, {}},
                        new Integer[]{null, null, null, null, -3, null, 0, -2}
                ),
                Arguments.of(
                        new String[]{"MinStack", "push", "push", "push", "getMin", "pop", "getMin", "pop", "getMin"},
                        new int[][]{{}, {2}, {1}, {1}, {}, {}, {}, {}, {}},
                        new Integer[]{null, null, null, null, 1, null, 1, null, 2}
                ),
                Arguments.of(
                        new String[]{"MinStack", "push", "push", "getMin", "pop", "getMin"},
                        new int[][]{{}, {2147483647}, {-2147483648}, {}, {}, {}},
                        new Integer[]{null, null, null, -2147483648, null, 2147483647}
                )
        );
    }
}