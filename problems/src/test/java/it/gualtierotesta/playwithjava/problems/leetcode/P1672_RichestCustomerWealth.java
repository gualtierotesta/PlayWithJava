package it.gualtierotesta.playwithjava.problems.leetcode;

// https://leetcode.com/problems/richest-customer-wealth

import org.junit.jupiter.api.Test;

public class P1672_RichestCustomerWealth {

    @Test
    void test01() {
        int[][] accounts = new int[][]{{1, 5}, {7, 3}, {3, 5}};
        int max = maximumWealth(accounts);
        System.out.println("max = " + max);
    }

    private static int maximumWealth(int[][] accounts) {
        int wealth = 0;
        for (final int[] account : accounts) {
            int sum = 0;
            for (final int balance : account) {
                sum += balance;
            }
            wealth = Math.max(wealth, sum);
        }
        return wealth;
    }


}
