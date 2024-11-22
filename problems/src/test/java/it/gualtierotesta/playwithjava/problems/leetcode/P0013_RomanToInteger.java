package it.gualtierotesta.playwithjava.problems.leetcode;

public class P0013_RomanToInteger {

    public int romanToInt(String s) {
        int total = 0;
        char absent = ' ';
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char curr = chars[i];
            char next = (i + 1 == chars.length) ? absent : chars[i + 1];
            switch (curr) {
                case 'M' -> total += 1000;
                case 'D' -> total += 500;
                case 'C' -> {
                    if (next == 'D') {
                        total += 400;
                        i += 1;
                    } else if (next == 'M') {
                        total += 900;
                        i += 1;
                    } else {
                        total += 100;
                    }
                }
                case 'L' -> total += 50;
                case 'X' -> {
                    if (next == 'L') {
                        total += 40;
                        i += 1;
                    } else if (next == 'C') {
                        total += 90;
                        i += 1;
                    } else {
                        total += 10;
                    }
                }
                case 'V' -> total += 5;
                case 'I' -> {
                    if (next == 'V') {
                        total += 4;
                        i += 1;
                    } else if (next == 'X') {
                        total += 9;
                        i += 1;
                    } else {
                        total += 1;
                    }

                }
            }
        }

        return total;
    }
}
