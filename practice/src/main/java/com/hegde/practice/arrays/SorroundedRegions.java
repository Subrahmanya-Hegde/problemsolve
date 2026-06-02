package com.hegde.practice.arrays;

/**
 * @see <a href="https://leetcode.com/problems/surrounded-regions/">
 * 130. Surrounded Regions</a>
 * Given an m x n matrix board containing 'X' and 'O', capture all regions that are 4-directionally surrounded by 'X'.
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 */
public class SorroundedRegions {

    private static char SAFE = 'S';

    public void solve(char[][] board) {
        if(board == null || board.length == 0)
            return;

        int rows = board.length;
        int cols = board[0].length;

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(board[i][j] == 'O' && (i == 0 || j == 0 || i == rows - 1 || j == cols - 1)){
                    dfs(board, i, j);
                }
            }
        }

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++) {
                if(board[i][j] == 'O')
                    board[i][j] = 'X';
                else if(board[i][j] == 'S')
                    board[i][j] = 'O';
            }
        }
    }

    private void dfs(char[][] board, int i, int j){
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != 'O')
            return;

        board[i][j] = SAFE;
        dfs(board, i + 1, j);
        dfs(board, i - 1, j);
        dfs(board, i, j + 1);
        dfs(board, i, j - 1);
    }
}
