package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ReconstructItinerary {

    //assume all tickets must be used, then we must make sure each edge(ticket) is visited once and only once
    //assume tickets can have duplicates
    public List<String> findItinerary(String[][] tickets) {
        Map<String, Map<String, Integer>> graph = new HashMap<>(); //boolean for visited
        for (String[] ticket : tickets) {
            graph.putIfAbsent(ticket[0], new TreeMap<>()); //TreeSet for lexicographical sort
            int count = graph.get(ticket[0]).getOrDefault(ticket[1], 0) + 1;
            graph.get(ticket[0]).put(ticket[1], count);
        }
        List<String> path = new ArrayList<>();
        path.add("JFK");
        find("JFK", path, tickets.length + 1, graph);
        return path;
    }

    private boolean find(String curr, List<String> path, int size, Map<String, Map<String, Integer>> graph) {
        if (path.size() == size) {
            return true;
        }
        Map<String, Integer> tos = graph.get(curr);
        if (tos == null) {
            return false;
        }
        for (Map.Entry<String, Integer> entry : tos.entrySet()) {
            if (entry.getValue() == 0) { //skip if this edge has been used up
                continue;
            }
            String next = entry.getKey();
            path.add(next);
            graph.get(curr).put(next, entry.getValue() - 1);
            boolean found = find(next, path, size, graph);
            if (found) {
                return true;
            }
            graph.get(curr).put(next, entry.getValue() + 1); //revert
            path.remove(path.size()-1); //remove last
        }
        return false;
    }
}