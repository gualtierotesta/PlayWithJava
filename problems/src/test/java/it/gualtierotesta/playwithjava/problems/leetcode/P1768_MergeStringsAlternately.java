package it.gualtierotesta.playwithjava.problems.leetcode;

import org.junit.jupiter.api.Test;

class P1768_MergeStringsAlternately {

    @Test
    void test01() {
        String result = mergeAlternately("cdf", "a");
        System.out.println("result = " + result);
    }

    private static String mergeAlternately(String word1, String word2) {
        int length = Math.min(word1.length(), word2.length());
        String suffix = word1.substring(length) + word2.substring(length);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            builder.append(word1.charAt(i));
            builder.append(word2.charAt(i));
        }
        builder.append(suffix);
        return builder.toString();
    }
}
