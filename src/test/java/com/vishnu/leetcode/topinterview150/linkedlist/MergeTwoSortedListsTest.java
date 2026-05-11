package com.vishnu.leetcode.topinterview150.linkedlist;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MergeTwoSortedListsTest {

    private final MergeTwoSortedLists solution = new MergeTwoSortedLists();

    static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 4}, new int[]{1, 3, 4}, new int[]{1, 1, 2, 3, 4, 4}),
                Arguments.of(new int[]{}, new int[]{}, new int[]{}),
                Arguments.of(new int[]{}, new int[]{0}, new int[]{0})
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void testMergeTwoLists(int[] arr1, int[] arr2, int[] expected) {
        MergeTwoSortedLists.ListNode list1 = buildList(arr1);
        MergeTwoSortedLists.ListNode list2 = buildList(arr2);

        MergeTwoSortedLists.ListNode result = solution.mergeTwoLists(list1, list2);

        List<Integer> resultList = toList(result);
        List<Integer> expectedList = new ArrayList<>();
        for (int val : expected) {
            expectedList.add(val);
        }

        assertEquals(expectedList, resultList);
    }

    private MergeTwoSortedLists.ListNode buildList(int[] arr) {
        MergeTwoSortedLists.ListNode dummy = new MergeTwoSortedLists.ListNode(-1);
        MergeTwoSortedLists.ListNode current = dummy;
        for (int val : arr) {
            current.next = new MergeTwoSortedLists.ListNode(val);
            current = current.next;
        }
        return dummy.next;
    }

    private List<Integer> toList(MergeTwoSortedLists.ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return list;
    }
}