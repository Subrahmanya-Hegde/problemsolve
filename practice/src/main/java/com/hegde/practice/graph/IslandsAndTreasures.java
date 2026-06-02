package com.hegde.practice.graph;

import java.util.ArrayDeque;
import java.util.Map;
import java.util.Queue;

/**
 * https://neetcode.io/problems/islands-and-treasure/question?list=neetcode150
 */
public class IslandsAndTreasures {

    private static final int[][] DIRECTIONS = new int[][]{
            {0, 1}, {1, 0}, {0, -1}, {-1, 0}
    };

    public void islandsAndTreasure(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new ArrayDeque<>();

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == 0){
                    queue.offer(new int[]{i, j});
                }
            }
        }

        while(!queue.isEmpty()){
            int[] treasureCoordinate = queue.poll();
            for(int[] direction: DIRECTIONS){
                int newRow = treasureCoordinate[0] + direction[0];
                int newCol = treasureCoordinate[1] + direction[1];

                if (isValid(newRow, newCol, rows, cols) && grid[newRow][newCol] == Integer.MAX_VALUE) {
                    grid[newRow][newCol] = grid[treasureCoordinate[0]][treasureCoordinate[1]] + 1;
                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }
    }

    private boolean isValid(int row, int col, int rows, int cols){
        return row >= 0 && col >= 0 && row < rows && col < cols;
    }
}
