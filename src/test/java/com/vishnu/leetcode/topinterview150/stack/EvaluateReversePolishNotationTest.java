package com.vishnu.leetcode.topinterview150.stack;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EvaluateReversePolishNotationTest {

    private final EvaluateReversePolishNotation solution = new EvaluateReversePolishNotation();

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void testEvalRPN(String[] tokens, int expected) {
        assertEquals(expected, solution.evalRPN(tokens));
    }

    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(new String[]{"2", "1", "+", "3", "*"}, 9),
                Arguments.of(new String[]{"4", "13", "5", "/", "+"}, 6),
                Arguments.of(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}, 22),
                Arguments.of(new String[]{"18"}, 18),
                Arguments.of(new String[]{"-2"}, -2),
                Arguments.of(new String[]{"0", "3", "/"}, 0)
        );
    }
}