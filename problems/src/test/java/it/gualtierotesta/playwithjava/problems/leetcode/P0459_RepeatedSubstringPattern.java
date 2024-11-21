package it.gualtierotesta.playwithjava.problems.leetcode;

public class P0459_RepeatedSubstringPattern {

    public boolean repeatedSubstringPattern(String s) {
        System.out.println("s " + s);
        if (s.length() < 2)
            return false;
        int subLenght = (s.length() / 2);
        for (int i = subLenght; i > 0; i--) {
            String sub = s.substring(0, i);
            if (s.equals(sub.repeat(s.length() / sub.length()))) {
                return true;
            }
        }
        return false;
    }

    // Claude
//    public boolean repeatedSubstringPattern(String s) {
//        // Double the string and remove first and last characters
//        String doubled = s + s;
//        String substr = doubled.substring(1, doubled.length() - 1);
//
//        // If the original string can be found in the modified string,
//        // it means it can be constructed by repeating a substring
//        return substr.contains(s);
//    }
}
