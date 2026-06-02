package com.hegde.practice.graph;

import java.util.*;

/**
 * https://neetcode.io/problems/course-schedule
 */
public class CourseSchedule {

    private static final  int VISITING = 1;
    private static final int VISITED = 2;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] visitedState = new int[numCourses];
        Map<Integer, List<Integer>> adjacencyList = getAdjacencyList(prerequisites);

        for(int i = 0; i < numCourses; i++){
            if(cycleExists(i, adjacencyList, visitedState))
                return false;
        }

        return true;
    }

    private boolean cycleExists(int node, Map<Integer, List<Integer>> graph, int[] visitedState) {
        if(visitedState[node] == 1)
            return true;
        if(visitedState[node] == 2)
            return false;

        visitedState[node] = VISITING;
        for(int neighbor: graph.getOrDefault(node, Collections.emptyList())){
            if(cycleExists(neighbor, graph, visitedState))
                return true;
        }
        visitedState[node] = VISITED;
        return false;
    }

    Map<Integer, List<Integer>> getAdjacencyList(int[][] graph){
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
        for(int[] edge: graph){
            adjacencyList.computeIfAbsent(edge[1], key -> new ArrayList<>()).add(edge[0]);
        }
        return adjacencyList;
    }
}
