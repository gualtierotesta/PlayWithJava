package it.gualtierotesta.playwithjava.problems.leetcode;

public class P1822_SignOfProductArray {

    public int arraySign(int[] nums) {
        int negativeNumbers = 0;
        for (int n : nums) {
            if (n == 0)
                return 0;
            if (n < 0)
                negativeNumbers++;
        }
        return (negativeNumbers % 2 == 0) ? 1 : -1;
    }

}
