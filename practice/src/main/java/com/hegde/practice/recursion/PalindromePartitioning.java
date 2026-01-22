package com.hegde.practice.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/palindrome-partitioning/
 */
public class PalindromePartitioning {

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(
            String s,
            int start,
            List<String> palindromes,
            List<List<String>> result){
        if(start == s.length()){
            result.add(new ArrayList<>(palindromes));
            return;
        }
        for(int i = start; i < s.length(); i++){
            if(isPalindrome(s, start, i)){
                palindromes.add(s.substring(start, i + 1));
                backtrack(s, i + 1, palindromes, result);
                palindromes.removeLast();
            }
        }
    }

    private boolean isPalindrome(String sb, int left, int right){
        while(left < right){
            if(sb.charAt(left++) != sb.charAt(right--))
                return false;
        }
        return true;
    }
}
