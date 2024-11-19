package it.gualtierotesta.playwithjava.problems.leetcode;

// https://leetcode.com/problems/average-salary-excluding-the-minimum-and-maximum-salary

public class P1491_AvergaSalary {

    public double average(int[] salary) {
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;
        double sum = 0;
        for (int s : salary) {
            min = Math.min(min, s);
            max = Math.max(max, s);
            sum += s;
        }
        return (sum - max - min) / (salary.length - 2);
    }
}
