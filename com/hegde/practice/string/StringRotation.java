package com.hegde.practice.string;

public class StringRotation {

    public static void main(String[] args){
        System.out.println(isRotationApproachTwo("mightandmagic",
                "andmagicmight"));
    }

    public static boolean isRotationApproachOne(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        String temp = s1 + s1;
        return temp.contains(s2);
    }

    public static boolean isRotationApproachTwo(String s1, String s2) {
        int s1Length = s1.length();
        if (s1Length != s2.length())
            return false;
        for(int i = 0; i < s1Length; i++){
            String firstHalf = s1.substring(0, i);
            String secondHalf = s1.substring(i, s1Length);
            if((secondHalf + firstHalf).equals(s2))
                return true;
        }
        return false;
    }

    public static boolean isRotationApproachUsingKMP(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        String temp = s1 + s1;
        return temp.contains(s2);
    }

    private static boolean containsPattern(String text, String pattern){
        int textLength = text.length();
        int patternLength = pattern.length();

        int[] longestPrefixSuffix = buildLongestPrefixSuffixTable(pattern);
        return true;
    }

    private static int[] buildLongestPrefixSuffixTable(String pattern) {
        int patternLength = pattern.length();
        int[] longestPrefixSuffix = new int[patternLength];

        int prefixLength = 0;
        int patternIndex = 1;

        longestPrefixSuffix[0] = 0;

        while (patternIndex < patternLength) {
            if (pattern.charAt(patternIndex) == pattern.charAt(prefixLength)) {
                prefixLength++;
                longestPrefixSuffix[patternIndex] = prefixLength;
                patternIndex++;
            } else {
                if (prefixLength != 0) {
                    prefixLength = longestPrefixSuffix[prefixLength - 1];
                }else {
                    longestPrefixSuffix[patternIndex] = 0;
                    patternIndex++;
                }
            }
        }
        return longestPrefixSuffix;
    }
}
