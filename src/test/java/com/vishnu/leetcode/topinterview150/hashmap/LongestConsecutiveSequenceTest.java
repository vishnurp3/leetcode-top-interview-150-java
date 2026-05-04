package com.vishnu.leetcode.topinterview150.hashmap;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestConsecutiveSequenceTest {

    private final LongestConsecutiveSequence solution = new LongestConsecutiveSequence();

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void testLongestConsecutive(int[] nums, int expected) {
        assertEquals(expected, solution.longestConsecutive(nums));
    }

    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(new int[]{100, 4, 200, 1, 3, 2}, 4),
                Arguments.of(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}, 9),
                Arguments.of(new int[]{}, 0),
                Arguments.of(new int[]{1}, 1),
                Arguments.of(new int[]{1, 1, 1}, 1),
                Arguments.of(new int[]{1, 2, 0, 1}, 3),
                Arguments.of(new int[]{-1, -2, -3, 0, 1}, 5)
        );
    }
}