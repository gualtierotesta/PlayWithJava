package it.gualtierotesta.playwithjava.problems.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class P1523_CountOddNumbersInAInternvalRange {

    @Test
    void test01() {

        Assertions.assertEquals(2, countOdds(4, 8));
    }

    private static int countOdds(int low, int high) {
        int numbers = high - low + 1;
        if (numbers == 2) return 1;
        if (isEven(numbers)) return numbers / 2;
        return isEven(low) ? numbers / 2 : (numbers / 2) + 1;
    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }

}
