package com.hegde.practice.graph;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * https://leetcode.com/problems/minimum-number-of-vertices-to-reach-all-nodes/description/
 */
public class MinimumNumOfVerticesToReachAllNodes {

    /**
     * Here we just have to find the nodes which don't have any incoming edges.
     * @param n
     * @param edges
     * @return
     */
    public static List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        Set<Integer> destinations = new HashSet<>();
        for(List<Integer> edge : edges){
            destinations.add(edge.get(1));
        }
        return IntStream.range(0, n).filter(num -> !destinations.contains(num)).boxed().toList();
    }

}
