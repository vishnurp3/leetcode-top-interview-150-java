package com.vishnu.leetcode.topinterview150.hashmap;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ContainsDuplicateIITest {

    private final ContainsDuplicateII containsDuplicateII = new ContainsDuplicateII();

    @ParameterizedTest(name = "nums = {0}, k = {1} should return {2}")
    @MethodSource("provideInputs")
    void containsNearbyDuplicate_returnsExpectedResult(int[] nums, int k, boolean expected) {
        boolean actual = containsDuplicateII.containsNearbyDuplicate(nums, k);

        assertEquals(expected, actual);
    }

    private static Stream<Arguments> provideInputs() {
        return Stream.of(
                arguments(new int[]{1, 2, 3, 1}, 3, true),
                arguments(new int[]{1, 0, 1, 1}, 1, true),
                arguments(new int[]{1, 2, 3, 1, 2, 3}, 2, false),
                arguments(new int[]{1, 2, 3, 1}, 2, false),
                arguments(new int[]{1, 1}, 0, false),
                arguments(new int[]{1, 1}, 1, true)
        );
    }
}