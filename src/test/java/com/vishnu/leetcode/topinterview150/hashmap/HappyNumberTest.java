package com.vishnu.leetcode.topinterview150.hashmap;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class HappyNumberTest {

    private final HappyNumber happyNumber = new HappyNumber();

    @ParameterizedTest(name = "n = {0} should return {1}")
    @MethodSource("provideInputs")
    void isHappy_returnsExpectedResult(int n, boolean expected) {
        boolean actual = happyNumber.isHappy(n);

        assertEquals(expected, actual);
    }

    private static Stream<Arguments> provideInputs() {
        return Stream.of(
                arguments(19, true),
                arguments(2, false),
                arguments(1, true),
                arguments(7, true),
                arguments(20, false)
        );
    }
}