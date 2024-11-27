package it.gualtierotesta.playwithjava.problems.leetcode;

public class P1232_CheckIfItIsALine {

    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates.length < 2) return false;
        int[] first = coordinates[0];
        int[] second = coordinates[1];
        for (int i = 2; i < coordinates.length; i++) {
            int[] current = coordinates[i];
            if (!areOnTheSameLine(first, second, current)) return false;
        }
        return true;
    }

    private static boolean areOnTheSameLine(int[] a, int[] b, int[] c) {
        int x = 0;
        int y = 1;
        // Vertical line, x constant
        if (a[x] == b[x] && b[x] == c[x]) return true;
        // Horizontal line, y constant
        if (a[y] == b[y] && b[y] == c[y]) return true;
        // Special cases with same Xs
        if (a[x] == b[x]) return a[x] == c[x];
        if (b[x] == c[x]) return a[x] == b[x];
        // Other cases, compare the slopes
        double s1 = (b[y] - a[y]) / (b[x] - a[x]);
        double s2 = (c[y] - b[y]) / (c[x] - b[x]);
        return Math.abs(s2 - s1) < 1e-10;
    }

}
