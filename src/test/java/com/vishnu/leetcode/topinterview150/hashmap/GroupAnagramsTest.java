package com.vishnu.leetcode.topinterview150.hashmap;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class GroupAnagramsTest {

    private final GroupAnagrams groupAnagrams = new GroupAnagrams();

    @ParameterizedTest(name = "input = {0}")
    @MethodSource("provideInputs")
    void groupAnagrams_returnsExpectedResult(String[] input, List<List<String>> expected) {
        List<List<String>> actual = groupAnagrams.groupAnagrams(input);

        assertEquals(normalize(expected), normalize(actual));
    }

    private static Stream<Arguments> provideInputs() {
        return Stream.of(
                arguments(
                        new String[]{"eat", "tea", "tan", "ate", "nat", "bat"},
                        List.of(
                                List.of("eat", "tea", "ate"),
                                List.of("tan", "nat"),
                                List.of("bat")
                        )
                ),
                arguments(
                        new String[]{""},
                        List.of(List.of(""))
                ),
                arguments(
                        new String[]{"a"},
                        List.of(List.of("a"))
                )
        );
    }

    private List<List<String>> normalize(List<List<String>> groups) {
        List<List<String>> normalized = new ArrayList<>();

        for (List<String> group : groups) {
            List<String> sortedGroup = new ArrayList<>(group);
            sortedGroup.sort(Comparator.naturalOrder());
            normalized.add(sortedGroup);
        }

        normalized.sort(Comparator.comparing(List::getFirst));

        return normalized;
    }
}