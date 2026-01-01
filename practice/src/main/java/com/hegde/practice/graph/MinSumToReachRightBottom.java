package com.hegde.practice.graph;

/**
 * https://leetcode.com/problems/minimum-path-sum/description/
 */
public class MinSumToReachRightBottom {

    public static int getMinSumToReachBottomRight(int[][] grid){
        int[] ans = new int[]{Integer.MAX_VALUE};
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        traverse(grid, visited, ans, 0, 0, 0);
        return ans[0];
    }

    private static void traverse(int[][] grid, boolean[][] visited, int[] ans, int row, int col, int curSum) {
        int rows = grid.length;
        int cols = grid[0].length;
        if(row >= rows || col >= cols || row < 0 || col < 0 || visited[row][col]){
            return;
        }

        curSum += grid[row][col];
        if(row == rows - 1 && col == cols - 1){
            ans[0] = Math.min(curSum, ans[0]);
            return;
        }

        visited[row][col] = true;
        traverse(grid, visited, ans, row + 1, col, curSum);
        traverse(grid, visited, ans, row, col + 1, curSum);
        traverse(grid, visited, ans, row - 1, col, curSum);
        visited[row][col] = false;
    }
}
