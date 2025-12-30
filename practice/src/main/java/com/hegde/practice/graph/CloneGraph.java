package com.hegde.practice.graph;


import com.hegde.practice.helper.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * @see <a href="https://leetcode.com/problems/clone-graph/">
 * 133. Clone Graph</a>
 * Given a reference of a node in a connected undirected graph.
 * Return a deep copy (clone) of the graph.
 * Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.
 */
public class CloneGraph {

    Map<Node,Node> originalToCloneMap = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node == null)
            return null;

        if(originalToCloneMap.containsKey(node))
            return originalToCloneMap.get(node);

        Node clone = new Node(node.val);
        originalToCloneMap.put(node, clone);
        for(Node neighborNode : node.neighbors){
            clone.neighbors.add(cloneGraph(neighborNode));
        }
        return clone;
    }
}
