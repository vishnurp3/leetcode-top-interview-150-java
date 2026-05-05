package com.vishnu.leetcode.topinterview150.interval;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class InsertIntervalTest {

    private final InsertInterval solution = new InsertInterval();

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void testInsert(int[][] intervals, int[] newInterval, int[][] expected) {
        assertArrayEquals(expected, solution.insert(intervals, newInterval));
    }

    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5}, new int[][]{{1, 5}, {6, 9}}),
                Arguments.of(new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}}, new int[]{4, 8}, new int[][]{{1, 2}, {3, 10}, {12, 16}}),
                Arguments.of(new int[][]{}, new int[]{5, 7}, new int[][]{{5, 7}}),
                Arguments.of(new int[][]{{1, 5}}, new int[]{2, 3}, new int[][]{{1, 5}}),
                Arguments.of(new int[][]{{1, 5}}, new int[]{6, 8}, new int[][]{{1, 5}, {6, 8}}),
                Arguments.of(new int[][]{{4, 5}}, new int[]{1, 2}, new int[][]{{1, 2}, {4, 5}}),
                Arguments.of(new int[][]{{1, 5}}, new int[]{0, 6}, new int[][]{{0, 6}})
        );
    }
}