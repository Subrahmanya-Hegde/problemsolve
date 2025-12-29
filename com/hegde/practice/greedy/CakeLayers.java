package com.hegde.practice.greedy;

public class CakeLayers {

    /**
     * https://codeforces.com/contest/2182/problem/B
     */
    public static int getMaxCakeLayers(int white, int dark){
        int startWithWhite = getLayers(white, dark, true);
        int startWithDark = getLayers(white, dark, false);
        return (Math.max(startWithDark, startWithWhite));
    }

    public static int getLayers(int white, int dark, boolean whiteTurn){
        int layers = 0, size = 1;
        while (true){
            if(whiteTurn){
                if (white < size) break;
                white -= size;
            }else {
                if (dark < size) break;
                dark -= size;
            }
            layers += 1;
            size <<= 1;
            whiteTurn = !whiteTurn;
        }
        return layers;
    }
}
