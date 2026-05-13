package com.vishnu.leetcode.topinterview150.linkedlist;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ReverseLinkedListIITest {

    record TestCase(int[] input, int left, int right, int[] expected) {
    }

    static Stream<TestCase> testCases() {
        return Stream.of(
                new TestCase(new int[]{1, 2, 3, 4, 5}, 2, 4, new int[]{1, 4, 3, 2, 5}),
                new TestCase(new int[]{5}, 1, 1, new int[]{5}),
                new TestCase(new int[]{1, 2, 3, 4, 5}, 1, 5, new int[]{5, 4, 3, 2, 1}),
                new TestCase(new int[]{1, 2, 3, 4, 5}, 1, 1, new int[]{1, 2, 3, 4, 5}),
                new TestCase(new int[]{3, 5}, 1, 2, new int[]{5, 3})
        );
    }

    private ReverseLinkedListII.ListNode buildList(int[] values) {
        ReverseLinkedListII.ListNode sentinel = new ReverseLinkedListII.ListNode(0);
        ReverseLinkedListII.ListNode curr = sentinel;
        for (int v : values) {
            curr.next = new ReverseLinkedListII.ListNode(v);
            curr = curr.next;
        }
        return sentinel.next;
    }

    private int[] toArray(ReverseLinkedListII.ListNode head) {
        int size = 0;
        ReverseLinkedListII.ListNode curr = head;
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
    void testReverseBetween(TestCase tc) {
        ReverseLinkedListII solution = new ReverseLinkedListII();
        ReverseLinkedListII.ListNode head = buildList(tc.input());
        ReverseLinkedListII.ListNode result = solution.reverseBetween(head, tc.left(), tc.right());
        assertArrayEquals(tc.expected(), toArray(result));
    }
}