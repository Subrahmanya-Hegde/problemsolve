package com.hegde.practice.graph;

import java.util.*;

/**
 * https://neetcode.io/problems/foreign-dictionary/question?list=neetcode150
 */
public class AlienDictionary {

    private static boolean INVALID_DICTIONARY = false;

    public String foreignDictionary(String[] words) {
        if (words.length < 2)
            return words[0];

        StringBuilder sb = new StringBuilder();
        Map<Character, List<Character>> adjacencyList = getAdjacencyList(words);
        if(INVALID_DICTIONARY)
            return "";

        int[] inDegree = getInDegree(adjacencyList);
        Queue<Character> zeroInDegreeChars = getZeroInDegreeCharacters(inDegree, adjacencyList);

        while(!zeroInDegreeChars.isEmpty()){
            char curChar = zeroInDegreeChars.poll();
            sb.append(curChar);
            for(char neighbor: adjacencyList.getOrDefault(curChar, Collections.emptyList())){
                int neighborIndex = neighbor - 'a';
                inDegree[neighborIndex]--;
                if (inDegree[neighborIndex] == 0)
                    zeroInDegreeChars.offer(neighbor);
            }
        }
        return sb.length() == adjacencyList.keySet().size() ? sb.toString() : "";
    }

    private Queue<Character> getZeroInDegreeCharacters(int[] inDegree,
                                                       Map<Character, List<Character>> adjacencyList) {
        Queue<Character> zeroInDegree = new ArrayDeque<>();
        for(int i = 0; i < inDegree.length; i++){
            char node = (char)(i + 'a');
            if(adjacencyList.containsKey(node) && inDegree[i] == 0){
                zeroInDegree.offer(node);
            }
        }
        return zeroInDegree;
    }

    private int[] getInDegree(Map<Character, List<Character>> adjacencyList) {
        int[] inDegree = new int[26];
        for(char node: adjacencyList.keySet()){
            for(char neighbor: adjacencyList.get(node)){
                inDegree[neighbor - 'a']++;
            }
        }
        return inDegree;
    }

    private Map<Character, List<Character>> getAdjacencyList(String[] words){
        Map<Character, List<Character>> adjacencyList = new HashMap<>();
        for(String word: words){
            for(char c: word.toCharArray()){
                adjacencyList.putIfAbsent(c, new ArrayList<>());
            }
        }
        for (int i = 1; i < words.length; i++) {
            updateAdjacencyList(words[i - 1], words[i], adjacencyList);
        }
        return adjacencyList;
    }

    private void updateAdjacencyList(String source, String destination, Map<Character, List<Character>> adjacencyList) {
        int minLength = Math.min(source.length(), destination.length());
        if (source.length() > destination.length() && source.startsWith(destination)) {
            INVALID_DICTIONARY = true;
            return;
        }
        for(int i = 0; i < minLength; i++){
            if(source.charAt(i) != destination.charAt(i)) {
                adjacencyList.computeIfAbsent(source.charAt(i), key -> new ArrayList<>())
                        .add(destination.charAt(i));
                break;
            }
        }
    }
}
