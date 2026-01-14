package com.hegde.practice.recursion;

import java.util.Stack;

/**
 * https://takeuforward.org/plus/dsa/problems/sort-a-stack
 */
public class SortStack {
    public void sortStack(Stack<Integer> stack) {
        if(!stack.isEmpty()){
            int topElement = stack.pop();
            sortStack(stack);
            insert(stack, topElement);
        }
    }

    private void insert(Stack<Integer> stack, int number){
        if(stack.isEmpty() || stack.peek() <= number){
            stack.push(number);
            return;
        }
        int currentTop = stack.pop();
        insert(stack, number);
        stack.push(currentTop);
    }
}
