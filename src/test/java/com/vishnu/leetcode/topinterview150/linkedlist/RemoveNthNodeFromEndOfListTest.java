package com.vishnu.leetcode.topinterview150.linkedlist;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class RemoveNthNodeFromEndOfListTest {

    record TestCase(int[] input, int n, int[] expected) {
    }

    static Stream<TestCase> testCases() {
        return Stream.of(
                new TestCase(new int[]{1, 2, 3, 4, 5}, 2, new int[]{1, 2, 3, 5}),
                new TestCase(new int[]{1}, 1, new int[]{}),
                new TestCase(new int[]{1, 2}, 1, new int[]{1}),
                new TestCase(new int[]{1, 2}, 2, new int[]{2}),
                new TestCase(new int[]{1, 2, 3, 4, 5}, 5, new int[]{2, 3, 4, 5}),
                new TestCase(new int[]{1, 2, 3, 4, 5}, 1, new int[]{1, 2, 3, 4})
        );
    }

    private RemoveNthNodeFromEndOfList.ListNode buildList(int[] values) {
        RemoveNthNodeFromEndOfList.ListNode sentinel = new RemoveNthNodeFromEndOfList.ListNode(0);
        RemoveNthNodeFromEndOfList.ListNode curr = sentinel;
        for (int v : values) {
            curr.next = new RemoveNthNodeFromEndOfList.ListNode(v);
            curr = curr.next;
        }
        return sentinel.next;
    }

    private int[] toArray(RemoveNthNodeFromEndOfList.ListNode head) {
        int size = 0;
        RemoveNthNodeFromEndOfList.ListNode curr = head;
        while (curr != null) {
            size++;
            curr = curr.next;
        }
        int[] result = new int[size];
        curr = head;
        for (int i = 0; i < size; i++) {
            result[i] = curr.val;
            curr = curr.next;
        }
        return result;
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void testRemoveNthFromEnd(TestCase tc) {
        RemoveNthNodeFromEndOfList solution = new RemoveNthNodeFromEndOfList();
        RemoveNthNodeFromEndOfList.ListNode head = buildList(tc.input());
        RemoveNthNodeFromEndOfList.ListNode result = solution.removeNthFromEnd(head, tc.n());
        assertArrayEquals(tc.expected(), toArray(result));
    }
}