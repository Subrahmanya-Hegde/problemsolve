package com.hegde.practice.graph;

import java.util.*;

/**
 * 684. Redundant Connection
 * https://leetcode.com/problems/redundant-connection/
 */
public class RedundantConnectionDfs {

    public int[] findRedundantConnection(int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int startNode = edge[0];
            int endNode = edge[1];

            Set<Integer> visitedNodes = new HashSet<>();
            if (graph.containsKey(startNode) &&
                    graph.containsKey(endNode) &&
                    pathExists(startNode, endNode, graph, visitedNodes)) {
                return edge;
            }
            graph.computeIfAbsent(startNode, k -> new ArrayList<>()).add(endNode);
            graph.computeIfAbsent(endNode, k -> new ArrayList<>()).add(startNode);
        }
        return new int[0];
    }

    private boolean pathExists (int source, int target, Map<Integer, List<Integer>> graph, Set<Integer> visitedNodes){
        if(source == target) {
            return true;
        }
        visitedNodes.add(source);
        for(int neighbour : graph.getOrDefault(source, new ArrayList<>())){
            if(!visitedNodes.contains(neighbour)
                    && pathExists(neighbour, target, graph, visitedNodes)){
                return true;
            }
        }
        return false;
    }
}
