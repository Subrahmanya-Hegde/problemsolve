package com.hegde.practice.string;

public class StringRotation {

    public static void main(String[] args){
        System.out.println(isRotationApproachUsingKMP("mightandmagic",
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
        return containsPattern(s1 + s2, s2);
    }

    private static boolean containsPattern(String text, String pattern){
        int textLength = text.length();
        int patternLength = pattern.length();

        int[] longestPrefixSuffix = buildLongestPrefixSuffixTable(pattern);

        int i = 0, j = 0;

        while (i < textLength){
            if (text.charAt(i) == pattern.charAt(j)){
                i++;
                j++;
                if (j == patternLength)
                    return true;
            }else{
                if (j != 0){
                    j = longestPrefixSuffix[j - 1];
                }else{
                    i ++;
                }
            }
        }
        return false;
    }

    /**
     * We need to find the common prefix length from index 1.
     */
    private static int[] buildLongestPrefixSuffixTable(String pattern) {
        int patternLength = pattern.length();
        int[] longestPrefixSuffix = new int[patternLength];

        int prefixIndex = 0;
        int patternIndex = 1;

        longestPrefixSuffix[0] = 0;

        while (patternIndex < patternLength) {
            if (pattern.charAt(patternIndex) == pattern.charAt(prefixIndex)) {
                prefixIndex++;
                longestPrefixSuffix[patternIndex] = prefixIndex;
                patternIndex++;
            } else {
                if (prefixIndex != 0) {
                    prefixIndex = longestPrefixSuffix[prefixIndex - 1];
                }else {
                    longestPrefixSuffix[patternIndex] = 0;
                    patternIndex++;
                }
            }
        }
        return longestPrefixSuffix;
    }
}
