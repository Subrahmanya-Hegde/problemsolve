package com.hegde.practice.bitmanipulation;

public class CheckIthBit {

    /**
     * https://takeuforward.org/data-structure/check-if-the-i-th-bit-is-set-or-not
     * Left shift 1 by n times. Then & it.
     * Why it works? Because we are using 1 and left shifting.
     * ex - if i = 3 and n = something
     * (1 << 3) = 1000. Since only the nth bit will be 1, when we & with the n, then we should get the
     * output as 0 if the ith bit is 0.
     */
    public boolean checkIthBit(int n, int i) {
        return (n & (1 << i)) != 0;
    }
}
