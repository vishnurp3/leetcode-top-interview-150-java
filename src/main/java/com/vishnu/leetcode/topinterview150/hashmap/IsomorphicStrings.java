package com.vishnu.leetcode.topinterview150.hashmap;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Character> sourceToTarget = new HashMap<>();
        Map<Character, Character> targetToSource = new HashMap<>();

        for (int index = 0; index < s.length(); index++) {
            char sourceCharacter = s.charAt(index);
            char targetCharacter = t.charAt(index);

            Character mappedTargetCharacter = sourceToTarget.get(sourceCharacter);
            Character mappedSourceCharacter = targetToSource.get(targetCharacter);

            if (mappedTargetCharacter != null && mappedTargetCharacter != targetCharacter) {
                return false;
            }

            if (mappedSourceCharacter != null && mappedSourceCharacter != sourceCharacter) {
                return false;
            }

            sourceToTarget.put(sourceCharacter, targetCharacter);
            targetToSource.put(targetCharacter, sourceCharacter);
        }

        return true;
    }
}