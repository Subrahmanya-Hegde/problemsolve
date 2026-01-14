package com.hegde.practice.recursion;

import java.util.Stack;

/**
 * https://takeuforward.org/data-structure/reverse-a-stack-using-recursion
 */
public class ReverseStack {
    public void reverseStack(Stack<Integer> stack) {
        if(stack.isEmpty())
            return;
        int number = stack.pop();
        reverseStack(stack);
        insert(stack, number);
    }

    private void insert(Stack<Integer> stack, int number){
        if(stack.isEmpty()){
            stack.push(number);
            return;
        }
        int top = stack.pop();
        insert(stack, number);
        stack.push(top);
    }
}
