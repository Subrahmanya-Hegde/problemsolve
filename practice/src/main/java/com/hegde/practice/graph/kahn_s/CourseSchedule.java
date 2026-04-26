package com.hegde.practice.graph.kahn_s;

import java.util.*;

/**
 * https://neetcode.io/problems/course-schedule
 * Using Kahn's algorithm:
 * Each edge is removed exactly once.
 * A node enters queue only when ALL its dependencies are resolved.
 * If a cycle exists, some nodes will never reach inDegree = 0.
 *
 * If a problem says anything like:
 * “Task A depends on Task B”
 * “You can do X only after Y”
 * “Find an order to complete all tasks”
 * “Some tasks may block others”
 * “Check if it’s possible to finish everything”
 *
 * Dependency graph → indegree → queue → Kahn’s
 */
public class CourseSchedule {


    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjacencyList = getAdjacencyList(prerequisites);
        int[] inDegree = getInDegree(numCourses, prerequisites);
        Queue<Integer> zeroInDegreeNodes = getZeroInDgreeNodesQueue(inDegree, numCourses);
        int processedNodes = 0;

        while (!zeroInDegreeNodes.isEmpty()){
            int curNode = zeroInDegreeNodes.poll();
            processedNodes++;
            for(int neighbor: adjacencyList.getOrDefault(curNode, Collections.emptyList())){
                inDegree[neighbor]--;
                if(inDegree[neighbor] != 0)
                    continue;
                zeroInDegreeNodes.offer(neighbor);
            }
        }
        return processedNodes == numCourses;
    }

    private int[] getInDegree(int nodes, int[][] graph){
        int[] inDegree = new int[nodes];
        for(int[] edge: graph){
            inDegree[edge[0]]++;
        }
        return inDegree;
    }

    private Queue<Integer> getZeroInDgreeNodesQueue(int[] inDegree, int nodes){
        Queue<Integer> zeroInDegreeNodes = new ArrayDeque<>();
        for(int i = 0; i < nodes; i++){
            if(inDegree[i] == 0)
                zeroInDegreeNodes.offer(i);
        }
        return zeroInDegreeNodes;
    }

    Map<Integer, List<Integer>> getAdjacencyList(int[][] graph){
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
        for(int[] edge: graph){
            adjacencyList.computeIfAbsent(edge[1], key -> new ArrayList<>()).add(edge[0]);
        }
        return adjacencyList;
    }
}