package com.vishnu.leetcode.topinterview150.hashmap;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class TwoSumTest {

    private final TwoSum twoSum = new TwoSum();

    @ParameterizedTest(name = "nums = {0}, target = {1}")
    @MethodSource("provideInputs")
    void twoSum_returnsExpectedResult(int[] nums, int target, int[] expected) {
        int[] actual = twoSum.twoSum(nums, target);

        assertArrayEquals(expected, actual);
    }

    private static Stream<Arguments> provideInputs() {
        return Stream.of(
                arguments(new int[]{2, 7, 11, 15}, 9, new int[]{0, 1}),
                arguments(new int[]{3, 2, 4}, 6, new int[]{1, 2}),
                arguments(new int[]{3, 3}, 6, new int[]{0, 1}),
                arguments(new int[]{-1, -2, -3, -4, -5}, -8, new int[]{2, 4})
        );
    }
}