package com.hegde.practice.arrays;

/**
 * https://leetcode.com/problems/rotate-image/description/
 * Approach - Get the transpose. And then reverse the rows.
 */
public class RotateMatrix {

    public void rotate(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                transpose(matrix, i, j);
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n / 2; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = temp;
            }
        }
    }

    private static void transpose(int[][] matrix, int row, int column) {
        int temp = matrix[row][column];
        matrix[row][column] = matrix[column][row];
        matrix[column][row] = temp;
    }
}
