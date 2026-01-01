package com.hegde.practice.stack;

import java.util.*;

/**
 * https://leetcode.com/problems/min-stack/
 */
public class MinStack {

    public static class Node{
        int value;
        int min;
        public Node(int value, int min){
            this.value = value;
            this.min = min;
        }
    }

    List<Node> stack;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int value) {
        int curMin = !stack.isEmpty() ? getMin() : value;
        Node node = new Node(value, Math.min(curMin, value));
        stack.add(node);
    }

    public void pop() {
        stack.remove(lastIndex());
    }

    public int top() {
        return stack.get(lastIndex()).value;
    }

    public int getMin() {
        int lastIndex = lastIndex();
        return stack.get(lastIndex).min;
    }

    private int lastIndex(){
        int lastIndex = stack.size() - 1;
        if(lastIndex < 0)
            throw new IllegalArgumentException("Stack is empty");
        return lastIndex;
    }
}
