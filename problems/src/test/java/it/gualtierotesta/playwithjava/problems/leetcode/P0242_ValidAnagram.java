package it.gualtierotesta.playwithjava.problems.leetcode;

import java.util.ArrayList;
import java.util.List;

public class P0242_ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        List<Character> sarr = new ArrayList<>(s.length());
        for (char sc : s.toCharArray()) {
            sarr.add(sc);
        }
        System.out.println(sarr);
        for (Character tc : t.toCharArray()) {
            if (sarr.contains(tc)) {
                sarr.remove(tc);
            }
        }
        return sarr.isEmpty();
    }
    

    // Claude

    private static boolean isAnagram2(String s, String t) {
        // Check if lengths are different - if so, they can't be anagrams
        if (s.length() != t.length()) {
            return false;
        }

        // Create array to store character frequencies
        int[] charCount = new int[26];

        // Count frequencies of characters in both strings
        for (int i = 0; i < s.length(); i++) {
            charCount[s.charAt(i) - 'a']++;  // Increment count for s
            charCount[t.charAt(i) - 'a']--;  // Decrement count for t
        }

        // Check if all frequencies are zero
        for (int count : charCount) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }

}
