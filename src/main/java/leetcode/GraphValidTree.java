package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GraphValidTree {

    //what's the definition of a tree, no cycle and fully connected
    //do dfs starting any node in any edge, if there is a cycle return false
    //assume no edge is not a tree
    public boolean validTree(int n, int[][] edges) {
        if (edges == null || edges.length == 0) {
            return false;
        }
        boolean[] visited = new boolean[n];
        List<Set<Integer>> graph = new ArrayList<>(n);
        for (int i = 0; i < n; ++i) {
            graph.add(new HashSet<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        if (dfs(-1, edges[0][0], graph, visited)) {
            return true;
        }
        return false;
    }

    private boolean dfs(int parent, int i, List<Set<Integer>> graph, boolean[] visited) {
        visited[i] = true;
        for (Integer j : graph.get(i)) {
            if (parent == j) {
                continue;
            }
            if (visited[j]) { //a cycle
                return false;
            }
            if (!dfs(i, j, graph, visited)) {
                return false;
            }
        }
        return true;
    }

}