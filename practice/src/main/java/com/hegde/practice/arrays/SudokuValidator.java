package com.hegde.practice.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/valid-sudoku/description/
 */
public class SudokuValidator {

    private static final String ROW_VALIDATOR_KEY = "row_%d_num_%c";
    private static final String COLUMN_VALIDATOR_KEY = "col_%d_num_%c";
    private static final String BOX_VALIDATOR_KEY = "box_%d_%d_%c";

    public boolean isValidSudoku(char[][] board) {
        Set<String> rowValidator = new HashSet<>();
        Set<String> columnValidator = new HashSet<>();
        Set<String> boxValidator =new HashSet<>();

        int rows = board.length;
        int cols = board[0].length;

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                char number = board[i][j];
                if(number == '.')
                    continue;

                var rowValidatorKey = String.format(ROW_VALIDATOR_KEY, i, number);
                var columnValidatorKey = String.format(COLUMN_VALIDATOR_KEY, j, number);
                var boxValidatorKey = String.format(BOX_VALIDATOR_KEY, i % 3, j % 3, number);

                if(rowValidator.contains(rowValidatorKey)
                        || columnValidator.contains(columnValidatorKey)
                        || boxValidator.contains(boxValidatorKey)){
                    return false;
                }

                rowValidator.add(rowValidatorKey);
                columnValidator.add(columnValidatorKey);
                boxValidator.add(boxValidatorKey);
            }
        }
        return true;
    }
}
