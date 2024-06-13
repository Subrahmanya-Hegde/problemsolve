package com.hegde.practice.trie;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Trie {

    TrieNode head;

    public Trie() {
        this.head = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curNode = head;
        int length = word.length() - 1;
        for (int i = 0; i <= length; i++) {
            boolean isLeaf = i == length;
            char curChar = word.charAt(i);
            if (curNode.children.containsKey(curChar)) {
                curNode = curNode.children.get(curChar);
                if (i == length) {
                    curNode.isLeaf = true;
                }
            } else {
                TrieNode newChild = new TrieNode(curChar, new HashMap<>(), isLeaf);
                curNode.children.put(curChar, newChild);
                curNode = newChild;
            }
        }
    }

    public boolean search(String word) {
        return getLastCommonCharacterTrieNode(word).map(trieNode -> trieNode.isLeaf).orElse(false);
    }

    public boolean startsWith(String prefix) {
        return getLastCommonCharacterTrieNode(prefix).isPresent();
    }

    private Optional<TrieNode> getLastCommonCharacterTrieNode(String input){
        TrieNode curNode = head;
        for (char c : input.toCharArray()) {
            if (curNode.children.containsKey(c)) {
                curNode = curNode.children.get(c);
            }else {
                return Optional.empty();
            }
        }
        return Optional.of(curNode);
    }

    public static class TrieNode {
        char data;
        Map<Character, TrieNode> children;
        boolean isLeaf;

        public TrieNode() {
            this.data = '\u0000';
            this.children = new HashMap<>();
            this.isLeaf = false;
        }

        public TrieNode(char data, Map<Character, TrieNode> children, boolean isLeaf) {
            this.data = data;
            this.children = children;
            this.isLeaf = isLeaf;
        }
    }
}