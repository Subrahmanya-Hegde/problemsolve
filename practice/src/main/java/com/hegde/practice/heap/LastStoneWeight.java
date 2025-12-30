package com.hegde.practice.heap;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @see <a href="https://leetcode.com/problems/last-stone-weight/description/">
 * 1046. Last Stone Weight</a>
 * You are given an array of integers stones where stones[i] is the weight of the ith stone.
 * We are playing a game with the stones. On each turn, we choose the heaviest two stones and smash them together.
 * Suppose the heaviest two stones have weights x and y with x <= y. The result of this smash is:
 * If x == y, both stones are destroyed, and
 * If x != y, the stone of weight x is destroyed, and the stone of weight y has new weight y - x.
 * At the end of the game, there is at most one stone left.
 * Return the weight of the last remaining stone. If there are no stones left, return 0.
 */
public class LastStoneWeight {

    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> orderedStones = new PriorityQueue<>(Collections.reverseOrder());
        for(int stone : stones){
            orderedStones.offer(stone);
        }
        while(orderedStones.size() > 1){
            int stone1 = orderedStones.poll();
            int stone2 = orderedStones.poll();
            orderedStones.offer(stone1-stone2);
        }
        return orderedStones.peek();
    }
}
