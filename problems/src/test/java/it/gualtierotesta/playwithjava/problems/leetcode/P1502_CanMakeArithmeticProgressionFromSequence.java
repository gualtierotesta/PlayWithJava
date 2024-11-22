package it.gualtierotesta.playwithjava.problems.leetcode;

import java.util.Arrays;

public class P1502_CanMakeArithmeticProgressionFromSequence {

    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int diff = arr[1] - arr[0];
        for (int i = 1; i < arr.length - 1; i++) {
            if ((arr[i] + diff) != arr[i + 1])
                return false;
        }
        return true;
    }
}
