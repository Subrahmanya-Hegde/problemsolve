package com.hegde.problemsolve.array;

/**
 * https://codeforces.com/problemset/problem/231/A
 */
public class Team {
    public static int solve(int[][] input) {
        int ans = 0;
        for (int i = 0; i < input.length; i++){
            int sureCount = 0;
            for(int j = 0; j < 3; j++){
                if(input[i][j] == 1){
                    sureCount++;
                }
            }
            if(sureCount > 1) ans++;
        }
        return ans;
    }
}
