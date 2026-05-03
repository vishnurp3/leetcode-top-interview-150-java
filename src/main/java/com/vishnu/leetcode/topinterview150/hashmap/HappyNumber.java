package com.vishnu.leetcode.topinterview150.hashmap;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

    public boolean isHappy(int n) {
        Set<Integer> seenNumbers = new HashSet<>();
        int currentNumber = n;

        while (currentNumber != 1) {
            if (seenNumbers.contains(currentNumber)) {
                return false;
            }
            seenNumbers.add(currentNumber);
            currentNumber = getNextNumber(currentNumber);
        }
        return true;
    }

    private int getNextNumber(int number) {
        int sumOfSquares = 0;
        while (number > 0) {
            int digit = number % 10;
            sumOfSquares += digit * digit;
            number /= 10;
        }
        return sumOfSquares;
    }
}
