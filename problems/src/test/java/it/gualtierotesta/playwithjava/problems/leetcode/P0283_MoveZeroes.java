package it.gualtierotesta.playwithjava.problems.leetcode;

public class P0283_MoveZeroes {
    public void moveZeroes(int[] nums) {
        int indexNonZero = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] != 0) {
                nums[indexNonZero] = nums[i];
                indexNonZero++;
            }
        }
        while (indexNonZero < length) {
            nums[indexNonZero] = 0;
            indexNonZero++;
        }
    }
}
