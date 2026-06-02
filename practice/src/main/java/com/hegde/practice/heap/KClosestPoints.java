package com.hegde.practice.heap;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/k-closest-points-to-origin/
 */
public class KClosestPoints {

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                (a, b) -> b[0] - a[0]
        );

        for(int[] point: points){
            int distance = (point[0] * point[0]) + (point[1] * point[1]);
            maxHeap.offer(new int[]{distance, point[0], point[1]});
            if(maxHeap.size() > k)
                maxHeap.poll();
        }
        int[][] ans = new int[k][2];
        int i = 0;

        while(!maxHeap.isEmpty()){
            int[] point = maxHeap.poll();
            ans[i++] = new int[]{point[1], point[2]};
        }
        return ans;
    }
}
