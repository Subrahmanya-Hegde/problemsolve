package com.hegde.practice.graph;

import java.util.*;

/**
 * https://leetcode.com/problems/pacific-atlantic-water-flow/
 */
public class PacificAtlanticWaterFlow {

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<>();
        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return ans;
        }

        int rows = heights.length;
        int cols = heights[0].length;
        boolean[][] pacificReachable = new boolean[rows][cols];
        boolean[][] atlanticReachable = new boolean[rows][cols];

        Queue<int[]> pacificQueue = new LinkedList<>();
        Queue<int[]> atlanticQueue = new LinkedList<>();

        // Initialize the queues with border cells
        for (int i = 0; i < rows; i++) {
            pacificQueue.offer(new int[]{i, 0});
            atlanticQueue.offer(new int[]{i, cols - 1});
            pacificReachable[i][0] = true;
            atlanticReachable[i][cols - 1] = true;
        }
        for (int j = 0; j < cols; j++) {
            pacificQueue.offer(new int[]{0, j});
            atlanticQueue.offer(new int[]{rows - 1, j});
            pacificReachable[0][j] = true;
            atlanticReachable[rows - 1][j] = true;
        }

        bfs(heights, pacificQueue, pacificReachable);
        bfs(heights, atlanticQueue, atlanticReachable);

        // Find cells that can reach both oceans
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (pacificReachable[i][j] && atlanticReachable[i][j]) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }
        return ans;
    }

    private void bfs(int[][] heights, Queue<int[]> queue, boolean[][] reachable) {
        int rows = heights.length;
        int cols = heights[0].length;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0], c = cell[1];
            for (int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols &&
                        !reachable[nr][nc] && heights[nr][nc] >= heights[r][c]) {
                    reachable[nr][nc] = true;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }
    }

}
