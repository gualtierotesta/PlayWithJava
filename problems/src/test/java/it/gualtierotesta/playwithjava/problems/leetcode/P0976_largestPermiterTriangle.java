package it.gualtierotesta.playwithjava.problems.leetcode;

import java.util.Arrays;

public class P0976_largestPermiterTriangle {

    public int largestPerimeter(int[] nums) {
        int len = nums.length;
        if (len < 3)
            return 0;
        Arrays.sort(nums);
        for (int i = len - 1; i > 1; i--) {
            if (canBeATriangle(nums[i], nums[i - 1], nums[i - 2]))
                return nums[i] + nums[i - 1] + nums[i - 2];
        }
        return 0;
    }

    private boolean canBeATriangle(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            return false;
        }
        return (a + b > c) && (a + c > b) && (b + c > a);
    }
}
