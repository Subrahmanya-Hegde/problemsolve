package com.hegde.practice.graph.unionfind;

/**
 * 684. Redundant Connection
 * https://leetcode.com/problems/redundant-connection/
 */
public class RedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        int[] leader = new int[edges.length + 1];
        assignSelfAsLeader(leader);

        for(int[] edge : edges){
            int leaderOfStartNode = findLeader(edge[0], leader);
            int leaderOfEndNode = findLeader(edge[1], leader);

            if(leaderOfStartNode == leaderOfEndNode){
                return edge;
            }
            leader[leaderOfStartNode] = leaderOfEndNode;
        }
        return new int[0];
    }

    private static void assignSelfAsLeader(int[] parents) {
        for (int node = 1; node < parents.length; node++) {
            parents[node] = node;
        }
    }

    private int findLeader(int node, int[] leader) {
        if (leader[node] == node) {
            return node;
        }
        return findLeader(leader[node], leader);
    }
}