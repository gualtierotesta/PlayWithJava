package it.gualtierotesta.playwithjava.problems.leetcode;

public class P0896_MonotonicArray {

    public boolean isMonotonic(int[] nums) {
        int length = nums.length;
        if (length < 2)
            return true;
        boolean increasing = (nums[length - 1] - nums[0]) >= 0;
        for (int i = 0; i < length - 1; i++) {
            if (increasing && nums[i] > nums[i + 1]) {
                return false;
            } else if (!increasing && nums[i] < nums[i + 1]) {
                return false;
            }
        }
        return true;
    }
    
}
