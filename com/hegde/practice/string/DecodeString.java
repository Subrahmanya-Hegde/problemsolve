package com.hegde.practice.string;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @see <a href="https://leetcode.com/problems/decode-string/">
 * 394. Decode String</a>
 * Given an encoded string, return its decoded string.
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times.
 * Note that k is guaranteed to be a positive integer.
 * You may assume that the input string is always valid; there are no extra white spaces,
 * square brackets are well-formed, etc. Furthermore,
 * you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k.
 * For example, there will not be input like 3a or 2[4].
 */
public class DecodeString {

    public static String decodeEncryptedString(String encryptedWord) {
        Deque<Integer> frequencyStack = new ArrayDeque<>();
        StringBuilder answerBuilder = new StringBuilder();
        StringBuilder stringToBeRepeatedBuilder = new StringBuilder();

        int frequency = 0;
        for(char c : encryptedWord.toCharArray()){
            if(Character.isDigit(c)){
                frequency += frequency * 10 + (c - '0');
            } else if (c == '[') {
                frequencyStack.add(frequency);
                frequency = 0;
            } else if (c == ']') {
                answerBuilder.append(stringToBeRepeatedBuilder.toString().repeat(frequencyStack.pop()));
                stringToBeRepeatedBuilder.setLength(0);
            }else {
                stringToBeRepeatedBuilder.append(c);
            }
        }
        return answerBuilder.toString();
    }

}








