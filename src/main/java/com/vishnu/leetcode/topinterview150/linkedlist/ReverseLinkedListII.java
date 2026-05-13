package com.vishnu.leetcode.topinterview150.linkedlist;

public class ReverseLinkedListII {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode prevLeft = sentinel;
        for (int i = 1; i < left; i++) {
            prevLeft = prevLeft.next;
        }
        ListNode subListHead = prevLeft.next;
        for (int i = 0; i < right - left; i++) {
            ListNode nodeToMove = subListHead.next;
            subListHead.next = nodeToMove.next;
            nodeToMove.next = prevLeft.next;
            prevLeft.next = nodeToMove;
        }
        return sentinel.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
}
