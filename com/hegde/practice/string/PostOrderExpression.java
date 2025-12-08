package com.hegde.practice.string;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class PostOrderExpression {

    public static void main(String[] args){
        System.out.println("Expression: " + postOrderExpressionOutput("100 200 + 2 / 5 * 7 +"));
    }

    public static int postOrderExpressionOutput(String input){
        String[] tokens = input.split("\\s+");
        Deque<Integer> numbers = new ArrayDeque<>();

        for(String token: tokens){
            if (isOperator(token)){
                if(numbers.size() < 2){
                    throw new IllegalArgumentException("Invalid expression");
                }
                int rightNumber = numbers.pop();
                int leftNumber = numbers.pop();
                int expressionOutput = performOperation(leftNumber, rightNumber, token.charAt(0));
                numbers.add(expressionOutput);
            } else {
                System.out.println("Token: "+ token);
                int number = Integer.parseInt(token);
                numbers.push(number);
            }
        }
        return numbers.pop();
    }

    private static boolean isOperator(String token){
        if(token.length() != 1)
            return false;
        List<Character> validOperators = List.of('+', '-', '*', '/');
        return validOperators.contains(token.charAt(0));
    }

    private static int performOperation(int leftNumber, int rightNumber, char operation){
        return switch (operation) {
            case '+' -> leftNumber + rightNumber;
            case '-' -> leftNumber - rightNumber;
            case '*' -> leftNumber * rightNumber;
            case '/' -> leftNumber / rightNumber;
            default -> throw new IllegalStateException("Unexpected value: " + operation);
        };
    }
}
