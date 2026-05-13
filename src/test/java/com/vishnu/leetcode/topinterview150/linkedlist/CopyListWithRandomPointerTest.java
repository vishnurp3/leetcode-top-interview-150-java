package com.vishnu.leetcode.topinterview150.linkedlist;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CopyListWithRandomPointerTest {

    static Stream<CopyListWithRandomPointer.Node> testCases() {
        CopyListWithRandomPointer.Node n1 = new CopyListWithRandomPointer.Node(7);
        CopyListWithRandomPointer.Node n2 = new CopyListWithRandomPointer.Node(13);
        CopyListWithRandomPointer.Node n3 = new CopyListWithRandomPointer.Node(11);
        CopyListWithRandomPointer.Node n4 = new CopyListWithRandomPointer.Node(10);
        CopyListWithRandomPointer.Node n5 = new CopyListWithRandomPointer.Node(1);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n1.random = null;
        n2.random = n1;
        n3.random = n5;
        n4.random = n3;
        n5.random = n1;

        CopyListWithRandomPointer.Node single = new CopyListWithRandomPointer.Node(42);
        single.random = single;

        return Stream.of(n1, single, null);
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void testCopyIsDeepAndCorrect(CopyListWithRandomPointer.Node head) {
        CopyListWithRandomPointer solution = new CopyListWithRandomPointer();
        CopyListWithRandomPointer.Node copy = solution.copyRandomList(head);

        if (head == null) {
            assertNull(copy);
            return;
        }

        CopyListWithRandomPointer.Node orig = head;
        CopyListWithRandomPointer.Node curr = copy;

        while (orig != null) {
            assertNotSame(orig, curr);
            assertEquals(orig.val, curr.val);

            if (orig.random == null) {
                assertNull(curr.random);
            } else {
                assertNotSame(orig.random, curr.random);
                assertEquals(orig.random.val, curr.random.val);
            }

            orig = orig.next;
            curr = curr.next;
        }

        assertNull(curr);
    }
}