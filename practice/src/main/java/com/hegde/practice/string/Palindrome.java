package com.hegde.practice.string;

public class Palindrome {

    public static void main(String[] args){
        System.out.println(isPalindrome("I am :IronnorI Ma, i"));
    }

    public static boolean isPalindrome(String input){
        int inputLength = input.length();
        int i = 0, j = inputLength - 1;
        while(i < j){
            if(!Character.isAlphabetic(input.charAt(i))){
                i++;
                break;
            }
            if(!Character.isAlphabetic(input.charAt(j))){
                j--;
                break;
            }
            if(Character.toLowerCase(input.charAt(i)) !=
                    Character.toLowerCase(input.charAt(j))){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
