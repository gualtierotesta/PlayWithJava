package it.gualtierotesta.playwithjava.problems.leetcode;

public class P0088_MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int curr = m + n - 1;
        int ind1 = m - 1;
        int ind2 = n - 1;
        while (curr >= 0) {
            if (ind1 >= 0 && ind2 >= 0) {
                if (nums1[ind1] >= nums2[ind2]) {
                    nums1[curr--] = nums1[ind1--];
                } else {
                    nums1[curr--] = nums2[ind2--];
                }
            } else if (ind1 >= 0) {
                nums1[curr--] = nums1[ind1--];
            } else {
                nums1[curr--] = nums2[ind2--];
            }
        }
    }
}
