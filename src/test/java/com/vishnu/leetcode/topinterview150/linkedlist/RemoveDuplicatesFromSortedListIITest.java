package com.vishnu.leetcode.topinterview150.linkedlist;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class RemoveDuplicatesFromSortedListIITest {

    record TestCase(int[] input, int[] expected) {
    }

    static Stream<TestCase> testCases() {
        return Stream.of(
                new TestCase(new int[]{1, 2, 3, 3, 4, 4, 5}, new int[]{1, 2, 5}),
                new TestCase(new int[]{1, 1, 1, 2, 3}, new int[]{2, 3}),
                new TestCase(new int[]{1, 1, 2, 2}, new int[]{}),
                new TestCase(new int[]{1, 2, 3}, new int[]{1, 2, 3}),
                new TestCase(new int[]{1, 1}, new int[]{}),
                new TestCase(new int[]{1}, new int[]{1}),
                new TestCase(new int[]{}, new int[]{})
        );
    }

    private RemoveDuplicatesFromSortedListII.ListNode buildList(int[] values) {
        RemoveDuplicatesFromSortedListII.ListNode sentinel = new RemoveDuplicatesFromSortedListII.ListNode(0);
        RemoveDuplicatesFromSortedListII.ListNode curr = sentinel;
        for (int v : values) {
            curr.next = new RemoveDuplicatesFromSortedListII.ListNode(v);
            curr = curr.next;
        }
        return sentinel.next;
    }

    private int[] toArray(RemoveDuplicatesFromSortedListII.ListNode head) {
        int size = 0;
        RemoveDuplicatesFromSortedListII.ListNode curr = head;
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
    void testDeleteDuplicates(TestCase tc) {
        RemoveDuplicatesFromSortedListII solution = new RemoveDuplicatesFromSortedListII();
        RemoveDuplicatesFromSortedListII.ListNode head = buildList(tc.input());
        RemoveDuplicatesFromSortedListII.ListNode result = solution.deleteDuplicates(head);
        assertArrayEquals(tc.expected(), toArray(result));
    }
}