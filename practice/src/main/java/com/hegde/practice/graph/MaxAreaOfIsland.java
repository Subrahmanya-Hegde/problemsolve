package com.hegde.practice.graph;

/**
 * @see <a href="https://leetcode.com/problems/max-area-of-island/description/">
 * 695. Max Area of Island</a>
 * You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally
 * (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
 *The area of an island is the number of cells with a value 1 in the island.
 * Return the maximum area of an island in grid. If there is no island, return 0.
 */
public class MaxAreaOfIsland {
    static int currentArea = 0;

    public static int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length, cols = grid[0].length, maxArea = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    currentArea = 0;
                    DFS(i, j, grid);
                    maxArea = Math.max(currentArea, maxArea);
                }
            }
        }
        return maxArea;
    }

    public static void DFS(int i, int j, int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        if (i < 0 || j < 0 || i >= rows || j >= cols || grid[i][j] != 1)
            return;
        grid[i][j] = 0;
        currentArea++;
        DFS(i + 1, j, grid);
        DFS(i - 1, j, grid);
        DFS(i, j + 1, grid);
        DFS(i, j - 1, grid);
    }

}
