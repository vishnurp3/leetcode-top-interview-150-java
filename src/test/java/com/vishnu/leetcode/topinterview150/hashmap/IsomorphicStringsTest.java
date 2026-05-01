package com.vishnu.leetcode.topinterview150.hashmap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class IsomorphicStringsTest {

    private final IsomorphicStrings isomorphicStrings = new IsomorphicStrings();

    @ParameterizedTest(name = "s = \"{0}\", t = \"{1}\" should return {2}")
    @MethodSource("provideIsomorphicStrings")
    void isIsomorphic_returnsExpectedResult(String s, String t, boolean expected) {
        boolean actual = isomorphicStrings.isIsomorphic(s, t);

        assertEquals(expected, actual);
    }

    private static Stream<Arguments> provideIsomorphicStrings() {
        return Stream.of(
                arguments("egg", "add", true),
                arguments("foo", "bar", false),
                arguments("paper", "title", true),
                arguments("badc", "baba", false),
                arguments("a", "a", true),
                arguments("ab", "aa", false),
                arguments("", "", true)
        );
    }
}