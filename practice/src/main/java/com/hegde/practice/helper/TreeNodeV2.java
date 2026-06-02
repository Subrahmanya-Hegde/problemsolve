package com.hegde.practice.helper;

public class TreeNodeV2 {
    public int val;
    public TreeNodeV2 left;
    public TreeNodeV2 right;
    public TreeNodeV2 next;

    public TreeNodeV2() {}

    public TreeNodeV2(int _val) {
        val = _val;
    }

    public TreeNodeV2(int _val, TreeNodeV2 _left, TreeNodeV2 _right, TreeNodeV2 _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}