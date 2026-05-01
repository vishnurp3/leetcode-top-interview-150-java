package com.vishnu.leetcode.topinterview150.hashmap;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class WordPatternTest {

    private final WordPattern wordPattern = new WordPattern();

    @ParameterizedTest(name = "pattern = \"{0}\", s = \"{1}\" should return {2}")
    @MethodSource("provideWordPatterns")
    void wordPattern_returnsExpectedResult(String pattern, String s, boolean expected) {
        boolean actual = wordPattern.wordPattern(pattern, s);

        assertEquals(expected, actual);
    }

    private static Stream<Arguments> provideWordPatterns() {
        return Stream.of(
                arguments("abba", "dog cat cat dog", true),
                arguments("abba", "dog cat cat fish", false),
                arguments("aaaa", "dog cat cat dog", false),
                arguments("abba", "dog dog dog dog", false),
                arguments("abc", "dog cat fish", true),
                arguments("abc", "dog cat dog", false),
                arguments("a", "dog", true),
                arguments("ab", "dog", false)
        );
    }
}