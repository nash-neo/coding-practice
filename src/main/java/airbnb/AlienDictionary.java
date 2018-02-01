package airbnb;

import java.util.*;

public class AlienDictionary {
    //treat each char as a node and "a before b" as the relation, than using topological sort
    //since the array of words forms a total order, we could just check every adjacent pair O(n), rather than each pair O(n^2)
    //could use dfs topological sort or bfs topological sort, also needs to detect whether there is a cycle
    //edge case: ["x", "x"]
    public String alienOrder(String[] words) {
        //build graph
        Map<Character, Set<Character>> graph = new HashMap<>();
        for (String word : words) { //this loop is needed for all isolated node in the graph
            for (int i = 0; i < word.length(); ++i) {
                graph.putIfAbsent(word.charAt(i), new HashSet<>());
            }
        }
        for (int i = 0; i < words.length - 1; ++i) {
            String before = words[i];
            String after = words[i+1];
            for (int j = 0; j < before.length() && j < after.length(); ++j){
                if (before.charAt(j) != after.charAt(j)) {
                    graph.putIfAbsent(before.charAt(j), new HashSet<>());
                    graph.get(before.charAt(j)).add(after.charAt(j));
                    break;
                }
            }
        }
        //topological sort by dfs
        Deque<Character> topoSorted = new ArrayDeque<>();
        Map<Character, Boolean> visited = new HashMap<>(); //using 3-way boolean: null WHITE, false: GRAY, true: BLACK
        for (Character ch : graph.keySet()) {
            if(!dfs(graph, ch, visited, topoSorted)){
                return "";
            }
        }
        //convert topoSorted charater to output
        StringBuilder ans = new StringBuilder();
        for (Character ch : topoSorted) {
            ans.append(ch);
        }
        return ans.toString();
    }

    // @return: is acyclic, false means there is a cycle
    private boolean dfs(Map<Character, Set<Character>> graph, Character ch, Map<Character, Boolean> visited, Deque<Character> topoSorted) {
        if (visited.containsKey(ch)) {
            return true;
        }
        visited.put(ch, false);
        //must use getOrDefault otherwise NPE when ch is leaf node
        for (Character next : graph.getOrDefault(ch, Collections.emptySet())){
            if (visited.get(next) != null && visited.get(next) == false) {
                return false;
            }
            if (!dfs(graph, next, visited, topoSorted)) {
                return false;
            }
        }
        visited.put(ch, true);
        topoSorted.addFirst(ch); //all descendants are visited, add itself to black
        return true;
    }
}