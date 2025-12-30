package com.hegde.practice.graph;

/**
 * @see <a href="https://leetcode.com/problems/number-of-islands/">
 * 200. Number of Islands</a>
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 */
public class NoOfIslands {

    public static int numIslands(char[][] grid) {
        int rows = grid.length, cols = grid[0].length, islands = 0;
        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    islands++;
                    DFS(i, j, grid, visited);
                }
            }
        }
        return islands;
    }

    public static void DFS(int i, int j, char[][] grid, boolean[][] visited) {
        int rows = grid.length, cols = grid[0].length;
        if (i < 0 || j < 0 || i >= rows || j >= cols || visited[i][j] || grid[i][j] == '0')
            return;
        visited[i][j] = true;
        DFS(i + 1, j, grid, visited);
        DFS(i - 1, j, grid, visited);
        DFS(i, j + 1, grid, visited);
        DFS(i, j - 1, grid, visited);
    }
}
