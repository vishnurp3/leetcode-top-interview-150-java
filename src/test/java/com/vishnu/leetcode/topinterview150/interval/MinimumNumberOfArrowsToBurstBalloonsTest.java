package com.vishnu.leetcode.topinterview150.interval;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumNumberOfArrowsToBurstBalloonsTest {

    private final MinimumNumberOfArrowsToBurstBalloons solution = new MinimumNumberOfArrowsToBurstBalloons();

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void testFindMinArrowShots(int[][] points, int expected) {
        assertEquals(expected, solution.findMinArrowShots(points));
    }

    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}}, 2),
                Arguments.of(new int[][]{{1, 2}, {3, 4}, {5, 6}, {7, 8}}, 4),
                Arguments.of(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}}, 2),
                Arguments.of(new int[][]{}, 0),
                Arguments.of(new int[][]{{1, 2}}, 1),
                Arguments.of(new int[][]{{2, 3}, {2, 3}}, 1),
                Arguments.of(new int[][]{{-2147483646, -2147483645}, {2147483646, 2147483647}}, 2),
                Arguments.of(new int[][]{{-2147483648, 2147483647}}, 1)
        );
    }
}