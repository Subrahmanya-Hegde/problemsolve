package com.hegde.practice.recursion;

/**
 * https://leetcode.com/problems/count-good-numbers/
 */
public class GoodNumbers {

    int MOD = 1_00_00_00_007;

    public int countGoodNumbers(long n) {
        long evenIndices = (n + 1) / 2;
        long oddIndices = n / 2;
        return (int) ((computeModPower(5, evenIndices) * computeModPower(4, oddIndices)) % MOD);
    }

    private long computeModPower(int base, long power){
        if (power == 0){
            return 1;
        }
        long half = computeModPower(base, power / 2);
        long ans = (half * half) % MOD;
        if(power % 2 != 0)
            ans = (ans * base) % MOD;
        return ans;
    }

    private long modPower(long base, long power) {
        long result = 1;
        base %= MOD;
        while (power > 0){
            if ((power & 1) == 1){ //(Is Odd)
                result = (result * base) % MOD;
            }
            base = (base * base) % MOD; //Note. Powering the base.
            power >>= 1; //(Divide by 2)
        }
        return result;
    }
}
