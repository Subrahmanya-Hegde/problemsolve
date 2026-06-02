package com.hegde.practice.helper;

public class BstNodeInfo {
    public int minRight;
    public int maxLeft;
    public int sum;
    public boolean isBst;

    public BstNodeInfo(int minRight, int maxLeft, int sum, boolean isBst) {
        this.minRight = minRight;
        this.maxLeft = maxLeft;
        this.sum = sum;
        this.isBst = isBst;
    }
}
