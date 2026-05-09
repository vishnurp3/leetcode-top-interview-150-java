package com.vishnu.leetcode.topinterview150.linkedlist;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LinkedListCycleTest {

    private final LinkedListCycle solution = new LinkedListCycle();

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void testHasCycle(int[] values, int pos, boolean expected) {
        ListNode head = buildListWithCycle(values, pos);
        assertEquals(expected, solution.hasCycle(head));
    }

    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(new int[]{3, 2, 0, -4}, 1, true),
                Arguments.of(new int[]{1, 2}, 0, true),
                Arguments.of(new int[]{1}, -1, false),
                Arguments.of(new int[]{}, -1, false),
                Arguments.of(new int[]{1, 2, 3, 4, 5}, -1, false)
        );
    }

    private ListNode buildListWithCycle(int[] values, int pos) {
        if (values == null || values.length == 0) {
            return null;
        }

        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        ListNode cycleNode = (pos == 0) ? head : null;

        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
            if (i == pos) {
                cycleNode = current;
            }
        }

        if (pos != -1) {
            current.next = cycleNode;
        }

        return head;
    }
}