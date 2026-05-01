package com.vishnu.leetcode.topinterview150.hashmap;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ValidAnagramTest {

    private final ValidAnagram validAnagram = new ValidAnagram();

    @ParameterizedTest(name = "s = \"{0}\", t = \"{1}\" should return {2}")
    @MethodSource("provideAnagramInputs")
    void isAnagram_returnsExpectedResult(String s, String t, boolean expected) {
        boolean actual = validAnagram.isAnagram(s, t);

        assertEquals(expected, actual);
    }

    private static Stream<Arguments> provideAnagramInputs() {
        return Stream.of(
                arguments("anagram", "nagaram", true),
                arguments("rat", "car", false),
                arguments("aacc", "ccac", false),
                arguments("", "", true),
                arguments("a", "a", true),
                arguments("ab", "ba", true),
                arguments("abc", "abd", false)
        );
    }
}