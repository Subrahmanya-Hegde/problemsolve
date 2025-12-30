package com.hegde.practice.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SymmetricEncoding {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] array = new String[n];
        for(int i = 0; i < n; i++) {
            int size = sc.nextInt();
            array[i] = getSymmetricDecoded(sc.next());
        }

        for(int i = 0; i < n; i++) {
            System.out.println(array[i]);
        }
        sc.close();
    }

    private static String getSymmetricDecoded(String input){
        List<Character> uniqueStr = getUniquerCharString(input);
        Collections.sort(uniqueStr);
        int[] charIndex = new int[26];
        int uniqueStringLength = uniqueStr.size();
        int strLength = input.length();

        for(int i = 0; i < uniqueStringLength; i++){
            charIndex[uniqueStr.get(i) - 'a'] = i;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < strLength; i++){
            int curChar = input.charAt(i);
            sb.append(uniqueStr.get(uniqueStringLength - (charIndex[curChar - 'a']) - 1));
        }
        return sb.toString();
    }

    private static List<Character> getUniquerCharString(String input) {
        List<Character> uniqueCharString = new ArrayList<>();
        boolean[] alphabetsExists = new boolean[26];
        for(char c : input.toCharArray()){
            int index = c - 'a';
            if(!alphabetsExists[index]){
                uniqueCharString.add(c);
                alphabetsExists[index] = true;
            }
        }
        return uniqueCharString;
    }
}
