package com.hegde.practice.graph.topological_sort;

import java.util.*;

/**
 * Sorted based on the indgree / dependency in the graph.
 * Whenever we need to find the list of nodes based on the dependency, then we need to use this.
 *
 * Input: [source, destination] implies source -> destination
 */
public class TopologicalSort {

    private static int SOURCE = 0;
    private static int DESTINATION = 1;

    public static List<Integer> topologicalSort(int nodes, int[][] edges){
        Map<Integer, List<Integer>> adjacencyList = getAdjacencyList(edges);
        int[] inDegree = getInDegree(nodes, edges);
        Queue<Integer> zeroInDegreeQueue = zeroInDegreeQueue(inDegree);
        List<Integer> topologicallySortedNodes = new ArrayList<>();

        while(!zeroInDegreeQueue.isEmpty()){
            int node = zeroInDegreeQueue.poll();
            topologicallySortedNodes.add(node);
            for(int neighbor: adjacencyList.getOrDefault(node, Collections.emptyList())){
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0){
                    zeroInDegreeQueue.offer(neighbor);
                }
            }
        }
        return (topologicallySortedNodes.size() == nodes) ? topologicallySortedNodes
                : Collections.emptyList();
    }

    private static Queue<Integer> zeroInDegreeQueue(int[] inDegree){
        Queue<Integer> zeroInDegreeQueue = new ArrayDeque<>();
        for(int i = 0; i < inDegree.length; i++){
            if(inDegree[i] == 0)
                zeroInDegreeQueue.offer(i);
        }
        return zeroInDegreeQueue;
    }

    private static int[] getInDegree(int nodes, int[][] graph) {
        int[] inDegree = new int[nodes];
        for(int[] edge: graph){
            inDegree[edge[DESTINATION]]++;
        }
        return inDegree;
    }

    static Map<Integer, List<Integer>> getAdjacencyList(int[][] graph){
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
        for(int[] edge: graph){
            adjacencyList.computeIfAbsent(edge[SOURCE], key -> new ArrayList<>()).add(edge[DESTINATION]);
        }
        return adjacencyList;
    }
}
