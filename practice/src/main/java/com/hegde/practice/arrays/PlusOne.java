package com.hegde.practice.arrays;

/**
 * https://leetcode.com/problems/plus-one
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {
        int carry = 1, sum;
        int length = digits.length;

        for(int i = length - 1; i >= 0; i--){
            sum = digits[i] + carry;
            if(sum >= 10){
                carry = 1;
            }else{
                carry = 0;
            }
            sum %= 10;
            digits[i] = sum;
        }
        if (carry != 0){
            int[] newDigits = new int[length + 1];
            System.arraycopy(digits, 0, newDigits, 1, length - 1);
            newDigits[0] = carry;
            return newDigits;
        }
        return digits;
    }
}
