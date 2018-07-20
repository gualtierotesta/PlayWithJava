package it.gualtierotesta.playwithjava.kata;

/*
https://www.codewars.com/kata/vowel-count
*/

import java.util.stream.IntStream;

public class VowelCount {

    public static int getCount(final String str) {
        return (int) str.chars()
                .filter(c -> IntStream.of('a', 'e', 'i', 'o', 'u').anyMatch(x -> x == c))
                .count();
    }


    public static int getCount2(String str) {
        return str.replaceAll("(?i)[^aeiou]", "").length();
    }

    public static int getCount3(String str) {
        return (int) str.chars().filter(c -> "aeiou".indexOf(c) >= 0).count();
    }
}
