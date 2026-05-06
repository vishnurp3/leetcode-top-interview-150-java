package com.vishnu.leetcode.topinterview150.stack;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ValidParenthesesTest {

    private final ValidParentheses solution = new ValidParentheses();

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void testIsValid(String s, boolean expected) {
        assertEquals(expected, solution.isValid(s));
    }

    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of("()", true),
                Arguments.of("()[]{}", true),
                Arguments.of("(]", false),
                Arguments.of("{[]}", true),
                Arguments.of("([)]", false),
                Arguments.of("((", false),
                Arguments.of("))", false),
                Arguments.of("[", false),
                Arguments.of("]", false),
                Arguments.of("({[", false),
                Arguments.of("", true)
        );
    }
}