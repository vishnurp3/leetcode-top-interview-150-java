package com.vishnu.leetcode.topinterview150.interval;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SummaryRangesTest {

    private final SummaryRanges solution = new SummaryRanges();

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void testSummaryRanges(int[] nums, List<String> expected) {
        assertEquals(expected, solution.summaryRanges(nums));
    }

    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(new int[]{0, 1, 2, 4, 5, 7}, Arrays.asList("0->2", "4->5", "7")),
                Arguments.of(new int[]{0, 2, 3, 4, 6, 8, 9}, Arrays.asList("0", "2->4", "6", "8->9")),
                Arguments.of(new int[]{}, Collections.emptyList()),
                Arguments.of(new int[]{-1}, Collections.singletonList("-1")),
                Arguments.of(new int[]{1, 2, 3, 4, 5}, Collections.singletonList("1->5")),
                Arguments.of(new int[]{-2147483648, 2147483647}, Arrays.asList("-2147483648", "2147483647"))
        );
    }
}