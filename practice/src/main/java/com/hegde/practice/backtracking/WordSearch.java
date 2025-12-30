package com.hegde.practice.backtracking;

/**
 * @see <a href="https://leetcode.com/problems/word-search/description/">79. Word Search</a>
 * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cells,
 * where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.
 */
public class WordSearch {

//    Testing
//    WordSearch wordSearch = new WordSearch();
//    char[][] board = {
//            {'A', 'B', 'C', 'E'},
//            {'S', 'F', 'C', 'S'},
//            {'A', 'D', 'E', 'E'}
//    };
//    System.out.println(wordSearch.searchWordIn2DArray(board,"SFCEDA"));

    public boolean searchWordIn2DArray(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] isVisited = new boolean[rows][cols];
        int wordLength = word.length();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == word.charAt(0) && isCharacterMatching(board, word, 0, i, j, isVisited, wordLength)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isCharacterMatching(char[][] board, String word, int index, int row, int col, boolean[][] isVisited, int wordLength) {
        if (index == wordLength) {
            return true;
        }

        if (row >= board.length || col >= board[0].length || row < 0 || col < 0 ||
                isVisited[row][col] || board[row][col] != word.charAt(index))
            return false;

        isVisited[row][col] = true;
        ++index;
        boolean isFound = isCharacterMatching(board, word, index, row + 1, col, isVisited, wordLength) ||
                isCharacterMatching(board, word, index, row, col + 1, isVisited, wordLength) ||
                isCharacterMatching(board, word, index, row - 1, col, isVisited, wordLength) ||
                isCharacterMatching(board, word, index, row, col - 1, isVisited, wordLength);

        //Backtrack
        isVisited[row][col] = false;

        return isFound;
    }

}
