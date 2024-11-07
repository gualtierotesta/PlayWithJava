package it.gualtierotesta.playwithjava.problems.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class P0058_LengthOfLastWord {

    @Test
    void test01() {
        Assertions.assertEquals(5, lengthOfLastWord("Hello World"));
    }

    private static int lengthOfLastWord(String s) {
        String[] split = s.split("\\s+");
        if (split.length == 0) {
            return 0;
        }
        int lastWordIndex = split.length - 1;
        return split[lastWordIndex].length();
    }
}
