package it.gualtierotesta.playwithjava.problems.leetcode;

public class P0066_PlusOne {
    public int[] plusOne(int[] digits) {
        int length = digits.length;
        for (int i = length - 1; i >= 0; i--) {
            int digit = digits[i];
            if (digit < 9) {
                digits[i] = digit + 1;
                break;
            }
            digits[i] = 0;
            if (i == 0) {
                int[] newArr = new int[length + 1];
                System.arraycopy(digits, 0, newArr, 1, length);
                newArr[0] = 1;
                digits = newArr;
            }
        }
        return digits;
    }
}
