package com.hegde.practice.dp;

/**
 * https://www.youtube.com/watch?v=Ti5vfu9arXQ
 */
public class BigSquareFarmland {

    public int findTheLargestSquareLandAreaDp(int[][] land){
        if(land.length == 0)
            return 0;

        int rows = land.length;
        int cols = land[0].length;
        int[][] dp = new int[rows][cols];
        int maxSide = 0;

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(land[i][j] == 0)
                    continue;
                if(i == 0 || j == 0)
                    dp[i][j] = 1;
                else {
                    dp[i][j] = Math.min(
                            Math.min(dp[i - 1][j], dp[i][j - 1]),
                            dp[i - 1][j - 1]
                    ) + 1;
                }
                maxSide = Math.max(dp[i][j], maxSide);
            }
        }
        return maxSide * maxSide;
    }
}