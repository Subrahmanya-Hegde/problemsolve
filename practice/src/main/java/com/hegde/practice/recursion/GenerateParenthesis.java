package com.hegde.practice.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/generate-parentheses/
 */
public class GenerateParenthesis {

    public List<String> generateParenthesis(int n) {
        List<String> answer = new ArrayList<>();
        generateParenthesis(answer, new StringBuilder(), n, n);
        return answer;
    }

    private void generateParenthesis(List<String> answer, StringBuilder sb, int open, int closed){
        if(open == 0 && closed == 0){
            answer.add(sb.toString());
            return;
        }
        if(open > 0){
            sb.append("(");
            generateParenthesis(answer, sb, open - 1, closed);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (closed > open) {
            sb.append(")");
            generateParenthesis(answer, sb, open, closed - 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
