package com.vishnu.leetcode.topinterview150.interval;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MergeIntervalsTest {

    private final MergeIntervals solution = new MergeIntervals();

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void testMerge(int[][] intervals, int[][] expected) {
        assertArrayEquals(expected, solution.merge(intervals));
    }

    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}}, new int[][]{{1, 6}, {8, 10}, {15, 18}}),
                Arguments.of(new int[][]{{1, 4}, {4, 5}}, new int[][]{{1, 5}}),
                Arguments.of(new int[][]{}, new int[][]{}),
                Arguments.of(new int[][]{{1, 4}}, new int[][]{{1, 4}}),
                Arguments.of(new int[][]{{1, 4}, {0, 4}}, new int[][]{{0, 4}}),
                Arguments.of(new int[][]{{1, 4}, {2, 3}}, new int[][]{{1, 4}}),
                Arguments.of(new int[][]{{2, 3}, {4, 5}, {6, 7}, {8, 9}, {1, 10}}, new int[][]{{1, 10}})
        );
    }
}