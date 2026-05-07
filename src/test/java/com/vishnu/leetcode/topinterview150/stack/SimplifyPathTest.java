package com.vishnu.leetcode.topinterview150.stack;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SimplifyPathTest {

    private final SimplifyPath solution = new SimplifyPath();

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void testSimplifyPath(String path, String expected) {
        assertEquals(expected, solution.simplifyPath(path));
    }

    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of("/home/", "/home"),
                Arguments.of("/home//foo/", "/home/foo"),
                Arguments.of("/a/./b/../../c/", "/c"),
                Arguments.of("/../", "/"),
                Arguments.of("/...", "/..."),
                Arguments.of("/", "/"),
                Arguments.of("/a/../../b/../c//.//", "/c"),
                Arguments.of("/.hidden_dir", "/.hidden_dir")
        );
    }
}