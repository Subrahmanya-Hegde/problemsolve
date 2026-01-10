package com.hegde.practice.recursion;

public class MyAtoi {
    public int myAtoi(String s) {
        int i = 0;
        while(i < s.length() && s.charAt(i) == ' ') i++;
        if (i == s.length()) return 0;

        int sign = 1;
        if (s.charAt(i) == '+' || s.charAt(i) == '-') {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }
        return myAtoi(s, i, 0, sign);
    }

    private int myAtoi(String s, int index, int number, int sign){
        if(index >= s.length() || !Character.isDigit(s.charAt(index))){
            return number * sign;
        }
        int digit = s.charAt(index) - '0';
        if (number > (Integer.MAX_VALUE - digit) / 10) {
            return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        number = number * 10 + digit;
        return myAtoi(s, ++index, number, sign);
    }
}
