package com.hegde.practice.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @see <a href="https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/">
 *     17. Letter Combinations of a Phone Number</a>
 * Given a string containing digits from 2-9 inclusive,
 * return all possible letter combinations that the number could represent. Return the answer in any order.
 * A mapping of digits to letters (just like on the telephone buttons) is given below.
 * Note that 1 does not map to any letters.
 */
public class PhoneNumberLetterCombination {

    Map<Character, String> charMap = Map.of(
            '2', "abc",
            '3', "def",
            '4', "ghi",
            '5', "jkl",
            '6', "mno",
            '7', "pqrs",
            '8', "tuv",
            '9', "wxyz"
    );

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        backtrack(0, digits, new StringBuilder(), result);
        return result;
    }

    private void backtrack(int digitIterator, String digits, StringBuilder sb, List<String> result){
        if(digitIterator >= digits.length()){
            result.add(sb.toString());
            return;
        }
        String letters = charMap.get(digits.charAt(digitIterator));
        for(char c: letters.toCharArray()){
            sb.append(c);
            backtrack(digitIterator + 1, digits, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
