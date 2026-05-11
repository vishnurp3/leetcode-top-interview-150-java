package com.vishnu.leetcode.topinterview150.linkedlist;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class AddTwoNumbersTest {

    static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(
                        createList(new int[]{2, 4, 3}),
                        createList(new int[]{5, 6, 4}),
                        createList(new int[]{7, 0, 8})
                ),
                Arguments.of(
                        createList(new int[]{0}),
                        createList(new int[]{0}),
                        createList(new int[]{0})
                ),
                Arguments.of(
                        createList(new int[]{9, 9, 9, 9, 9, 9, 9}),
                        createList(new int[]{9, 9, 9, 9}),
                        createList(new int[]{8, 9, 9, 9, 0, 0, 0, 1})
                )
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void testAddTwoNumbers(AddTwoNumbers.ListNode l1, AddTwoNumbers.ListNode l2, AddTwoNumbers.ListNode expected) {
        AddTwoNumbers solution = new AddTwoNumbers();
        AddTwoNumbers.ListNode result = solution.addTwoNumbers(l1, l2);
        assertTrue(areListsEqual(expected, result));
    }

    private static AddTwoNumbers.ListNode createList(int[] values) {
        AddTwoNumbers.ListNode dummy = new AddTwoNumbers.ListNode(0);
        AddTwoNumbers.ListNode curr = dummy;
        for (int val : values) {
            curr.next = new AddTwoNumbers.ListNode(val);
            curr = curr.next;
        }
        return dummy.next;
    }

    private static boolean areListsEqual(AddTwoNumbers.ListNode l1, AddTwoNumbers.ListNode l2) {
        while (l1 != null && l2 != null) {
            if (l1.val != l2.val) {
                return false;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        return l1 == null && l2 == null;
    }
}