package com.hegde.practice.arrays;

/**
 * https://www.youtube.com/watch?v=Ti5vfu9arXQ
 */
public class BigSquareFarmland {

    //Naive approach:
    public int findTheLargestSquareLandArea(int[][] land){
        int rows = land.length;
        int cols = land[0].length;
        int maxSide = 0;

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if (land[i][j] == 0) continue;

                int maxPossibleSize = Math.min(rows - i, cols - j);
                for(int size = 1; size <= maxPossibleSize; size++){
                    if(validSquare(land, i, j, size)){
                        maxSide = Math.max(maxSide, size);
                    }else {
                        break;
                    }
                }
            }
        }
        return maxSide * maxSide;
    }

    private boolean validSquare(int[][] land, int row, int col, int size) {
        for(int i = row; i < row + size; i++){
            for(int j = col; j < col + size; j++){
                if(land[i][j] == 0)
                    return false;
            }
        }
        return true;
    }
}