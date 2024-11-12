package it.gualtierotesta.playwithjava.problems.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
// https://leetcode.com/problems/find-the-difference

public class P0389_FindTheDifference {

    private static char findTheDifference(String s, String t) {
        List<Character> chars = t.chars().mapToObj(c -> (char) c)
                .collect(Collectors.toCollection(ArrayList::new));
        System.out.println("chars = " + chars);
        for (Character c : s.toCharArray()) {
            chars.remove(c);
        }
        return chars.getFirst();
    }


    public static void main(String[] args) {
        char difference = findTheDifference("a", "aa");
        System.out.println("difference = " + difference);
    }
}
