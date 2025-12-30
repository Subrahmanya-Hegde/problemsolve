package com.hegde.practice.arrays;

public class SnowballProduction {

    /**
     * https://codeforces.com/contest/2182/problem/C
     * All the heads should be smaller than torso and torso should be smaller than legs.
     */
    public long totalSnowMan(int n, int[] head, int[] torso, int[] legs){
        int goodHeadTorso = countGoodShifts(n, head, torso);
        int goodTorsoLegs = countGoodShifts(n, torso, legs);
        return (long) n * goodHeadTorso * goodTorsoLegs;
    }

    static int countGoodShifts(int n, int[] x, int[] y) {
        int count = 0;
        for (int shift = 0; shift < n; shift++) {
            boolean ok = true;
            for (int i = 0; i < n; i++) {
                if (x[i] >= y[(i + shift) % n]) {
                    ok = false;
                    break;
                }
            }
            if (ok) count++;
        }
        return count;
    }
}
