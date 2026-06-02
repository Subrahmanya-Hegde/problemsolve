package com.hegde.practice.string;

public class Cesar {

    public static long countPairs(String[] words) {
        int result = 0;
        for(int i = 0; i < words.length - 1; i++){
            for(int j = i + 1; j < words.length; j++){
                if(isNotCesar(words[i], words[j])){
                    result++;
                }
            }
        }
        return result;
    }

    private static boolean isNotCesar(String a, String b){
        int length = a.length();
        if(length != b.length())
            return false;
        int distance = (a.charAt(0) - b.charAt(0) + 26) % 26;

        for(int i = 0; i <= length / 2; i++){
            if(isNotCesar(a.charAt(i), b.charAt(i), distance) || isNotCesar(
                    a.charAt(length - i - 1), b.charAt(length - i - 1), distance)){
                return false;
            }
        }
        return true;
    }
    private static boolean isNotCesar(char a, char b, int distance){
        int curDistance = (a - b + 26) % 26;
        return curDistance != distance;
    }
}
