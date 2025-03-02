package com.example.leetcode_solutions.mixed_topics;

public class leetcode931 {
    public static void main(String[] args) {
        int[][] matrix = {{100, -42, -46, -41}, {31, 97, 10, -10},
                {-58, -51, 82, 89}, {51, 81, 69, -51}};
        System.out.println(minFallingPathSum(matrix));
    }

    public static void minSum(int[][] mat, int n, int r) {
        if (r < 0)
            return;
        for (int i = 0; i < n; i++) {
            int nextMin = mat[r + 1][i] + mat[r][i];
            if (i > 0)
                nextMin = Math.min(nextMin, mat[r + 1][i - 1] + mat[r][i]);
            if (i < n - 1)
                nextMin = Math.min(nextMin, mat[r + 1][i + 1] + mat[r][i]);
            mat[r][i] = nextMin;
        }
        minSum(mat, n, r - 1);
    }

    public static int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        minSum(matrix, n, n - 2);
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (ans > matrix[0][i])
                ans = matrix[0][i];
        }
        return ans;
    }
}
