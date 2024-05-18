package com.hegde.practice.graph;

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
