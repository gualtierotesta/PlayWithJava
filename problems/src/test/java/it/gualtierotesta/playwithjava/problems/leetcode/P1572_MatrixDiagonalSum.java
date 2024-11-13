package it.gualtierotesta.playwithjava.problems.leetcode;

// https://leetcode.com/problems/matrix-diagonal-sum/description

public class P1572_MatrixDiagonalSum {
    public int diagonalSum(int[][] mat) {
        int n = mat.length;
        int result = 0;
        // Primary diagonal
        for (int i = 0; i < n; i++) {
            result = result + mat[i][i];
        }
        // Secondary diagonal
        for (int j = 0, k = n - 1; j < n; j++, k--) {
            result = result + mat[j][k];
        }
        if (n % 2 != 0) {
            result = result - mat[n / 2][n / 2];
        }

        return result;
    }


    // Claude
    public int diagonalSum2(int[][] mat) {
        int n = mat.length;
        int sum = 0;

        // Loop through the matrix once
        for (int i = 0; i < n; i++) {
            // Add primary diagonal element (i,i)
            sum += mat[i][i];

            // Add secondary diagonal element (i,n-1-i)
            // Only if it's not the same as primary diagonal element
            if (i != n - 1 - i) {
                sum += mat[i][n - 1 - i];
            }
        }

        return sum;
    }

    // Gemini

    public int diagonalSum3(int[][] mat) {
        int n = mat.length;
        int sum = 0;

        // Iterate through the matrix, adding elements from both diagonals
        for (int i = 0; i < n; i++) {
            sum += mat[i][i]; // Primary diagonal
            sum += mat[i][n - i - 1]; // Secondary diagonal
        }

        // If n is odd, subtract the middle element to avoid double-counting
        if (n % 2 == 1) {
            sum -= mat[n / 2][n / 2];
        }

        return sum;
    }
}
