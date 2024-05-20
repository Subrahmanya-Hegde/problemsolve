package com.hegde.practice.graph;

import java.util.ArrayDeque;
import java.util.Queue;

public class RottenOranges {

    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int freshOranges = 0;
        int[][] visited = new int[rows][cols];
        Queue<Pair> queue = new ArrayDeque<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    visited[i][j] = 2;
                    queue.add(new Pair(i, j, 0));
                } else {
                    visited[i][j] = 0;
                }

                if (grid[i][j] == 1)
                    freshOranges++;
            }
        }

        int timeToRot = 0, rottenCount = 0;
        int[] rowsToTraverse = new int[]{-1, 0, +1, 0};
        int[] colsToTraverse = new int[]{0, 1, 0, -1};
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            timeToRot = Math.max(timeToRot, pair.time);
            for (int i = 0; i < 4; i++) {
                int nextRow = pair.i + rowsToTraverse[i];
                int nextCol = pair.j + colsToTraverse[i];
                if (nextRow >= 0 && nextRow < rows && nextCol >= 0 &&
                        nextCol < cols && visited[nextRow][nextCol] == 0 && grid[nextRow][nextCol] == 1) {
                    queue.add(new Pair(nextRow, nextCol, pair.time + 1));
                    visited[nextRow][nextCol] = 1;
                    rottenCount++;
                }
            }
        }

        return rottenCount != freshOranges ? -1 : timeToRot;
    }

    public class Pair {
        public int i;
        public int j;
        public int time;

        public Pair(int i, int j, int time) {
            this.i = i;
            this.j = j;
            this.time = time;
        }
    }
}
