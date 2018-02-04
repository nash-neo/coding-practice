package airbnb;

import java.util.*;

public class VertexCover {

    //given a directed graph, could contain cycle, find the minimum number of vertices to cover the graph
    //My idea is to use topological sort to sort the vertices first
    //Then pick unvisited vertex in topologically sorted order, and mark all reachable vertices as visited by dfs
    //could also use bfs, always choose vertex whose indegree is zero, but then a way to break a cycle is needed
    public List<Integer> getMinimumCover(Map<Integer, Set<Integer>> graph) {

        //topo sort the graph and get the list
        List<Integer> sorted = topoSort(graph);
        //pick unvisited vertex and dfs, make all reachable vertex as visited, add the picked vertex to ans
        List<Integer> ans = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        for (Integer v : sorted) {
            if (visited.contains(v)) {
                continue;
            }
            ans.add(v);
            dfs(v, graph, visited, null);
        }
        return ans;
    }

    private List<Integer> topoSort(Map<Integer, Set<Integer>> graph) {
        Set<Integer> visited = new HashSet<>();
        LinkedList<Integer> sorted = new LinkedList<>();
        for (Integer vertex : graph.keySet()) {
            if (!visited.contains(vertex)) {
                dfs(vertex, graph, visited, sorted);
            }
        }
        return sorted;
    }

    private void dfs(Integer curr, Map<Integer, Set<Integer>> graph,
                              Set<Integer> visited, LinkedList<Integer> sorted) {
        visited.add(curr);
        for (Integer child : graph.getOrDefault(curr, Collections.emptySet())) {
            if (!visited.contains(child)) {
                dfs(child, graph, visited, sorted);
            }
        }
        if (sorted != null) {
            sorted.addFirst(curr);
        }
    }
}
