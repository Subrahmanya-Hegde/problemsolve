package com.hegde.practice.graph.unionfind;

/**
 * 684. Redundant Connection
 * https://leetcode.com/problems/redundant-connection/
 */
public class RedundantConnection {

    public int[] findRedundantConnection(int[][] edges) {
        return findRedundantConnectionUsingUnionFind(edges);
    }

    private int[] findRedundantConnectionUsingUnionFind(int[][] edges) {
        int n = edges.length;

        int[] parent = new int[n + 1];
        int[] size = new int[n + 1];

        //By default, add self as a parent and add size as 1 for all the nodes.
        for (int node = 1; node <= n; node++) {
            parent[node] = node;
            size[node] = 1;
        }

        for (int[] edge : edges) {
            int nodeA = edge[0];
            int nodeB = edge[1];

            int rootA = findAndPathCompress(nodeA, parent);
            int rootB = findAndPathCompress(nodeB, parent);

            if (rootA == rootB) {
                return edge;
            }
            unionBySize(rootA, rootB, parent, size);
        }

        return new int[0];
    }

    private void unionBySize(int rootA, int rootB, int[] parent, int[] size) {
        if (rootA == rootB) {
            return;
        }

        if (size[rootA] < size[rootB]) {
            parent[rootA] = rootB;
            size[rootB] += size[rootA];
        } else {
            parent[rootB] = rootA;
            size[rootA] += size[rootB];
        }
    }

    private int findAndPathCompress(int node, int[] parent) {
        if (parent[node] != node) {
            parent[node] = findAndPathCompress(parent[node], parent); // path compression
        }
        return parent[node];
    }
}